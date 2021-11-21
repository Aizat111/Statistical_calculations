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
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import org.jfree.chart.*;

/**
 *
 * <p>Consturcts a frame on which the file menu, the buttons for saving the
 * image in a variety of formats and the plot can be placed.</p>
 */

public class PlotFrame extends JInternalFrame
{
    /**
     * A Swing GUI component for displaying the plot.
     */

    public ChartPanel plotPanel;

    /**
     * The plot to be displayed.
     */

    public JFreeChart plot;

    /**
     * The content panal.
     */

    private JPanel contentPane;

    /**
     * The menu bar.
     */

    private JMenuBar mb;

    /**
     * The file menu.
     */

    private JMenu fileMenu;

    /**
     * The menu item for saving image in pdf format.
     */

    private JMenuItem savePDFItem;

    /**
     * The menu item for saving image in svg format.
     */

    private JMenuItem saveSVGItem;

    /**
     * The menu item for saving image in png format.
     */

    private JMenuItem savePNGItem;

    /**
     * The menu item for saving image in jpeg format.
     */

    private JMenuItem saveJPEGItem;

    /**
     * The exit menu item.
     */

    private JMenuItem exitItem;

    /**
     * The button panel.
     */

    private JPanel buttonPanel;

    /**
     * The button for saving image in pdf format.
     */

    private JButton savePDFButton;

    /**
     * The button for saving image in svg format.
     */

    private JButton saveSVGButton;

    /**
     * The button for saving image in png format.
     */

    private JButton savePNGButton;

    /**
     * The button for saving image in jpeg format.
     */

    private JButton saveJPEGButton;

    /**
     * The exit button.
     */

    private JButton exitButton;

    /**
     * A standard frame for any JFreeChart plots.
     * @param title the plot title.
     * @param plot the plot to be displayed.
     * @param width the width of the panel on which the plot is placed.
     * @param height the height of the panel on which the plot is placed.
     */

    public PlotFrame(String title,
                     JFreeChart plot,
                     int width,
                     int height)
    {
        super(title, true, true, true, true);
        this.plot = plot;
        plotPanel = new ChartPanel(plot);
        plotPanel.setPreferredSize(new java.awt.Dimension(width, height));
        setJMenuBar(createMenuBar());
        contentPane = (JPanel)this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(plotPanel, BorderLayout.CENTER);
        contentPane.add(createButtonPanel(), BorderLayout.SOUTH);
    }

    /**
     * A standard frame for any JFreeChart plots with the specified width and
     * height.
     * @param title the plot title.
     * @param plot the plot to be displayed.
     */

    public PlotFrame(String title,
                     JFreeChart plot)
    {
        this(title, plot, 500, 270);
    }

    /**
     * A standard frame for any JFreeChart plots.
     * @param plot the plot to be displayed.
     */

    public PlotFrame(JFreeChart plot)
    {
        this("Plot Frame", plot, 500, 270);
    }

    /**
     * Creates a menu bar.
     * @return the menu bar.
     */

