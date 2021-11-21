package statgraphics.util;

/**
 * <p>Title: statsoft</p>
 * <p>Description: This package contains the classes for creating Java
 * Statistical Software.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University</p>
 * @author Wen Hsiang Wei
 * @version 1.4
 *
 */

import java.awt.*;

import javax.swing.*;

/**
 * <p> Creates the plot frame for statistical analysis.</p>
 */

public class PlotFrameFactory
{
    /**
     * The plot frame.
     */

    public PlotFrame plotFrame;

    /**
     * The desktoppane.
     */

    private JDesktopPane desktopPane;

    /**
     * Default PlotFrameFactory constructor.
     */

    public PlotFrameFactory() {}

    /**
     * Places multiple plot frames in a specified container.
     * @param plotFrame the plot frames,
     * <br>             plotFrame[i]: the (i+1)'th plot frame.
     * @param frame the container
     */

    public void putPlotFrame(PlotFrame[] plotFrame,
                             JFrame frame)
    {
        desktopPane = new JDesktopPane();
        for (int i = 0; i < plotFrame.length; i++)
        {
            desktopPane.add(plotFrame[i]);
            plotFrame[i].pack();
            plotFrame[i].setVisible(true);
        }
        frame.setSize(800, 600);
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(desktopPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Places multiple plot frames in a container.
     * @param plotFrame the plot frames,
     * <br>             plotFrame[i]: the (i+1)'th plot frame.
     */

    public void putPlotFrame(PlotFrame[] plotFrame)
    {
        putPlotFrame(plotFrame, new JFrame());
    }

    /**
     * Places a plot frame in a specified container.
     * @param plotFrame the plot frame.
     * @param frame the container
     */

    public void putPlotFrame(PlotFrame plotFrame,
                             JFrame frame)
    {
        putPlotFrame(new PlotFrame[] {plotFrame}, frame);
    }

    /**
     * Places a plot frame in a container.
     * @param plotFrame the plot frame.
     */

    public void putPlotFrame(PlotFrame plotFrame)
    {
        putPlotFrame(plotFrame, new JFrame());
    }

}
