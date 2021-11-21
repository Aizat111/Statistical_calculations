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
import java.text.*;
import java.util.*;

import org.jfree.chart.*;
import org.jfree.chart.annotations.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.title.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import org.jfree.data.statistics.*;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

import statgraphics.*;
import static statgraphics.util.Argument.*;
import static statgraphics.util.PlotType.*;

/**
 *
 * <p> This class contains a collection of utility methods for creating some 2D
 * statistical plots.</p>
 */

public class Plot2DFactory extends PlotFactory
{

    /**
     * Default Plot2DFactory constructor.
     */

    public Plot2DFactory()
    {}

    /**
     * Creates a plot given the input arguments and data.
     * @param argument the arguments with the following choices:
     * <br> Bar plot: DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Box plot: DATANAMES;
     * <br> Box plot (time): TITLE, XLABEL, YLABEL;
     * <br> Combined line and bar plot: IS_LINE_PLOT_UPPER, DATANAMES, TITLE,
     *                                  XLABEL, YLABEL;
     * <br> Histogram: DATANAMES, BIN_NUMBER, FREQUENCY_CHOICE, TITLE, XLABEL,
     *                 YLABEL;
     * <br> Line plot: DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Line plot (category): DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Scatter plot: DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Line plot with points: TITLE, XLABEL, YLABEL;
     * <br> Survival estimate plot: DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Time series plot: DATANAMES, TITLE, XLABEL, YLABEL;
     * <br> Pie plot: TITLE.
     * <br><br>
     * @param dataObject the input data.
     * @return the created plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the length of the input
     *                                     data series.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same sample size.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     * @exception IllegalArgumentExceptio the sortedTime vector and
     *                                    sortedSurvivalEstimate vector must
     *                                    have the same length.
     * @exception IllegalArgumentException the number of time series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the data series should
     *                                     be equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to 6.
     */

    public JFreeChart createPlot(Hashtable argument,
                                 Object ...dataObject)
    {
        switch ((PlotType) argument.get(PLOT_TYPE))
        {
            case BAR:
                plot = createBarPlot((String[]) argument.get(DATA_NAMES),
                                     (String) argument.get(TITLE),
                                     (String) argument.get(XLABEL),
                                     (String) argument.get(YLABEL),
                                     (String[]) dataObject[0],
                                     (double[][]) dataObject[1]);
                break;
            case BOX:
                plot = createBoxPlot((String[]) argument.get(DATA_NAMES),
                                     (double[][]) dataObject[1]);
            case BOX_DATE:
                plot = createBoxPlot((String) argument.get(TITLE),
                                     (String) argument.get(XLABEL),
                                     (String) argument.get(YLABEL),
                                     (Date[]) dataObject[0],
                                     (double[][]) dataObject[1]);
                break;
            case HISTOGRAM:
                plot = createHistogram((String[]) argument.get(DATA_NAMES),
                                       ((Integer) argument.get(BIN_NUMBER)).
                                       intValue(),
                                       (String) argument.get(FREQUENCY_CHOICE),
                                       (String) argument.get(TITLE),
                                       (String) argument.get(XLABEL),
                                       (String) argument.get(YLABEL),
                                       (double[][]) dataObject[0]);
                break;
            case LINE:
                plot = createLinePlot((String[]) argument.get(DATA_NAMES),
                                      (String) argument.get(TITLE),
                                      (String) argument.get(XLABEL),
                                      (String) argument.get(YLABEL),
                                      (double[][]) dataObject[0],
                                      (double[][]) dataObject[1]);
                break;
            case LINE_CATEGORY:
                plot = createLinePlot((String[]) argument.get(DATA_NAMES),
                                      (String) argument.get(TITLE),
                                      (String) argument.get(XLABEL),
                                      (String) argument.get(YLABEL),
                                      (String[]) dataObject[0],
                                      (double[][]) dataObject[1]);
                break;
            case SCATTER:
                plot = createScatterPlot((String[]) argument.get(DATA_NAMES),
                                         (String) argument.get(TITLE),
                                         (String) argument.get(XLABEL),
                                         (String) argument.get(YLABEL),
                                         (double[][]) dataObject[0],
                                         (double[][]) dataObject[1]);
                break;
            case LINE_POINT:
                plot = createLineAndPointsPlot((String) argument.get(TITLE),
                                               (String) argument.get(XLABEL),
                                               (String) argument.get(YLABEL),
                                               (double[]) dataObject[0],
                                               (double[]) dataObject[1],
                                               (double[]) dataObject[2],
                                               (double[]) dataObject[3]);
                break;
            case SURVIVAL:
                plot = createSurvivalEstimatePlot((String[]) argument.
                                                  get(DATA_NAMES),
                                                  (String) argument.get(TITLE),
                                                  (String) argument.get(XLABEL),
                                                  (String) argument.get(YLABEL),
                                                  (double[][]) dataObject[0],
                                                  (double[][]) dataObject[1]);
                break;
            case TIME_SERIES:
                plot = createTimeSeriesPlot((String[]) argument.get(DATA_NAMES),
                                            (String) argument.get(TITLE),
                                            (String) argument.get(XLABEL),
                                            (String) argument.get(YLABEL),
                                            (int[][][]) dataObject[0],
                                            (double[][]) dataObject[1]);
                break;
            case PIE:
                plot = createPiePlot((String) argument.get(TITLE),
                                     (String[]) dataObject[0],
                                     (double[]) dataObject[1]);
                break;
            case COMBINED_LINE_BAR:
                plot = createCombinedLineBarPlot(
                        (Boolean) argument.get(IS_LINE_PLOT_UPPER),
                        ((String[][]) argument.get(DATA_NAMES))[0],
                        ((String[][]) argument.get(DATA_NAMES))[1],
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        ((String[]) argument.get(YLABEL))[0],
                        ((String[]) argument.get(YLABEL))[0],
                        (String[]) dataObject[0],
                        (double[][]) dataObject[1],
                        (double[][]) dataObject[2]);
                break;
        }

        return plot;
    }

