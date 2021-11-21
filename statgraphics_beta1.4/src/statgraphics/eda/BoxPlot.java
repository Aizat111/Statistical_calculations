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
 * <p>Generates a box plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> data = new double[12][20];
 * <br> for (int i = 0; i < 12; i++)
 * <br> {
 * <br> &nbsp;&nbsp;&nbsp;
 *        for (int j = 0; j < 20; j++)
 * <br> &nbsp;&nbsp;&nbsp;
 *        {
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *          data[i][j] = -10 + Math.random() * 20.0;
 * <br> &nbsp;&nbsp;&nbsp;
 *        }
 * <br> }
 * <br> dataNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
 *                   "L"};
 * <br> PlotFrame pf = new PlotFrame("Box Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BoxPlot(dataNames, "My Box Plot", "Category", "Data Value", data).
 *        getPlot(),500,270);
 * <br> pf = new PlotFrame("Box Plot II",
 *        new BoxPlot(dataNames, data).plot, 500, 270);
 * <br>
 * <br> Date [] time = new Date[12];
 * <br> for(int i = 0; i < 12; i++)
 * <br> {
 * <br> &nbsp;&nbsp;&nbsp;
 *        time[i] = new Date(105, i - 1, 21);
 * <br> }
 * <br> pf = new PlotFrame("Box Plot III",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BoxPlot("Box Plot (Time)", "Time", "Data Value", time, data).
 *        getPlot(), 500, 270);
 * <br> pf = new PlotFrame("Box Plot IV", new BoxPlot(time, data).getPlot(),
 *        500, 270);
 * <br>
 * <br> // Another way to generate the box plot
 * <br> Hashtable argument1 = new Hashtable();
 * <br> argument1.put(DATA_NAMES, dataNames);
 * <br> argument1.put(TITLE, "My Box Plot");
 * <br> argument1.put(XLABEL, "Category");
 * <br> argument1.put(YLABEL, "Data Value");
 * <br> pf = new PlotFrame("Box Plot V", myPlot, 500, 270);
 * <br>
 * <br> Hashtable argument2 = new Hashtable();
 * <br> argument2.put(DATA_NAMES, dataNames);
 * <br> pf = new PlotFrame("Box Plot VI",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BoxPlot(argument2, data).graphicalAnalysis.plot, 500, 270);
 * <br>
 * <br> Hashtable argument3 = new Hashtable();
 * <br> argument3.put(TITLE, "Box Plot (Time)");
 * <br> argument3.put(XLABEL, "Category");
 * <br> argument3.put(YLABEL, "Data Value");
 * <br> GraphicalAnalysis graphicalAnalysis =
 *        new BoxPlot(argument3, time, data).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Box Plot VII",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BoxPlot(argument3, time, data).graphicalAnalysis.getPlot(),
 *        500, 270);
 * <br>
 * <br> Hashtable argument4 = new Hashtable();
 * <br> pf = new PlotFrame("Box Plot VIII",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BoxPlot(argument4, time, data).graphicalAnalysis.plot, 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class BoxPlot extends GraphicalAnalysis
{

    /**
     * The input data series.
     */

    public double[][] data;

    /**
     * The names of the input data series.
     */

    public String[] dataNames;

    /**
     * The dates assoicated with the input data series.
     */

    public Date[] time;

    /**
     * The plot title.
     */

    public String title;

    /**
     * The label for the x-axis.
     */

    public String xLabel;

    /**
     * The label for the y-axis.
     */

    public String yLabel;

    /**
     * The object represents a box plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * The input data.
     */

    private double[][] doubleData;

    /**
     * Default BoxPlot constructor.
     */

    public BoxPlot() {}

    /**
     * Creates a new box plot.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> DATANAMES: the default title "Box Plot", x-label "Time" or null, and
     *                 y-label "Value";
     * <br><br>
     * @param dataObject the input data series.
     * @exception IllegalArgumentException wrong input arguments or data or
     *                                     data type.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the number of input data
     *                                     series.
     */

    public BoxPlot(Hashtable argument,
                   Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (argument.size() > 0 &&
            dataObject != null)
        {
            if (dataObject.length == 1 &&
                dataObject[0].getClass().getName().equalsIgnoreCase("[D"))
            {
                doubleData = new double[][] {(double[]) dataObject[0]};
            }
            else if (dataObject.getClass().getName().equalsIgnoreCase("[[D"))
            {
                doubleData = (double[][]) dataObject;
            }
            else if (dataObject.length == 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.util.Date;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
            {
                doubleData = (double[][]) dataObject[1];
            }
            else if (dataObject.length >= 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.util.Date;"))
            {
                doubleData = DataCreator.castToDoubleData(1, dataObject);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input data type.");
            }
            if (argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                if (argument.get(DATA_NAMES).getClass().getName().
                    equalsIgnoreCase("java.lang.String"))
                {
                    graphicalAnalysis = new BoxPlot(
                            new String[] {(String) argument.get(DATA_NAMES)},
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            doubleData);
                }
                else
                {
                    graphicalAnalysis = new BoxPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            doubleData);
                }
            }
            else if (argument.get(TITLE) != null &&
                     argument.get(XLABEL) != null &&
                     argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new BoxPlot(
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        (Date[]) dataObject[0], doubleData);
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                if (argument.get(DATA_NAMES).getClass().getName().
                    equalsIgnoreCase("java.lang.String"))
                {
                    graphicalAnalysis = new BoxPlot(
                            new String[] {(String) argument.get(DATA_NAMES)},
                            (double[][]) dataObject);
                }
                else
                {
                    graphicalAnalysis = new BoxPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (double[][]) dataObject);
                }
            }
            else
            {
                throw new IllegalArgumentException("Wrong input argument(s).");
            }
        }
        else if (argument.size() == 0 &&
                 dataObject != null)
        {
            if (dataObject.length == 2 &&
                dataObject[0].getClass().getName().equalsIgnoreCase(
                        "[Ljava.util.Date;") &&
                dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
            {
                doubleData = (double[][]) dataObject[1];
            }
            else if (dataObject.length >= 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.util.Date;"))
            {
                doubleData = DataCreator.castToDoubleData(1, dataObject);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input data.");
            }
            graphicalAnalysis = new BoxPlot((Date[]) dataObject[0], doubleData);
        }
        else
        {
            throw new IllegalArgumentException(
                    "Wrong input argument(s) or data.");
        }
    }

    /**
     * Creates a new box plot.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public BoxPlot(String[] dataNames,
                   String title,
                   String xLabel,
                   String yLabel,
                   double[] ...data)
    {
        this.data = data;
        this.dataNames = dataNames;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createBoxPlot(dataNames, title, xLabel,
                yLabel, data);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new box plot with the default title "Box Plot", null x-label,
     * and y-label "Value".
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public BoxPlot(String[] dataNames,
                   double[] ...data)
    {
        this.plot = new Plot2DFactory().
                    createBoxPlot(dataNames, "Box Plot", null, "Value", data);
    }

    /**
     * Creates a new box plot.
     * @param dataName the name of the data series,
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param data the data series.
     */

    public BoxPlot(String dataName,
                   String title,
                   String xLabel,
                   String yLabel,
                   double[] data)
    {
        this(new String[] {dataName}, title, xLabel, yLabel,
             new double[][] {data});
    }

    /**
     * Creates a new box plot with the default title "Box Plot", null x-label,
     * and y-label "Value".
     * @param dataName the name of the data series,
     * @param data the data series.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the length of the input
     *                                     data series.
     */

    public BoxPlot(String dataName,
                   double[] data)
    {
        this(dataName, "Box Plot", null, "Value", data);
    }

    /**
     * Creates a new box plot.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @param time the dates assoicated with the data series,
     * <br>        time[j]: the date associated with data[j].
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the number of input data
     *                                     series.
     */

    public BoxPlot(String title,
                   String xLabel,
                   String yLabel,
                   Date[] time,
                   double[] ...data)
    {
        this.data = data;
        this.time = time;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createBoxPlot(title, xLabel, yLabel,
                time, data);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new box plot with the default title "Box Plot", x-label "Time",
     * and y-label "Value".
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @param time the dates assoicated with the data series,
     * <br>        time[j]: the date associated with data[j].
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the number of input data
     *                                     series.
     */

    public BoxPlot(Date[] time,
                   double[] ...data)
    {
        this("Box Plot", "Time", "Value", time, data);
    }

}
