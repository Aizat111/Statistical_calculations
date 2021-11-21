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
 * <p>Generates a bar plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> String[] category = {"2004", "2005", "2006", "2007", "2008"};
 * <br> String[] lineDataNames = {"Apple", "Compaq", "IBM"};
 * <br> String[] barDataNames = {"Microsoft", "Google"};
 * <br> double[][] lineData = { {13, 12, 5, 9, 11}, {12, 13, 6, 8, 11},
 * <br> &nbsp;&nbsp;&nbsp; {14, 11, 4, 11, 10} };
 * <br> double[][] barData = { {17, 17, 10, 14, 11}, {19, 23, 16, 18, 21} };
 * <br> PlotFrame[] pf = new PlotFrame[4];
 * <br>
 * <br> // Line plot is upper
 * <br> pf[0] = new PlotFrame("Combined Line and Bar Plot I",
 * <br> &nbsp;&nbsp;&nbsp; new CombinedLineBarPlot(
 * <br> &nbsp;&nbsp;&nbsp; lineDataNames, barDataNames,
 * <br> &nbsp;&nbsp;&nbsp; "Combined Line (Upper) and Bar Plot (Lower)",
 * <br> &nbsp;&nbsp;&nbsp; "Years (2004-2008)",
 * <br> &nbsp;&nbsp;&nbsp; "Sales", "Number of Commercials",
 * <br> &nbsp;&nbsp;&nbsp; category, lineData, barData).getPlot(),
 * <br> &nbsp;&nbsp;&nbsp; 500, 270);
 * <br>
 * <br> // Bar plot is upper
 * <br> pf[1] = new PlotFrame("Combined Line and Bar Plot II",
 * <br> &nbsp;&nbsp;&nbsp; new CombinedLineBarPlot(false,
 * <br> &nbsp;&nbsp;&nbsp; lineDataNames, barDataNames,
 * <br> &nbsp;&nbsp;&nbsp; "Combined Line (Lower) and Bar Plot (Upper)",
 * <br> &nbsp;&nbsp;&nbsp; "Years (2004-2008)",
 * <br> &nbsp;&nbsp;&nbsp; "Sales", "Number of Commercials",
 * <br> &nbsp;&nbsp;&nbsp; category, lineData, barData).getPlot(),
 * <br> &nbsp;&nbsp;&nbsp; 500, 270);
 * <br>
 * <br> // Another way to generate the combined line and bar plot
 * <br> Hashtable argument1 = new Hashtable();
 * <br> argument1.put(TITLE, "Combined Line and Bar Plot");
 * <br> argument1.put(XLABEL, "Years (2004-2008)");
 * <br> argument1.put(YLABEL, new String[]{"Sales", "Number of Commercials"});
 * <br> argument1.put(DATA_NAMES, new String[][]{lineDataNames, barDataNames});
 * <br> pf[2] = new PlotFrame("Combined Line and Bar Plot III",
 * <br> &nbsp;&nbsp;&nbsp; new CombinedLineBarPlot(argument1, category,
 * <br> &nbsp;&nbsp;&nbsp; lineData, barData).
 * <br> &nbsp;&nbsp;&nbsp; graphicalAnalysis.getPlot(), 500, 270);
 * <br>
 * <br> // Combined line and bar plot for the same data set
 * <br> argument1.put(YLABEL, new String[]{"Sales", "Sales"});
 * <br> argument1.put(DATA_NAMES, new String[][]{lineDataNames, lineDataNames});
 * <br> argument1.put(IS_LINE_PLOT_UPPER, false);
 * <br> GraphicalAnalysis graphicalAnalysis = new CombinedLineBarPlot(
 * <br> &nbsp;&nbsp;&nbsp; argument1, category, lineData, lineData).
 *                         graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf[3] = new PlotFrame("Combined Line and Bar Plot IV",
 * <br> &nbsp;&nbsp;&nbsp; myPlot, 500, 270);
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class CombinedLineBarPlot extends GraphicalAnalysis
{

    /**
     * The input category.
     */

    public String[] category;

    /**
     * The input data series for the line plot.
     */

    public double[][] linePlotData;

    /**
     * The input data series for the bar plot.
     */

    public double[][] barPlotData;

    /**
     * The names of the input data series for the line plot.
     */

    public String[] linePlotDataNames;

    /**
     * The names of the input data series for the bar plot.
     */

    public String[] barPlotDataNames;

    /**
     * The plot title.
     */

    public String title;

    /**
     * The label for the x-axis.
     */

    public String xLabel;

    /**
     * The label for the y-axis of the line plot.
     */

    public String linePlotYLabel;

    /**
     * The label for the y-axis of the bar plot.
     */

    public String barPlotYLabel;

    /**
     * The object represents a combined line and bar plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default CombinedLineBarPlot constructor.
     */

    public CombinedLineBarPlot(){}

    /**
     * Creates a new combined line and bar plot given the input arguments and
     * data.
     * @param argument the arguments with the following choices,
     * <br> IS_LINE_PLOT_UPPER, DATANAMES, TITLE, XLABEL, YLABEL:
     *      complete list of arguments;
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: generating a combined plot of
     *                                        which upper plot is the line plot;
     * <br> DATANAMES: the default title "Combined Line and Bar Plot",
     *                 x-label "Category", and y-labels "Value";
     * <br><br>
     * @param dataObject the input categories the data belong to and data
     *                   series.
     * @exception IllegalArgumentException wrong input argument(s) or data or
     *                                     data type.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public CombinedLineBarPlot(Hashtable argument,
                               Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (argument.size() > 0 &&
            dataObject != null)
        {
            if (dataObject.length == 3 &&
                dataObject[0].getClass().getName().equalsIgnoreCase(
                        "[Ljava.lang.String;") &&
                dataObject[1].getClass().getName().equalsIgnoreCase("[[D") &&
                dataObject[2].getClass().getName().equalsIgnoreCase("[[D"))
            {
                linePlotData = (double[][]) dataObject[1];
                barPlotData = (double[][]) dataObject[2];
            }
            else
            {
                throw new IllegalArgumentException("Wrong input data type");
            }
            if (argument.get(IS_LINE_PLOT_UPPER) != null &&
                argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new CombinedLineBarPlot(
                        (Boolean) argument.get(IS_LINE_PLOT_UPPER),
                        ((String[][]) argument.get(DATA_NAMES))[0],
                        ((String[][]) argument.get(DATA_NAMES))[1],
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        ((String[]) argument.get(YLABEL))[0],
                        ((String[]) argument.get(YLABEL))[1],
                        (String[]) dataObject[0], linePlotData, barPlotData);
            }
            else if (argument.get(DATA_NAMES) != null &&
                     argument.get(TITLE) != null &&
                     argument.get(XLABEL) != null &&
                     argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new CombinedLineBarPlot(
                        ((String[][]) argument.get(DATA_NAMES))[0],
                        ((String[][]) argument.get(DATA_NAMES))[1],
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        ((String[]) argument.get(YLABEL))[0],
                        ((String[]) argument.get(YLABEL))[1],
                        (String[]) dataObject[0], linePlotData, barPlotData);
            }
            else if (argument.get(IS_LINE_PLOT_UPPER) != null &&
                     argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new CombinedLineBarPlot(
                        (Boolean) argument.get(IS_LINE_PLOT_UPPER),
                        ((String[][]) argument.get(DATA_NAMES))[0],
                        ((String[][]) argument.get(DATA_NAMES))[1],
                        (String[]) dataObject[0], linePlotData, barPlotData);
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new CombinedLineBarPlot(
                        ((String[][]) argument.get(DATA_NAMES))[0],
                        ((String[][]) argument.get(DATA_NAMES))[1],
                        (String[]) dataObject[0], linePlotData, barPlotData);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input argument(s)");
            }
        }
        else
        {
            throw new IllegalArgumentException(
                    "Wrong input argument(s) or data.");
        }
    }

    /**
     * Creates a new combined line and bar plot.
     * @param isLinePlotUpper the boolean indicating whether the upper plot is
     *                        the line plot.
     * @param linePlotDataNames the names of the data series for the line plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param barPlotDataNames the names of the data series for the bar plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param linePlotYLabel the label for the y-axis of the line plot.
     * @param barPlotYLabel the label for the y-axis of the bar plot.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param linePlotData the data series for the line plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @param barPlotData the data series for the bar plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public CombinedLineBarPlot(boolean isLinePlotUpper,
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
        this.category = category;
        this.linePlotData = linePlotData;
        this.barPlotData = barPlotData;
        this.linePlotDataNames = linePlotDataNames;
        this.barPlotDataNames = barPlotDataNames;
        this.title = title;
        this.xLabel = xLabel;
        this.linePlotYLabel = linePlotYLabel;
        this.barPlotYLabel = barPlotYLabel;
        if (isLinePlotUpper)
        {
            this.plot = new Plot2DFactory().createCombinedLineBarPlot(
                    true,
                    linePlotDataNames, barPlotDataNames,
                    title,
                    xLabel, linePlotYLabel, barPlotYLabel,
                    category, linePlotData, barPlotData);
        }
        else
        {
            this.plot = new Plot2DFactory().createCombinedLineBarPlot(
                    false,
                    linePlotDataNames, barPlotDataNames,
                    title,
                    xLabel, linePlotYLabel, barPlotYLabel,
                    category, linePlotData, barPlotData);
        }
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a combined line and bar plot. The upper plot is the line plot.
     * @param linePlotDataNames the names of the data series for the line plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param barPlotDataNames the names of the data series for the bar plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param linePlotYLabel the label for the y-axis of the line plot.
     * @param barPlotYLabel the label for the y-axis of the bar plot.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param linePlotData the data series for the line plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @param barPlotData the data series for the bar plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public CombinedLineBarPlot(String[] linePlotDataNames,
                               String[] barPlotDataNames,
                               String title,
                               String xLabel,
                               String linePlotYLabel,
                               String barPlotYLabel,
                               String[] category,
                               double[][] linePlotData,
                               double[][] barPlotData)
    {
        this(true, linePlotDataNames, barPlotDataNames,
             title,
             xLabel, linePlotYLabel, barPlotYLabel,
             category, linePlotData, barPlotData);
    }

    /**
     * Creates a new combined line and bar plot with the default title
     * "Combined Line and Bar Plot",
     * x-label "Category", and y-labels "Value".
     * @param isLinePlotUpper the boolean indicating whether the upper plot is
     *                        the line plot.
     * @param linePlotDataNames the names of the data series for the line plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param barPlotDataNames the names of the data series for the bar plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param linePlotData the data series for the line plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @param barPlotData the data series for the bar plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public CombinedLineBarPlot(boolean isLinePlotUpper,
                               String[] linePlotDataNames,
                               String[] barPlotDataNames,
                               String[] category,
                               double[][] linePlotData,
                               double[][] barPlotData)

    {
        this(isLinePlotUpper,
             linePlotDataNames, barPlotDataNames,
             "Combined Line and Bar Plot", "Category", "Value", "Value",
             category, linePlotData, barPlotData);
    }

    /**
     * Creates a new combined line and bar plot with the default title
     * "Combined Line and Bar Plot", x-label "Category", and y-labels "Value".
     * The upper plot is the line plot.
     * @param linePlotDataNames the names of the data series for the line plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param barPlotDataNames the names of the data series for the bar plot,
     * <br>                     dataNames[j]: the name of the (j+1)'th data
     *                                        series.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param linePlotData the data series for the line plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @param barPlotData the data series for the bar plot,
     * <br>                data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public CombinedLineBarPlot(String[] linePlotDataNames,
                               String[] barPlotDataNames,
                               String[] category,
                               double[][] linePlotData,
                               double[][] barPlotData)
    {
        this(true,
             linePlotDataNames, barPlotDataNames,
             category, linePlotData, barPlotData);
    }

}
