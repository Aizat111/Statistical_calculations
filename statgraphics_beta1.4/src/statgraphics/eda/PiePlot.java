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
 * <p>Generates a pie plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> String [] category = {"Apple", "Compaq", "GateWay 2000", "IBM",
 *                            "Packard Bell"};
 * <br> double [] data = {13, 12, 5, 9, 11};
 * <br> // 3D pie plot
 * <br> PlotFrame pf = new PlotFrame("Pie Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new PiePlot("3D", "Computer Sale Data", category, data).getPlot(),
 *        500, 270);
 * <br> pf = new PlotFrame("Pie Plot II",
 *        new PiePlot("3D", category, data).plot, 500, 270);
 * <br> // 2D pie plot
 * <br> pf = new PlotFrame("Pie Plot III",
 *        new PiePlot(category, data).getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the pie plot
 * <br> Hashtable argument = new Hashtable();
 * <br> // 2D pie plot
 * <br> pf = new PlotFrame("Pie Plot IV",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new PiePlot(argument, category, data).graphicalAnalysis.getPlot(),
 *        500, 270);
 * <br>
 * <br> // 3D pie plot
 * <br> argument.put(OPTION, "3D");
 * <br> GraphicalAnalysis graphicalAnalysis =
 *        new PiePlot(argument, category, data).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Pie Plot V", myPlot, 500, 270);
 * <br>
 * <br> // 3D pie plot
 * <br> argument.put(TITLE, "Computer Sale Data");
 * <br> pf = new PlotFrame("Pie Plot VI",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new PiePlot(argument, category, data).graphicalAnalysis.plot,
 *        500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class PiePlot extends GraphicalAnalysis
{

    /**
     * The input category.
     */

    public String[] category;

    /**
     * The number of data corresponding to the categories.
     */

    public double[] counts;

    /**
     * The object represents a pie plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default PiePlot constructor.
     */

    public PiePlot() {}

    /**
     * Creates a new pie plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> OPTION, TITLE: complete list of arguments;
     * <br> OPTION: the default title "Pie Plot";
     * <br> empty argument: generating a 2D pie plot with the default title
     *                      "Pie Plot".
     * <br><br>
     * @param dataObject the categories the data belong to and
     *                   number of the data corresponding to the categories
     * @exception IllegalArgumentException wrong input argument(s) or data.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public PiePlot(Hashtable argument,
                   Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (dataObject != null)
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
            if (argument.get(PLOT_OPTION) != null &&
                argument.get(TITLE) != null &&
                dataObject.length == 2 &&
                dataObject[0].getClass().getName().equalsIgnoreCase(
                        "[Ljava.lang.String;") &&
                dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                graphicalAnalysis = new PiePlot(
                        (String) argument.get(PLOT_OPTION),
                        (String) argument.get(TITLE),
                        (String[]) dataObject[0], (double[]) dataObject[1]);
            }
            else if (argument.get(OPTION) != null &&
                     argument.get(TITLE) != null &&
                     dataObject.length == 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.lang.String;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                graphicalAnalysis = new PiePlot(
                        (String) argument.get(OPTION),
                        (String) argument.get(TITLE),
                        (String[]) dataObject[0], (double[]) dataObject[1]);
            }
            else if (argument.get(PLOT_OPTION) != null &&
                     dataObject.length == 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.lang.String;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                graphicalAnalysis = new PiePlot(
                        (String) argument.get(PLOT_OPTION),
                        (String[]) dataObject[0], (double[]) dataObject[1]);
            }
            else if (argument.get(OPTION) != null &&
                     dataObject.length == 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.lang.String;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                graphicalAnalysis = new PiePlot(
                        (String) argument.get(OPTION),
                        (String[]) dataObject[0], (double[]) dataObject[1]);
            }
            else if (dataObject.length == 2 &&
                     dataObject[0].getClass().getName().equalsIgnoreCase(
                             "[Ljava.lang.String;") &&
                     dataObject[1].getClass().getName().equalsIgnoreCase("[D"))
            {
                graphicalAnalysis = new PiePlot(
                        (String[]) dataObject[0], (double[]) dataObject[1]);
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
     * Creates a new pie plot with the specified categories, number of data
     * corresponding to the categories, and title.
     * @param option the type of the plot with the choices "2D" or "3D".
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @param title the plot title.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public PiePlot(String option,
                   String title,
                   String[] category,
                   double[] counts)
    {
        this.category = category;
        this.counts = counts;
        if (option.equalsIgnoreCase("3D") ||
            option.equalsIgnoreCase("Three Dimensional"))
        {
            this.plot = new Plot3DFactory().createPie3DPlot(title, category,
                    counts);
        }
        else
        {
            this.plot = new Plot2DFactory().createPiePlot(title, category,
                    counts);
        }
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new pie plot with the default title "Pie Plot", specified
     * categories, and number of data corresponding to the categories.
     * @param option the type of the plot with the choices "2D" or "3D".
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public PiePlot(String option,
                   String[] category,
                   double[] counts)
    {
        this(option, "Pie Plot", category, counts);
    }

    /**
     * Creates a new 2D pie plot with the default title "Pie Plot", specified
     * categories, and number of data corresponding to the categories.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public PiePlot(String[] category,
                   double[] counts)
    {
        this("2D", "Pie Plot", category, counts);
    }

}
