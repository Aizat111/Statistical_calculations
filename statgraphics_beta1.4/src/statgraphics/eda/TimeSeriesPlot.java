package statgraphics.eda;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

import java.util.*;

import statgraphics.*;
import static statgraphics.util.Argument.*;
import statgraphics.util.*;

/**
 *
 * <p>Generates a time series plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> int [][][] time = new int[2][12][6];
 * <br> data = new double[2][12];
 * <br> dataNames = {"Company A", "Company B"};
 * <br> for(int j = 0; j < 2; j++)
 * <br> {
 * <br> &nbsp;&nbsp;&nbsp;
 *        for (int i = 0; i < 12; i++)
 * <br> &nbsp;&nbsp;&nbsp;
 *        {
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][0] = 0;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][1] = 0;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][2] = 0;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][3] = 1;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][4] = i + 1;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          time[j][i][5] = 2005;
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          data[j][i] = 100 + Math.random() * 20.0;
 * <br> &nbsp;&nbsp;&nbsp;
 *        }
 * <br> }
 * <br>
 * <br> // Multiple time series
 * <br> pf = new PlotFrame("Time Series Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new TimeSeriesPlot(dataNames, "Time Series Plot", "Date",
 *        "Stock Price", time, data).plot, 500, 270);
 * <br>
 * <br> // Single time series
 * <br> pf = new PlotFrame("Time Series Plot II",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new TimeSeriesPlot(dataNames[0], time[1], data[0]).plot, 500, 270);
 * <br>
 * <br> // Another way to generate the time series plot
 * <br> // Multiple time series
 * <br> Hashtable argument = new Hashtable();
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> GraphicalAnalysis graphicalAnalysis =
 *        new TimeSeriesPlot(argument, time, data).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Time Series Plot III", myPlot, 500, 270);
 * <br>
 * <br> // Single time series
 * <br> argument.put(DATA_NAMES, dataNames[0]);
 * <br> argument.put(TITLE, "Time Series Plot");
 * <br> argument.put(XLABEL, "Date");
 * <br> argument.put(YLABEL, "Stock Price");
 * <br> pf = new PlotFrame("Time Series Plot IV",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new TimeSeriesPlot(argument, time[0], data[1]).
 *        graphicalAnalysis.getPlot(), 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class TimeSeriesPlot extends GraphicalAnalysis
{

    /**
     * The input time series.
     */

    public double[][] data;


    /**
     * The dates assoicated with the collection of time series.
     */

    public int[][][] time;

    /**
     * The names of the input data series.
     */

    public String[] dataNames;

    /**
     * The plot title.
     */

    public String title;

    /**
     * The label for the x-coordinate.
     */

    public String xLabel;

    /**
     * The label for the y-coordinate.
     */

    public String yLabel;

    /**
     * The object represents a time series plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default TimeSeriesPlot constructor.
     */

    public TimeSeriesPlot() {}

    /**
     * Creates a new time series plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> DATANAMES: the default title "Time Series Plot", x-label "Time", and
     *                 y-label "Value".
     * <br><br>
     * @param dataObject the input collection of time series and dates
     *                   assoicated with the collection of time series.
     * @exception IllegalArgumentException wrong input argument(s) or data.
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

    public TimeSeriesPlot(Hashtable argument,
                          Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (argument.size() > 0 &&
            dataObject != null)
        {
            if (argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                if (dataObject.length == 2 &&
                    dataObject[0].getClass().getName().
                    equalsIgnoreCase("[[[I") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (int[][][]) dataObject[0],
                            (double[][]) dataObject[1]);
                }
                else if (dataObject.length >= 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[[[I"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (int[][][]) dataObject[0],
                            DataCreator.castToDoubleData(1, dataObject));
                }
                else if (dataObject.length == 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[[I") &&
                         dataObject[1].getClass().getName().
                         equalsIgnoreCase("[D"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (int[][]) dataObject[0],
                            (double[]) dataObject[1]);
                }
                else
                {
                    throw new IllegalArgumentException("Wrong input data.");
                }
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                if (dataObject.length == 2 &&
                    dataObject[0].getClass().getName().
                    equalsIgnoreCase("[[[I") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (int[][][]) dataObject[0],
                            (double[][]) dataObject[1]);
                }
                else if (dataObject.length >= 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[[[I"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (int[][][]) dataObject[0],
                            DataCreator.castToDoubleData(1, dataObject));
                }
                else if (dataObject.length == 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[[I") &&
                         dataObject[1].getClass().getName().
                         equalsIgnoreCase("[D"))
                {
                    graphicalAnalysis = new TimeSeriesPlot(
                            (String) argument.get(DATA_NAMES),
                            (int[][]) dataObject[0],
                            (double[]) dataObject[1]);
                }
                else
                {
                    throw new IllegalArgumentException("Wrong input data.");
                }
            }
            else
            {
                throw new IllegalArgumentException(
                        "Wrong input argument(s) or data.");
            }
        }
        else
        {
            throw new IllegalArgumentException("Wrong input data.");
        }
    }

    /**
     * Creates a new time series plot with the specified names of the data
     * series, title, and labels for the x-coordinate and y-coordinate.
     * @param dataNames the names of the data series,
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

    public TimeSeriesPlot(String[] dataNames,
                          String title,
                          String xLabel,
                          String yLabel,
                          int[][][] time,
                          double[] ...data)
    {
        this.data = data;
        this.time = time;
        this.dataNames = dataNames;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createTimeSeriesPlot(dataNames, title,
                xLabel, yLabel, time, data);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new time series plot with the specified names of the time
     * series and default title "Time Series Plot", x-label "Time", and y-label
     * "Value".
     * @param dataNames the names of data series,
     *                  dataNames[j]: the name of the (j+1)'th time series.
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

    public TimeSeriesPlot(String[] dataNames,
                          int[][][] time,
                          double[] ...data)
    {
        this(dataNames, "Time Series Plot", "Time", "Value", time, data);
    }

    /**
     * Creates a new time series plot with the specified name of the time
     * series, title, and labels for the x-coordinate and y-coordinate.
     * @param dataName the name of the data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param time the dates assoicated with the collection of time series,
     * <br>        time[i][0]: the second (0-59);
     * <br>        time[i][1]: the minute (0-59);
     * <br>        time[i][2]: the hour (0-23);
     * <br>        time[i][3]: the day (1-31);
     * <br>        time[i][4]: the month (1-12);
     * <br>        time[i][5]: the year (1900-9999).
     * @param data the time series.
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

    public TimeSeriesPlot(String dataName,
                          String title,
                          String xLabel,
                          String yLabel,
                          int[][] time,
                          double[] data)
    {
        this(new String[] {dataName}, title, xLabel, yLabel,
             new int[][][] {time}, new double[][] {data});
    }

    /**
     * Creates a new time series plot with the specified name of the time series
     * and default title "Time Series Plot", x-label "Time", and
     * y-label "Value".
     * @param dataName the name of the data series.
     * @param time the dates assoicated with the collection of time series,
     * <br>        time[i][0]: the second (0-59);
     * <br>        time[i][1]: the minute (0-59);
     * <br>        time[i][2]: the hour (0-23);
     * <br>        time[i][3]: the day (1-31);
     * <br>        time[i][4]: the month (1-12);
     * <br>        time[i][5]: the year (1900-9999).
     * @param data the time series.
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

    public TimeSeriesPlot(String dataName,
                          int[][] time,
                          double[] data)
    {
        this(dataName, "Time Series Plot", "Time", "Value", time, data);
    }

}