    /**
     * Creates a 2D pie plot.
     * @param title the plot title.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @return the created bar plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createPiePlot(String title,
                                    String[] category,
                                    double[] counts)
    {
        return createPiePlot(title,
                             DataCreator.createDataset(category, counts));
    }

    /**
     * Creates a 2D pie plot using a PieDataset interface.
     * @param title the plot title.
     * @param dataset the dataset for the pie plot.
     * @return the created pie plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createPiePlot(String title,
                                    PieDataset dataset)
    {
        plot = ChartFactory.createPieChart(
                title,
                dataset,
                true,
                true,
                false);
        TextTitle textTitle = plot.getTitle();
        textTitle.setToolTipText("A title tooltip!");
        PiePlot piePlot = (PiePlot) plot.getPlot();
        piePlot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        piePlot.setNoDataMessage("No data available");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02);

        return plot;
    }

    /**
     * Creates a bar plot.
     * @param dataNames the names of the data series,
     *                  dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created bar plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createBarPlot(String[] dataNames,
                                    String title,
                                    String xLabel,
                                    String yLabel,
                                    String[] category,
                                    double[] ...data)
    {
        return createBarPlot(title, xLabel, yLabel,
                             DataCreator.
                             createDataset(dataNames, category, data));
    }

    /**
     * Creates a bar plot using a CategoryDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the bar plot.
     * @return the created bar plot.
     */

    public JFreeChart createBarPlot(String title,
                                    String xLabel,
                                    String yLabel,
                                    CategoryDataset dataset)
    {
        plot = ChartFactory.createBarChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        plot.setBackgroundPaint(new Color(0xBBBBDD));
        CategoryPlot categoryPlot = plot.getCategoryPlot();
        NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        renderer.setDrawBarOutline(false);

        return plot;
    }

    /**
     * Creates a box plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created box plot.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createBoxPlot(String[] dataNames,
                                    String title,
                                    String xLabel,
                                    String yLabel,
                                    double[] ...data)
    {
        return plot = createBoxPlot(title, xLabel, yLabel,
                                    DataCreator.createDataset(dataNames, data));
    }

    /**
     * Creates a box plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created box plot.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createBoxPlot(String[] dataNames,
                                    double[] ...data)
    {
        return plot = createBoxPlot(DataCreator.createDataset(dataNames, data));
    }

    /**
     * Creates a box plot using a BoxAndWhiskerCategoryDataset
     * interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the box plot.
     * @return the created box plot.
     */

