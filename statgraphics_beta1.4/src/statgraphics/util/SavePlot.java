package statgraphics.util;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

import java.awt.*;
import java.awt.geom.*;
import java.io.*;

import javax.swing.*;

import com.lowagie.text.*;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;

import org.apache.batik.svggen.*;

import org.jfree.chart.*;
import org.jfree.ui.*;

/**
 *
 * <p>This class contains a collection of utility methods for saving a plot to
 * a file in different formats, including PNG, JPEG, PDF, and SVG. </p>
 */

public class SavePlot extends JPanel
{

    /**
     * Saves a plot to a file in different formats, including PNG, JPEG, PDF,
     * and SVG.
     * @param width the width of the panel on which the plot is placed.
     * @param height the height of the panel on which the plot is placed.
     */

    public SavePlot(int width,
                    int height)
    {
        this.setSize(width, height);
    }

    /**
     * Saves a plot to a file in different formats, including PNG, JPEG, PDF,
     * and SVG.
     */

    public SavePlot()
    {
        this(500, 270);
    }

    /**
     * Saves a plot to a file in specific format.
     * @param plot the plot to be saved.
     * @param filetype the specific format in which the file to be saved,
     * <br>            "png", "PNG": PNG format;
     * <br>            "jpeg", "JPEG": JPEG format;
     * <br>            "pdf", "PDF": PDF format;
     * <br>            "svg", "SVG": SVG format.
     * @param width the width of the panel on which the plot is placed.
     * @param height the height of the panel on which the plot is placed.
     * @throws IOException signals that an I/O exception of some sort has
     *                     occurred.
     */

    public void saveAs(JFreeChart plot,
                       String filetype,
                       int width,
                       int height)
            throws IOException
    {
        JFileChooser fileChooser = new JFileChooser();
        ExtensionFileFilter filter =
                new ExtensionFileFilter(filetype.toUpperCase() + " Image Files",
                                        "." + filetype);
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.addChoosableFileFilter(new ExtensionFileFilter("All files",
                ""));
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().getPath();
            if (!filename.endsWith("." + filetype))
            {
                filename = filename + "." + filetype;
            }
            if (filetype.equalsIgnoreCase("png"))
            {
                ChartUtilities.saveChartAsPNG(new File(filename), plot, width,
                                              height);
            }
            else if (filetype.equalsIgnoreCase("jpeg"))
            {
                ChartUtilities.saveChartAsJPEG(new File(filename), plot, width,
                                               height);
            }
            else if (filetype.equalsIgnoreCase("pdf"))
            {
                savePlotAsPDF(new File(filename), plot, width, height,
                              new DefaultFontMapper());
            }
            else
            {
                savePlotAsSVG(new File(filename), plot, width, height);
            }
        }
    }

    /**
     * Saves a plot to a file in specific format.
     * @param plot the plot to be saved.
     * @param filetype the specific format in which the file to be saved, <br>
     *        "png", "PNG": PNG format; <br>
     *        "jpeg", "JPEG": JPEG format; <br>
     *        "pdf", "PDF": PDF format; <br>
     *        "svg", "SVG": SVG format.
     * @throws IOException signals that an I/O exception of some sort has
     *                     occurred.
     */

    public void saveAs(JFreeChart plot,
                       String filetype)
            throws IOException
    {
        saveAs(plot, filetype, getWidth(), getHeight());
    }

    /**
     * Saves a plot to a PDF file.
     * @param file the file.
     * @param plot the plot.
     * @param width the plot width.
     * @param height the plot height.
     * @param mapper a BaseFont which has similar properties to the provided
     *               Font.
     * @throws IOException signals that an I/O exception of some sort has
     *                     occurred.
     */

    public static void savePlotAsPDF(File file,
                                     JFreeChart plot,
                                     int width,
                                     int height,
                                     FontMapper mapper)
            throws IOException
    {
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        writePlotAsPDF(out, plot, width, height, mapper);
        out.close();
    }

    /**
     * Writes a plot to an output stream in PDF format.
     * @param out the output stream.
     * @param plot the plot.
     * @param width the image width.
     * @param height the image height.
     * @param mapper a BaseFont which has similar properties to the provided
     *               Font.
     * @throws IOException signals that an I/O exception of some sort has
     *                     occurred.
     */

    public static void writePlotAsPDF(OutputStream out,
                                      JFreeChart plot,
                                      int width,
                                      int height,
                                      FontMapper mapper)
            throws IOException
    {
        Rectangle pagesize = new Rectangle(width, height);
        Document document = new Document(pagesize, 50, 50, 50, 50);
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.addAuthor("JFreeChart");
            document.addSubject("Demonstration");
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(width, height);
            Graphics2D g2 = tp.createGraphics(width, height, mapper);
            Rectangle2D r2D = new Rectangle2D.Double(0, 0, width, height);
            plot.draw(g2, r2D);
            g2.dispose();
            cb.addTemplate(tp, 0, 0);
        }
        catch (DocumentException de)
        {
            System.err.println(de.getMessage());
        }
        document.close();
    }

    /**
     * Saves a plot to a SVG file.
     * @param file the file.
     * @param plot the plot.
     * @param width the image width.
     * @param height the image height.
     * @throws IOException signals that an I/O exception of some sort has
     *                     occurred.
     */

    public static void savePlotAsSVG(File file,
                                     JFreeChart plot,
                                     int width,
                                     int height)
            throws IOException
    {
        org.w3c.dom.DOMImplementation domImpl =
                org.apache.batik.dom.GenericDOMImplementation.
                getDOMImplementation();
        org.w3c.dom.Document document =
            domImpl.createDocument(null, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        svgGenerator.getGeneratorContext().setPrecision(6);
        plot.draw(svgGenerator,
                  new Rectangle2D.Double(0, 0, width, height), null);
        boolean isCSS = true;
        Writer out = new OutputStreamWriter(new FileOutputStream(file),
                                            "UTF-8");
        svgGenerator.stream(out, isCSS);
    }

}
