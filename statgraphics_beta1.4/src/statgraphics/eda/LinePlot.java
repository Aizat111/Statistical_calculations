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
 * <p>Generates a line plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> String [] category = {"2001", "2002", "2003", "2004", "2005"};
 * <br> double [] data1 = {13, 12, 11, 8, 7};
 * <br> double [] data2 = {6, 11, 12, 11, 10};
 * <br> double [] data3 = {4, 5, 7, 9, 13};
 * <br> String [] dataNames = {"Company A", "Company B", "Company C"};
 * <br> LinePlot linePlot =
 *        new LinePlot(dataNames, "Computer Purchases", "Company", "Sales",
 * <br> &nbsp;&nbsp;&nbsp;
 *        category, data1, data2, data3);
 * <br> PlotFrame pf = new PlotFrame("Line Plot I", linePlot.getPlot(),
 *        500, 270);
 * <br>
 * <br> // Ogive Plot
 * <br> double [][] sortXData = {{9, 14, 19, 24, 29, 34},
 *                               {11, 13, 17, 22, 26, 28, 31}};
 * <br> double [][] sortYData = {{0, 4, 12, 17, 19, 20},
 *                               {0, 2, 10, 13, 15, 16, 18}};
 * <br> dataNames = new String[]{"Company A", "Company B"};
 * <br> linePlot = new LinePlot(dataNames2,
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Ogive Plot", "Audit Time in Days", "Cumulative Frequency", sortXData,
 *        sortYData);
 * <br> pf = new PlotFrame("Ogive Plot I", linePlot.getPlot());
 * <br>
 * <br> // Scree Plot
 * <br> double [][] variance = {{3.59, 1.63, 1.11, 0.70, 0.38, 0.30, 0.14,
 *                               0.11}};
 * <br> String [] componentList = {"Comp. 1", "Comp. 2", "Comp. 3", "Comp. 4",
 *                                 "Comp. 5", "Comp. 6", "Comp. 7", "Comp. 8"};
 * <br> String dataNames3 = "Component";
 * <br> linePlot = new LinePlot(dataNames3,
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Principal Component Analysis", "Principal Component", "Variance",
 *        componentList, variance);
 * <br> pf = new PlotFrame("Scree Plot I", linePlot.getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the histogram
 * <br> Hashtable argument1 = new Hashtable();
 * <br> argument1.put(DATA_NAMES, dataNames);
 * <br> GraphicalAnalysis graphicalAnalysis =
 *        new LinePlot(argument1, category, data1, data2, data3).
 *        graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Line Plot II", myPlot, 500, 270);
 * <br>
 * <br> // Ogive Plot
 * <br> Hashtable argument2 = new Hashtable();
 * <br> argument2.put(DATA_NAMES, dataNames2);
 * <br> argument2.put(TITLE, "Ogive Plot");
 * <br> argument2.put(XLABEL, "Audit Time in Days");
 * <br> argument2.put(YLABEL, "Cumulative Frequency");
 * <br> graphicalAnalysis =
 *        new LinePlot(argument2, sortXData, sortYData).graphicalAnalysis;
 * <br> pf = new PlotFrame("Ogive Plot II", graphicalAnalysis.getPlot(),
 *        500, 270);
 * <br>
 * <br> // Scree Plot
 * <br> Hashtable argument3 = new Hashtable();
 * <br> argument3.put(DATA_NAMES, dataNames3);
 * <br> argument3.put(TITLE, "Principal Component Analysis");
 * <br> argument3.put(XLABEL, "Principal Component");
 * <br> argument3.put(YLABEL, "Variance");
 * <br> graphicalAnalysis =
 *        new LinePlot(argument3, componentList, variance).graphicalAnalysis;
 * <br> pf = new PlotFrame("Scree Plot II", graphicalAnalysis.getPlot(),
 *        500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class LinePlot extends GraphicalAnalysis
{

    /**
     * The input category.
     */

    public String[] category;

    /**
     * The input data series as the data for x-coordinate are categorical.
     */

    public double[][] data;


    /**
     * The data series for the x-coordinate.
     */

    public double[][] xData;

    /**
     * The data series for the y-coordinate.
     */

    public double[][] yData;

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
     * The object represents a line plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * The input data.
     */

    private double[][] doubleData;

    /**
     * Default LinePlot constructor.
     */

    public LinePlot() {}

    /**
     * Creates a new line plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> DATANAMES: the default title "Line Plot", x-label "Category" or
     *                 "Range", and y-label "Value".
     * <br><br>
     * @param dataObject the input data.
     * @exception IllegalArgumentException wrong input argument(s) or data.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(Hashtable argument,
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
                if (dataObject.length == 2)
                {
                    if (dataObject[0].getClass().getName().
                        equalsIgnoreCase("[[D") &&
                        dataObject[1].getClass().getName().
                        equalsIgnoreCase("[[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String[]) argument.get(DATA_NAMES),
                                (String) argument.get(TITLE),
                                (String) argument.get(XLABEL),
                                (String) argument.get(YLABEL),
                                (double[][]) dataObject[0],
                                (double[][]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[D") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String) argument.get(DATA_NAMES),
                                (String) argument.get(TITLE),
                                (String) argument.get(XLABEL),
                                (String) argument.get(YLABEL),
                                (double[]) dataObject[0],
                                (double[]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[Ljava.lang.String;") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String[]) argument.get(DATA_NAMES),
                                (String) argument.get(TITLE),
                                (String) argument.get(XLABEL),
                                (String) argument.get(YLABEL),
                                (String[]) dataObject[0],
                                (double[][]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[Ljava.lang.String;") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String) argument.get(DATA_NAMES),
                                (String) argument.get(TITLE),
                                (String) argument.get(XLABEL),
                                (String) argument.get(YLABEL),
                                (String[]) dataObject[0],
                                (double[]) dataObject[1]);
                    }
                    else
                    {
                        throw new IllegalArgumentException(
                                "Wrong input argument(s) or data.");
                    }
                }
                else if (dataObject.length > 2 &&
                         dataObject[0].getClass().getName().equalsIgnoreCase(
                                 "[Ljava.lang.String;"))
                {
                    doubleData = DataCreator.castToDoubleData(1, dataObject);
                    graphicalAnalysis = new LinePlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (String[]) dataObject[0], doubleData);
                }
                else
                {
                    throw new IllegalArgumentException("Wrong input data.");
                }
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                if (dataObject.length == 2)
                {
                    if (dataObject[0].getClass().getName().
                        equalsIgnoreCase("[[D") &&
                        dataObject[1].getClass().getName().
                        equalsIgnoreCase("[[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String[]) argument.get(DATA_NAMES),
                                (double[][]) dataObject[0],
                                (double[][]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[D") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String) argument.get(DATA_NAMES),
                                (double[]) dataObject[0],
                                (double[]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[Ljava.lang.String;") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String[]) argument.get(DATA_NAMES),
                                (String[]) dataObject[0],
                                (double[][]) dataObject[1]);
                    }
                    else if (dataObject[0].getClass().getName().
                             equalsIgnoreCase("[Ljava.lang.String;") &&
                             dataObject[1].getClass().getName().
                             equalsIgnoreCase("[D"))
                    {
                        graphicalAnalysis = new LinePlot(
                                (String) argument.get(DATA_NAMES),
                                (String[]) dataObject[0],
                                (double[]) dataObject[1]);
                    }
                    else
                    {
                        throw new IllegalArgumentException(
                                "Wrong input argument(s) or data.");
                    }
                }
                else if (dataObject.length > 2 &&
                         dataObject[0].getClass().getName().equalsIgnoreCase(
                                 "[Ljava.lang.String;"))
                {
                    doubleData = DataCreator.castToDoubleData(1, dataObject);
                    graphicalAnalysis = new LinePlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String[]) dataObject[0], doubleData);
                }
                else
                {
                    throw new IllegalArgumentException("Wrong input data.");
                }
            }
        }
        else
        {
            throw new IllegalArgumentException(
                    "Wrong input argument(s) or data.");
        }
    }

    /**
     * Creates a new line plot with the specified names of data, title, labels
     * for the x-coordinate and y-coordinate.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String[] dataNames,
                    String title,
                    String xLabel,
                    String yLabel,
                    String[] category,
                    double[] ...data)
    {
        this.category = category;
        this.data = data;
        this.dataNames = dataNames;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createLinePlot(dataNames, title, xLabel,
                yLabel, category, data);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new line plot with the specified name of data, title, labels
     * for the x-coordinate and y-coordinate.
     * @param dataName the name of the data series.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String dataName,
                    String title,
                    String xLabel,
                    String yLabel,
                    String[] category,
                    double[] data)
    {
        this(new String[] {dataName}, title, xLabel, yLabel, category,
             new double[][] {data});
    }

    /**
     * Creates a new line plot with the specified names of data and default
     * title "Line Plot", x-label "Category", and y-label "Value".
     * @param dataNames the names of the data sets,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data sets,
     * <br>        data[j]: the (j+1)'th data set.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String[] dataNames,
                    String[] category,
                    double[] ...data)
    {
        this(dataNames, "Line Plot", "Category", "Value", category, data);
    }

    /**
     * Creates a new line plot with the specified name of data and default title
     * "Line Plot", x-label "Category", and y-label "Value".
     * @param dataName the name of the data set.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param data the data set.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String dataName,
                    String[] category,
                    double[] data)
    {
        this(new String[] {dataName}, "Line Plot", "Category", "Value",
             category, new double[][] {data});
    }

    /**
     * Creates a new line plot with the specified names of data, title, and
     * labels for the x-coordinate and y-coordinate.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the data series for x-coordinate,
     * <br>         xDdata[j]: the j'th data series.
     * @param yData the data series for y-coordinate,
     * <br>         yData[j]: the j'th data series.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String[] dataNames,
                    String title,
                    String xLabel,
                    String yLabel,
                    double[][] xData,
                    double[][] yData)
    {
        this.xData = xData;
        this.yData = yData;
        this.dataNames = dataNames;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createLinePlot(dataNames, title, xLabel,
                yLabel, xData, yData);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new line plot with the specified names of data and
     * default title "Line Plot", x-label "Range", and y-label "Value".
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param xData the data series for x-coordinate,
     * <br>         xData[j]: the j'th data series.
     * @param yData the data series for y-coordinate,
     * <br>         yData[j]: the j'th data series.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String[] dataNames,
                    double[][] xData,
                    double[][] yData)
    {
        this(dataNames, "Line Plot", "Range", "Value", xData, yData);
    }

    /**
     * Creates a new line plot with the specified name of data.
     * @param dataName the name of the data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the data series for x-coordinate.
     * @param yData the data series for y-coordinate.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String dataName,
                    String title,
                    String xLabel,
                    String yLabel,
                    double[] xData,
                    double[] yData)
    {
        this(new String[] {dataName}, title, xLabel, yLabel,
             new double[][] {xData}, new double[][] {yData});
    }

    /**
     * Creates a new line plot with the specified name of data and default title
     * "Line Plot", x-label "Range", and y-label "Value".
     * @param dataName the name of the data series.
     * @param xData the data series for x-coordinate.
     * @param yData the data series for y-coordinate.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public LinePlot(String dataName,
                    double[] xData,
                    double[] yData)
    {
        this(dataName, "Line Plot", "Range", "Value", xData, yData);
    }

}