    private JMenuBar createMenuBar()
    {
        mb = new JMenuBar();
        fileMenu = new JMenu();
        fileMenu.setText("File");
        savePDFItem = new JMenuItem();
        savePDFItem.setText("Save As PDF");
        saveSVGItem = new JMenuItem();
        saveSVGItem.setText("Save As SVG");
        savePNGItem = new JMenuItem();
        savePNGItem.setText("Save As PNG");
        saveJPEGItem = new JMenuItem();
        saveJPEGItem.setText("Save As JPEG");
        exitItem = new JMenuItem();
        exitItem.setText("Exit");
        savePNGItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                savePNGItem_actionPerformed(e);
            }
        });
        saveJPEGItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveJPEGItem_actionPerformed(e);
            }
        });
        savePDFItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                savePDFItem_actionPerformed(e);
            }
        });
        saveSVGItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveSVGItem_actionPerformed(e);
            }
        });
        exitItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitItem_actionPerformed(e);
            }
        });
        fileMenu.add(savePDFItem);
        fileMenu.add(saveSVGItem);
        fileMenu.add(savePNGItem);
        fileMenu.add(saveJPEGItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        mb.add(fileMenu);

        return mb;
    }

    /**
     * Saves the plot in PNG format as the menu item is selected.
     * @param e a menu item action occurred.
     */

    void savePNGItem_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "png");
        }
        catch (IOException epng)
        {
            epng.printStackTrace();
        }
    }

    /**
     * Saves the plot in JPEG format as the menu item is selected.
     * @param e a menu item action occurred.
     */

    void saveJPEGItem_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "jpeg");
        }
        catch (IOException epng)
        {
            epng.printStackTrace();
        }
    }

    /**
     * Saves the plot in PDF format as the menu item is selected.
     * @param e a menu item action occurred.
     */

    void savePDFItem_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "pdf");
        }
        catch (IOException epng)
        {
            epng.printStackTrace();
        }
    }

    /**
     * Saves the plot in SVG format as the menu item is selected.
     * @param e a menu item action occurred.
     */

    void saveSVGItem_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "svg");
        }
        catch (IOException epng)
        {
            epng.printStackTrace();
        }
    }

    /**
     * Exits the current frame.
     * @param e a menu item action occurred.
     */

    void exitItem_actionPerformed(ActionEvent e)
    {
        this.dispose();
    }

    /**
     * Creates a Panel with several buttons.
     * @return the button panel.
     */

    private JPanel createButtonPanel()
    {
        buttonPanel = new JPanel();
        savePDFButton = new JButton();
        saveSVGButton = new JButton();
        savePNGButton = new JButton();
        saveJPEGButton = new JButton();
        exitButton = new JButton();
        savePDFButton.setText("Save As PDF");
        saveSVGButton.setText("Save As SVG");
        savePNGButton.setText("Save As PNG");
        saveJPEGButton.setText("Save As JPEG");
        exitButton.setText("Exit");
        savePNGButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                savePNGButton_actionPerformed(e);
            }
        });
        saveJPEGButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveJPEGButton_actionPerformed(e);
            }
        });
        savePDFButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                savePDFButton_actionPerformed(e);
            }
        });
        saveSVGButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveSVGButton_actionPerformed(e);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButton_actionPerformed(e);
            }
        });
        buttonPanel.add(savePDFButton);
        buttonPanel.add(saveSVGButton);
        buttonPanel.add(savePNGButton);
        buttonPanel.add(saveJPEGButton);
        buttonPanel.add(exitButton);

        return buttonPanel;
    }

    /**
     * Saves the plot in PNG format as the button is pressed.
     * @param e a button action occurred.
     */

    void savePNGButton_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "png");
        }
        catch (IOException ePng)
        {
            ePng.printStackTrace();
        }
    }

    /**
     * Saves the plot in JPEG format as the button is pressed.
     * @param e a button action occurred.
     */

    void saveJPEGButton_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "jpeg");
        }
        catch (IOException eJpeg)
        {
            eJpeg.printStackTrace();
        }
    }

    /**
     * Saves the plot in PDF format as the button is pressed.
     * @param e a button action occurred.
     */

    void savePDFButton_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "pdf");
        }
        catch (IOException ePdf)
        {
            ePdf.printStackTrace();
        }
    }

    /**
     * Saves the plot in SVG format as the button is pressed.
     * @param e a button action occurred.
     */

    void saveSVGButton_actionPerformed(ActionEvent e)
    {
        try
        {
            new SavePlot(plotPanel.getWidth(),
                    plotPanel.getHeight()).saveAs(plot, "svg");
        }
        catch (IOException eSvg)
        {
            eSvg.printStackTrace();
        }
    }

    /**
     * Exits the current frame.
     * @param e a button action occurred.
     */

    void exitButton_actionPerformed(ActionEvent e)
    {
        this.dispose();
    }

}
