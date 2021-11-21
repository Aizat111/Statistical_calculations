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
 * <br> String [] category =
 *        {"Apple", "Compaq", "GateWay 2000", "IBM", "Packard Bell"};
 * <br> double [][] data = {{13, 12, 5, 9, 11}, {12, 13, 6, 8, 11},
 *                          {14, 11, 4, 11, 10}};
 * <br> String [] dataNames = {"2002", "2003", "2004"};
 * <br> // 3D bar plot
 * <br> PlotFrame pf = new PlotFrame("Bar Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BarPlot("3D", dataNames, "Bar Plot A", "Company", "Frequency",
 *        category, data).getPlot(), 500, 270);
 * <br> // 2D bar plot
 * <br> pf = new PlotFrame("Bar Plot II",
 *        new BarPlot("2D", dataNames, category, data).getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the bar plot
 * <br> Hashtable argument1 = new Hashtable();
 * <br> argument1.put(TITLE, "Bar Plot B");
 * <br> argument1.put(XLABEL, "Company");
 * <br> argument1.put(YLABEL, "Frequency");
 * <br> argument1.put(DATA_NAMES, dataNames);
 * <br> argument1.put(OPTION, "3D");
 * <br> //3D bar plot
 * <br> pf = new PlotFrame("Bar Plot III",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new BarPlot(argument1, category, data).graphicalAnalysis.getPlot(),
 *        500, 270);
 * <br>
 * <br> Hashtable argument2 = new Hashtable();
 * <br> argument2.put(DATA_NAMES, dataNames);
 * <br> argument2.put(OPTION, "2D");
 * <br> GraphicalAnalysis graphicalAnalysis =
 *        new BarPlot(argument2, category, data).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Bar Plot IV", myPlot, 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class BarPlot extends GraphicalAnalysis
{

    /**
     * The input category.
     */

    public String[] category;

    /**
     * The input data series.
     */

    public double[][] data;


    /**
     * The names of the input data series.
     */

    public String[] dataNames;

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
     * The object represents a bar plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * The input data.
     */

    private double[][] doubleData;

    /**
     * Default BarPlot constructor.
     */

    public BarPlot() {}

    /**
     * Creates a new bar plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> OPTION, DATANAMES, TITLE, XLABEL, YLABEL:
     *      complete list of arguments;
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: generating a 2D bar plot;
     * <br> OPTION, DATANAMES: the default title "Bar Plot", x-label "Category",
     *                         and y-label "Value";
     * <br> DATANAMES: generating a 2D bar plot with the default title
     *                 "Bar Plot", x-label "Category", and y-label "Value".
     * <br><br>
     * @param dataObject the input categories the data belong to and data
     *                   series.
     * @exception IllegalArgumentException wrong input argument(s) or data.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public BarPlot(Hashtable argument,
                   Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (argument.size() > 0 &&
            dataObject != null)
        {
            if(argument.get(PLOT_OPTION) != null)
            {
                argument.put(OPTION, argument.get(PLOT_OPTION));
                argument.put(PLOT_OPTION, argument.get(PLOT_OPTION));
            }
            else if(argument.get(OPTION) != null)
            {
                argument.put(OPTION, argument.get(OPTION));
                argument.put(PLOT_OPTION, argument.get(OPTION));
            }
            if (dataObject.length == 2 &&
                dataObject[0].getClass().getName().equalsIgnoreCase(
                        "[Ljava.lang.String;") &&
                dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
            {
                doubleData = (double[][]) dataObject[1];
            }
            else if (dataObject.length >= 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.lang.String;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                doubleData = DataCreator.castToDoubleData(1, dataObject);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input data.");
            }
            if (argument.get(PLOT_OPTION) != null &&
                argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String) argument.get(PLOT_OPTION),
                        (String[]) argument.get(DATA_NAMES),
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        (String[]) dataObject[0], doubleData);
            }
            else if (argument.get(OPTION) != null &&
                     argument.get(DATA_NAMES) != null &&
                     argument.get(TITLE) != null &&
                     argument.get(XLABEL) != null &&
                     argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String) argument.get(OPTION),
                        (String[]) argument.get(DATA_NAMES),
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        (String[]) dataObject[0], doubleData);
            }
            else if (argument.get(DATA_NAMES) != null &&
                     argument.get(TITLE) != null &&
                     argument.get(XLABEL) != null &&
                     argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String[]) argument.get(DATA_NAMES),
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        (String[]) dataObject[0], doubleData);
            }
            else if (argument.get(PLOT_OPTION) != null &&
                     argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String) argument.get(PLOT_OPTION),
                        (String[]) argument.get(DATA_NAMES),
                        (String[]) dataObject[0], doubleData);
            }
            else if (argument.get(OPTION) != null &&
                     argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String) argument.get(OPTION),
                        (String[]) argument.get(DATA_NAMES),
                        (String[]) dataObject[0], doubleData);
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new BarPlot(
                        (String[]) argument.get(DATA_NAMES),
                        (String[]) dataObject[0], doubleData);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input argument(s).");
            }
        }
        else
        {
            throw new IllegalArgumentException(
                    "Wrong input argument(s) or data.");
        }
    }

    /**
     * Creates a new bar plot.
     * @param option the type of the plot with the choices "2D" or "3D".
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

    public BarPlot(String option,
                   String[] dataNames,
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
        if (option.equalsIgnoreCase("3D") ||
            option.equalsIgnoreCase("Three Dimensional"))
        {
            this.plot = new Plot3DFactory().createBar3DPlot(dataNames, title,
                    xLabel, yLabel, category, data);
        }
        else
        {
            this.plot = new Plot2DFactory().createBarPlot(dataNames, title,
                    xLabel, yLabel, category, data);
        }
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a 2D bar plot.
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

    public BarPlot(String[] dataNames,
                   String title,
                   String xLabel,
                   String yLabel,
                   String[] category,
                   double[] ...data)
    {
        this("2D", dataNames, title, xLabel, yLabel, category, data);
    }

    /**
     * Creates a new bar plot with the default title "Bar Plot",
     * x-label "Category", and y-label "Value".
     * @param option the type of the plot with the choices "2D" or "3D".
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
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

    public BarPlot(String option,
                   String[] dataNames,
                   String[] category,
                   double[] ...data)
    {
        this(option, dataNames, "Bar Plot", "Category", "Value", category,
             data);
    }

    /**
     * Creates a 2D bar plot with the default title "Bar Plot",
     * x-label "Category", and y-label "Value".
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
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

    public BarPlot(String[] dataNames,
                   String[] category,
                   double[] ...data)
    {
        this(dataNames, "Bar Plot", "Category", "Value", category, data);
    }

}
