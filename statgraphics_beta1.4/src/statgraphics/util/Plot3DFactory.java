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
import java.util.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;

import statgraphics.*;
import static statgraphics.util.Argument.*;
import static statgraphics.util.PlotType.*;

/**
 *
 * <p> This class contains a collection of utility methods
 *  for creating some 3D statistical plots.</p>
 */

public class Plot3DFactory extends PlotFactory
{

    /**
     * Default Plot3DFactory constructor.
     */

    public Plot3DFactory() {}

    /**
     * Creates a plot given the input arguments and data.
     * @param argument the arguments with the following choices:
     * <br> 3D pie plot: TITLE;
     * <br> 3D bar plot: DATANAMES, TITLE, XLABEL, YLABEL.
     * <br><br>
     * @param dataObject the input data.
     * @return the created plot.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public JFreeChart createPlot(Hashtable argument,
                                 Object ...dataObject)
    {
        switch ((PlotType) argument.get(Argument.PLOT_TYPE))
        {
            case PIE3D:
                plot = createPie3DPlot((String) argument.get(TITLE),
                                       (String[]) dataObject[0],
                                       (double[]) dataObject[1]);
                break;
            case BAR3D:
                plot = createBar3DPlot((String[]) argument.get(DATA_NAMES),
                                       (String) argument.get(TITLE),
                                       (String) argument.get(XLABEL),
                                       (String) argument.get(YLABEL),
                                       (String[]) dataObject[0],
                                       (double[][]) dataObject[1]);
        }

        return plot;
    }

    /**
     * Creates a 3D pie plot.
     * @param title the plot title.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @return the created 3D pie plot.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public JFreeChart createPie3DPlot(String title,
                                      String[] category,
                                      double[] counts)
    {
        return createPie3DPlot(title,
                               DataCreator.createDataset(category, counts));
    }

    /**
     * Creates a 3D pie plot using a PieDataset interface.
     * @param title the plot title.
     * @param dataset the dataset for the 3D pie plot.
     * @return the created 3D pie plot.
     */

    public JFreeChart createPie3DPlot(String title,
                                      PieDataset dataset)
    {
        plot = ChartFactory.createPieChart3D(
            title,
            dataset,
            true,
            true,
            false);
        plot.setBackgroundPaint(Color.white);
        PiePlot3D piePlot = (PiePlot3D) plot.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        piePlot.setStartAngle(270);
        piePlot.setForegroundAlpha(0.5f);

        return plot;
    }

    /**
     * Creates a 3D bar plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created 3D pie plot.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public JFreeChart createBar3DPlot(String[] dataNames,
                                      String title,
                                      String xLabel,
                                      String yLabel,
                                      String[] category,
                                      double[] ...data)
    {
        return createBar3DPlot(title, xLabel, yLabel, DataCreator.
                               createDataset(dataNames, category, data));
    }

    /**
     * Creates a 3D bar plot using a CategoryDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the 3D pie plot.
     * @return the created 3D pie plot.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public JFreeChart createBar3DPlot(String title,
                                      String xLabel,
                                      String yLabel,
                                      CategoryDataset dataset)
    {
        plot = ChartFactory.createBarChart3D(
            title,
            xLabel,
            yLabel,
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false);
        CategoryPlot categoryPlot = plot.getCategoryPlot();
        CategoryAxis axis = categoryPlot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.
            createUpRotationLabelPositions(Math.PI / 8.0));
        CategoryItemRenderer renderer = categoryPlot.getRenderer();
        renderer.setItemLabelsVisible(true);
        BarRenderer barRenderer = (BarRenderer) renderer;
        barRenderer.setMaximumBarWidth(0.05);

        return plot;
    }

    /**
     * Deserializes a plot object saved in the specified file.
     * @param fileName the file name.
     * @return the deserialized plot object.
     */

    public JFreeChart outputDeserialized(String fileName)
    {
        return (JFreeChart) super.plotDeserialized(fileName);
    }

}
