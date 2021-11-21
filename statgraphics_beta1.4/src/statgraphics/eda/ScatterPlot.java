package statgraphics.eda;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author  Wen Hsiang Wei
 * @version 1.4
 */

import java.util.*;

import statgraphics.*;
import static statgraphics.util.Argument.*;
import statgraphics.util.*;

/**
 *
 * <p>Generates a scatter plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> PlotFrame[] pf = new PlotFrame[2];
 * <br> double xdata [][] = {{2, 5, 1, 3, 4, 1, 5, 3, 4, 2},
 *                           {2, 3, 4, 2, 5, 3, 4, 1, 3, 4}};
 * <br> double [][] ydata = {{50, 57, 41, 54, 54, 38, 63, 48, 59, 46},
 *                           {39, 42, 37, 32, 42, 45, 32, 43, 45, 35}};
 * <br> String [] dataNames = {"2004", "2005"};
 * <br> ScatterPlot scatterPlot = new ScatterPlot(dataNames,
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Scatter Diagram", "Number of Commercials", "Sales", xdata, ydata);
 * <br> PlotFrame pf =
 *        new PlotFrame("Scatter Plot I", scatterPlot.plot, 500, 270);
 * <br>
 * <br> // Residual Plot
 * <br> double [][] residuals = {{-12, 15, -12, 18, -3, -3, -3, 9, -21, 12}};
 * <br> double [][] index = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
 * <br> String  dataNames2 = "Residuals";
 * <br> scatterPlot = new ScatterPlot(dataNames2,
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Residual Plot", "Index", "Residuals", index, residuals);
 * <br> pf = new PlotFrame("Linear Regression: Residual Plot I",
 *        scatterPlot.getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the scatter plot
 * <br> Hashtable argument = new Hashtable();
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> GraphicalAnalysis graphicalAnalysis = new
 * <br> &nbsp;&nbsp;&nbsp;
 *        ScatterPlot(argument, xdata, ydata).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Scatter Plot II", myPlot, 500, 270);
 * <br>
 * <br> // Residual Plot
 * <br> argument.put(DATA_NAMES, dataNames2);
 * <br> argument.put(TITLE, "Residual Plot");
 * <br> argument.put(XLABEL, "Index");
 * <br> argument.put(YLABEL, "Residuals");
 * <br> graphicalAnalysis =
 *        new ScatterPlot(argument, index, residuals).graphicalAnalysis;
 * <br> pf = new PlotFrame("Linear Regression: Residual Plot II",
 *        graphicalAnalysis.getPlot(), 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class ScatterPlot extends GraphicalAnalysis
{

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
     * The object represents a scatter plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default ScatterPlot constructor.
     */

    public ScatterPlot() {}

    /**
     * Creates a new scatter plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> DATANAMES: the default title "Scatter Plot", x-label "Range", and
     *                 y-label "Value".
     * <br><br>
     * @param dataObject the input data.
     * @exception IllegalArgumentException wrong input argument(s) or data.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public ScatterPlot(Hashtable argument,
                       Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (dataObject != null)
        {
            if (argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                if (dataObject.length == 2 &&
                    dataObject[0].getClass().getName().
                    equalsIgnoreCase("[[D") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new ScatterPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (double[][]) dataObject[0],
                            (double[][]) dataObject[1]);
                }
                else if (dataObject.length == 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[D") &&
                         dataObject[1].getClass().getName().
                         equalsIgnoreCase("[D"))
                {
                    graphicalAnalysis = new ScatterPlot(
                            (String) argument.get(DATA_NAMES),
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (double[]) dataObject[0], (double[]) dataObject[1]);
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
                    equalsIgnoreCase("[[D") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new ScatterPlot(
                            (String[]) argument.get(DATA_NAMES),
                            (double[][]) dataObject[0],
                            (double[][]) dataObject[1]);
                }
                else if (dataObject.length == 2 &&
                         dataObject[0].getClass().getName().
                         equalsIgnoreCase("[D") &&
                         dataObject[1].getClass().getName().
                         equalsIgnoreCase("[D"))
                {
                    graphicalAnalysis = new ScatterPlot(
                            (String) argument.get(DATA_NAMES),
                            (double[]) dataObject[0], (double[]) dataObject[1]);
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
            throw new IllegalArgumentException(
                    "Wrong input argument(s) or data.");
        }
    }

    /**
     * Creates a new scatter plot with the specified names of the data series,
     * title, and labels for the x-coordinate and y-coordinate.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the data series for the x-coordinate,
     * <br>         xData[j]: the (j+1)'th data series.
     * @param yData the data series for the y-coordinate,
     * <br>         yData[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public ScatterPlot(String[] dataNames,
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
        this.plot = new Plot2DFactory().createScatterPlot(dataNames, title,
                xLabel, yLabel, xData, yData);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new scatter plot with the default title "Scatter Plot", x-label
     * "Range", y-label "Value", and the specified names of the data series.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param xData the data series for the x-coordinate,
     * <br>         xData[j]: the (j+1)'th data series.
     * @param yData the data series for the y-coordinate,
     * <br>         yData[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public ScatterPlot(String[] dataNames,
                       double[][] xData,
                       double[][] yData)
    {
        this(dataNames, "Scatter Plot", "Range", "Value", xData, yData);
    }

    /**
     * Creates a new scatter plot with the specified name of the data series,
     * title, and labels for the x-coordinate and y-coordinate.
     * @param dataName the name of the data series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param xData the data series for the x-coordinate,
     * @param yData the data series for the y-coordinate,
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public ScatterPlot(String dataName,
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
     * Creates a new scatter plot with the default title "Scatter Plot", x-label
     * "Range", y-label "Value", and the specified name of the data series.
     * @param dataName the name of the data series.
     * @param xData the data series for the x-coordinate,
     * @param yData the data series for the y-coordinate,
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same length.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public ScatterPlot(String dataName,
                       double[] xData,
                       double[] yData)
    {
        this(dataName, "Scatter Plot", "Range", "Value", xData, yData);
    }

}