    public JFreeChart createBoxPlot(String title,
                                    String xLabel,
                                    String yLabel,
                                    BoxAndWhiskerCategoryDataset dataset)
    {
        CategoryAxis domainAxis = new CategoryAxis(xLabel);
        NumberAxis rangeAxis = new NumberAxis(yLabel);
        CategoryItemRenderer renderer = new BoxAndWhiskerRenderer();
        CategoryPlot categoryPlot = new CategoryPlot(dataset, domainAxis,
                rangeAxis, renderer);
        plot = new JFreeChart(title, categoryPlot);
        plot.setBackgroundPaint(Color.white);
        categoryPlot.setBackgroundPaint(Color.lightGray);
        categoryPlot.setDomainGridlinePaint(Color.white);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeGridlinePaint(Color.white);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return plot;
    }

    /**
     * Creates a box plot using a BoxAndWhiskerCategoryDataset interface
     * with the default title "Box Plot", null x-label and y-label "Value".
     * @param dataset the dataset for the box plot.
     * @return the created box plot.
     */

    public JFreeChart createBoxPlot(BoxAndWhiskerCategoryDataset dataset)
    {
        return createBoxPlot("Box Plot", null, "Value", dataset);
    }

    /**
     * Creates box plots corresponding to different times.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param time the dates assoicated with the data series,
     * <br>        time[j]: the date associated with data[j].
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created box plot.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the length of the input
     *                                     data series.
     */

    public JFreeChart createBoxPlot(String title,
                                    String xLabel,
                                    String yLabel,
                                    Date[] time,
                                    double[] ...data)
    {
        return createBoxPlot(title, xLabel, yLabel,
                             DataCreator.createDataset(time, data));
    }

    /**
     * Creates a box plot using a BoxAndWhiskerXYDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the box plot.
     * @return the created box plot.
     */

    public JFreeChart createBoxPlot(String title,
                                    String xLabel,
                                    String yLabel,
                                    BoxAndWhiskerXYDataset dataset)
    {
        plot = ChartFactory.createBoxAndWhiskerChart(
                title,
                xLabel,
                yLabel,
                dataset,
                true);
        plot.setBackgroundPaint(new Color(0xBBBBDD));

        return plot;
    }

    /**
     * Creates a histogram.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the number of bins.
     * @param frequencyChoice the specification of the frequency with the
     *                        choices "Frequency" or "Relative Frequency".
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created histogram.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createHistogram(String[] dataNames,
                                      int binNumber,
                                      String frequencyChoice,
                                      String title,
                                      String xLabel,
                                      String yLabel,
                                      double[] ...data)
    {
        return createHistogram(title, xLabel, yLabel, DataCreator.
                               createDataset(dataNames, binNumber,
                                             frequencyChoice, data));
    }

    /**
     * Creates a histogram with the default title "Histogram", null x-label,
     * and y-label "Value".
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the number of bins.
     * @param frequencyChoice the specification of the frequency with the
     *                        choices "Frequency" or "Relative Frequency".
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created histogram.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createHistogram(String[] dataNames,
                                      int binNumber,
                                      String frequencyChoice,
                                      double[] ...data)
    {
        return createHistogram(DataCreator.createDataset(dataNames,
                binNumber, frequencyChoice, data));
    }

    /**
     * Creates a histogram using an IntervalXYDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the data set for the histogram.
     * @return the created histogram.
     */

    public JFreeChart createHistogram(String title,
                                      String xLabel,
                                      String yLabel,
                                      IntervalXYDataset dataset)
    {
        plot = ChartFactory.createHistogram(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
        plot.getXYPlot().setForegroundAlpha(0.75f);

        return plot;
    }

    /**
     * Creates a histogram using an IntervalXYDataset interface with
     * the default title "Histogram", null x-label and y-label "Value".
     * @param dataset the data set for the histogram.
     * @return the created histogram.
     */

    public JFreeChart createHistogram(IntervalXYDataset dataset)
    {
        return createHistogram("Histogram", null, "Value", dataset);
    }

    /**
     * Creates a line plot.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created line plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createLinePlot(String[] dataNames,
                                     String title,
                                     String xLabel,
                                     String yLabel,
                                     String[] category,
                                     double[] ...data)
    {
        return createLinePlot(title, xLabel, yLabel, DataCreator.
                              createDataset(dataNames, category, data));
    }

    /**
     * Creates a line plot using a CategroyDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the data set for the line plot.
     * @return the created line plot.
     */

    public JFreeChart createLinePlot(String title,
                                     String xLabel,
                                     String yLabel,
                                     CategoryDataset dataset)
    {
        plot = ChartFactory.createLineChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        plot.setBackgroundPaint(Color.white);
        CategoryPlot categoryPlot = (CategoryPlot) plot.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        categoryPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        categoryPlot.setDomainGridlinePaint(Color.white);
        categoryPlot.setRangeGridlinePaint(Color.white);
        final NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        final LineAndShapeRenderer renderer =
                (LineAndShapeRenderer) categoryPlot.getRenderer();
        renderer.setDrawOutlines(true);
        renderer.setShapesFilled(true);

        return plot;
    }

    /**
     * Creates a line plot using a XYDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the data set for the line plot.
     * @return the created line plot.
     */

    public JFreeChart createLinePlot(String title,
                                     String xLabel,
                                     String yLabel,
                                     XYDataset dataset)
    {
        plot = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        return plot;
    }

    /**
     * Creates a line plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the x(-coordinate) data values.
     * @param yData the y(-coordinate) data values.
     * @return the created line plot.
     * @exception  IllegalArgumentException the input datasets should have the
     *                                      same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same sample size.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createLinePlot(String[] dataNames,
                                     String title,
                                     String xLabel,
                                     String yLabel,
                                     double[][] xData,
                                     double[][] yData)
    {
        return createLinePlot(title, xLabel, yLabel,
                              DataCreator.createDataset(
                                      dataNames, xData, yData));
    }

    /**
     * Creates a scatter plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the data series for the x-coordinate,
     * <br>         xData[j]: the (j+1)'th data series.
     * @param yData the data series for the y-coordinate,
     * <br>         yData[j]: the (j+1)'th data series.
     * @return the created scatter plot.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same sample size.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createScatterPlot(String[] dataNames,
                                        String title,
                                        String xLabel,
                                        String yLabel,
                                        double[][] xData,
                                        double[][] yData)
    {
        return createScatterPlot(title, xLabel, yLabel, DataCreator.
                                 createDataset(dataNames, xData, yData));
    }

    /**
     * Creates a scatter plot using a XYDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the scatter plot.
     * @return the created scatter plot.
     */

    public JFreeChart createScatterPlot(String title,
                                        String xLabel,
                                        String yLabel,
                                        XYDataset dataset)
    {
        plot = ChartFactory.createScatterPlot(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        NumberAxis domainAxis = (NumberAxis) plot.getXYPlot().getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);

        return plot;
    }

    /**
     * Creates a regression plot with a fitted line.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param p1 the start of the line,
     * <br>      (p1[0],p1[1]) is the starting point.
     * @param p2 the end of the line,
     * <br>      (p2[0],p2[1]) is the end point.
     * @param xData the data for the x-coordinate.
     * @param yData the data for the y-coordinate.
     * @return the created regression plot.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     */

    public JFreeChart createLineAndPointsPlot(String title,
                                              String xLabel,
                                              String yLabel,
                                              double[] p1,
                                              double[] p2,
                                              double[] xData,
                                              double[] yData)
    {
        return createLineAndPointsPlot(title, xLabel, yLabel, p1, p2,
                                       DataCreator.
                                       createDataset("Data", xData, yData));
    }

    /**
     * Creates a regression plot with a fitted line using a XYDataset
     * interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param p1 the start of the line,
     * <br>      (p1[0],p1[1]) is the starting point.
     * @param p2 the end of the line,
     * <br>      (p2[0],p2[1]) is the end point.
     * @param dataset the dataset for the regression plot.
     * @return the created regression plot.
     */

    public JFreeChart createLineAndPointsPlot(String title,
                                              String xLabel,
                                              String yLabel,
                                              double[] p1,
                                              double[] p2,
                                              XYDataset dataset)
    {
        plot = ChartFactory.createScatterPlot(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        plot.getLegend().setLegendItemGraphicLocation(RectangleAnchor.
                BOTTOM_RIGHT);
        XYPlot xYplot = plot.getXYPlot();
        XYLineAnnotation regressionLine = new XYLineAnnotation(p1[0], p1[1],
                p2[0], p2[1], new BasicStroke(), Color.BLUE);
        xYplot.addAnnotation((XYAnnotation) regressionLine);
        ValueAxis rangeAxis = xYplot.getRangeAxis();
        ValueAxis domainAxis = xYplot.getDomainAxis();
        xYplot.setDomainAxis(domainAxis);
        xYplot.setRangeAxis(rangeAxis);

        return plot;
    }

    /**
     * Creates a survival estimate plot.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param sortedTime the series for survival times in ascending order.
     * @param sortedSurvivalEstimate the survival estimates in descending order.
     * @return the created Kaplan-Meier estimate plot.
     * @exception IllegalArgumentExceptio the sortedTime vector and
     *                                    sortedSurvivalEstimate vector must
     *                                    have the same length.
     */

    public JFreeChart createSurvivalEstimatePlot(String title,
                                                 String xLabel,
                                                 String yLabel,
                                                 double[] sortedTime,
                                                 double[]
                                                 sortedSurvivalEstimate)
    {
        return createSurvivalEstimatePlot(title, xLabel, yLabel,
                                          DataCreator.createDataset(
                                                  "Survival Estimate",
                                                  sortedTime,
                                                  sortedSurvivalEstimate));
    }

    /**
     * Creates a survival estimate plot.
     * @param dataNames the names of these series,
     * <br>             dataNames[j]: the name of the (j+1)'th series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param sortedTime the series of survival times in ascending order,
     * <br>              sortedTime[j]: the (j+1)'th series of survival times.
     * @param sortedSurvivalEstimate the series of the survival estimates in
     *                               descending order,
     * <br>                          sortedSurvivalEstimate[j]: the (j+1)'th
     *                                             series of survival estimates.
     * @return the created Kaplan-Meier estimate plot.
     * @exception IllegalArgumentExceptio the sortedTime vector and
     *                                    sortedSurvivalEstimate vector must
     *                                    have the same length.
     */

    public JFreeChart createSurvivalEstimatePlot(String[] dataNames,
                                                 String title,
                                                 String xLabel,
                                                 String yLabel,
                                                 double[][] sortedTime,
                                                 double[][]
                                                 sortedSurvivalEstimate)
    {
        return createSurvivalEstimatePlot(title, xLabel, yLabel, DataCreator.
                                          createDataset(dataNames, sortedTime,
                sortedSurvivalEstimate));
    }

    /**
     * Creates a survival estimate plot using a XYDataset interface.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the data set for Kaplan-Meier estimate plot.
     * @return the created Kaplan-Meier estimate plot.
     */

    public JFreeChart createSurvivalEstimatePlot(String title,
                                                 String xLabel,
                                                 String yLabel,
                                                 XYDataset dataset)
    {
        plot = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        XYStepRenderer renderer = new XYStepRenderer();
        renderer.setStroke(new BasicStroke(1.0f));
        renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
        ((XYPlot) plot.getPlot()).setRenderer(renderer);

        return plot;
    }

    /**
     * Creates a time series plot.
     * @param dataNames the names of data series,
     * <br>             dataNames[j]: the name of the (j+1)'th time series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param time the dates assoicated with the collection of time series,
     * <br>        time[j][i][0]: the second (0-59) associated with the i'th
     *                            data of the j'th time series;
     * <br>        time[j][i][1]: the minute (0-59) associated with the i'th
     *                            data of the j'th time series;
     * <br>        time[j][i][2]: the hour (0-23) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][3]: the day (1-31) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][4]: the month (1-12) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][5]: the year (1900-9999) associated with the i'th
     *                            data of the j'th time series.
     * @param data a collection of time series,
     *             data[j]: the (j+1)'th data series.
     * @return the created time series plot.
     * @exception IllegalArgumentException the number of time series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the data series should
     *                                     be equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to 6.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createTimeSeriesPlot(String[] dataNames,
                                           String title,
                                           String xLabel,
                                           String yLabel,
                                           int[][][] time,
                                           double[] ...data)
    {
        return createTimeSeriesPlot(title, xLabel, yLabel, DataCreator.
                                    createDataset(dataNames, time, data));
    }

    /**
     * Creates a time series plot.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param dataset the dataset for the time series plot.
     * @return the created regression plot.
     */

    public JFreeChart createTimeSeriesPlot(String title,
                                           String xLabel,
                                           String yLabel,
                                           XYDataset dataset)
    {
        plot = ChartFactory.createTimeSeriesChart(
                title,
                xLabel,
                yLabel,
                dataset,
                true,
                true,
                false);
        plot.setBackgroundPaint(Color.white);
        XYPlot xYplot = (XYPlot) plot.getPlot();
        xYplot.setBackgroundPaint(Color.lightGray);
        xYplot.setDomainGridlinePaint(Color.white);
        xYplot.setRangeGridlinePaint(Color.white);
        xYplot.setDomainCrosshairVisible(true);
        xYplot.setRangeCrosshairVisible(true);
        XYItemRenderer r = xYplot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }
        DateAxis axis = (DateAxis) xYplot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return plot;
    }

    /**
     * Creates a combined line and bar plot using a CategoryDataset interface.
     * @param isLinePlotUpper the boolean indicating whether the upper plot is
     *                        the line plot.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param linePlotYLabel the label for the y-coordinate of the line plot.
     * @param barPlotYLabel the label for the y-coordinate of the bar plot.
     * @param linePlotData the dataset for the line plot.
     * @param barPlotData the dataset for the bar plot.
     * @return the created combined line and bar plot.
     */

    public JFreeChart createCombinedLineBarPlot(boolean isLinePlotUpper,
                                                String title,
                                                String xLabel,
                                                String linePlotYLabel,
                                                String barPlotYLabel,
                                                CategoryDataset linePlotData,
                                                CategoryDataset barPlotData)
    {
        NumberAxis linePlotRangeAxis = new NumberAxis(linePlotYLabel);
        linePlotRangeAxis.setStandardTickUnits(
            NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer linePlotRenderer = new LineAndShapeRenderer();
        linePlotRenderer.setBaseToolTipGenerator(
            new StandardCategoryToolTipGenerator());
        CategoryPlot linePlot = new CategoryPlot(
            linePlotData, null, linePlotRangeAxis, linePlotRenderer);
        linePlot.setDomainGridlinesVisible(true);
        NumberAxis barPlotRangeAxis = new NumberAxis(barPlotYLabel);
        barPlotRangeAxis.setStandardTickUnits(
            NumberAxis.createIntegerTickUnits());
        BarRenderer barPlotRenderer = new BarRenderer();
        barPlotRenderer.setBaseToolTipGenerator(
            new StandardCategoryToolTipGenerator());
        CategoryPlot barPlot = new CategoryPlot(
            barPlotData, null, barPlotRangeAxis, barPlotRenderer);
        barPlot.setDomainGridlinesVisible(true);
        CategoryAxis domainAxis = new CategoryAxis(xLabel);
        CombinedDomainCategoryPlot combinedPlot =
            new CombinedDomainCategoryPlot(domainAxis);
        if(isLinePlotUpper)
        {
            combinedPlot.add(linePlot, 1);
            combinedPlot.add(barPlot, 1);
        }
        else
        {
            combinedPlot.add(barPlot, 1);
            combinedPlot.add(linePlot, 1);
        }

        return new JFreeChart(title,
                              new Font("SansSerif", Font.BOLD, 12),
                              combinedPlot,
                              true);
    }

    /**
     * Creates a combined line and bar plot.
     * @param isLinePlotUpper the boolean indicating whether the upper plot is
     *                        the line plot.
     * @param linePlotDataNames the names of the data series for the line plot,
     *                          dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param barPlotDataNames the names of the data series for the bar plot,
     *                         dataNames[j]: the name of the (j+1)'th data
     *                                       series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param linePlotYLabel the label for the y-coordinate of the line plot.
     * @param barPlotYLabel the label for the y-coordinate of the bar plot.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param linePlotData the data series for the line plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @param barPlotData the data series for the bar plot,
     * <br>               data[j]: the (j+1)'th data series.
     * @return the created combined line and bar plot.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public JFreeChart createCombinedLineBarPlot(boolean isLinePlotUpper,
                                                String[] linePlotDataNames,
                                                String[] barPlotDataNames,
                                                String title,
                                                String xLabel,
                                                String linePlotYLabel,
                                                String barPlotYLabel,
                                                String[] category,
                                                double[][] linePlotData,
                                                double[][] barPlotData)
    {
        DataCreator dataCreator = new DataCreator();

        return createCombinedLineBarPlot(
            isLinePlotUpper, title, xLabel, linePlotYLabel, barPlotYLabel,
            dataCreator.createDataset(linePlotDataNames, category,
                                      linePlotData),
            dataCreator.createDataset(barPlotDataNames, category,
                                      barPlotData));
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
