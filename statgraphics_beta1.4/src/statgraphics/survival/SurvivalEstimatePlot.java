package statgraphics.survival;

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
 * <p>Generates a survival estimate plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> double [] sortedTime = {{59, 115, 156, 268, 329, 353, 365, 431, 464,
 *                               475, 563, 638, 700},
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *                              {76, 105, 144, 201, 254, 315, 447, 527, 655}};
 * <br> double [] sortedSurvivalEstimate1 = {0.9615, 0.9231, 0.8846, 0.8462,
 *                                           0.8077, 0.7692,
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *                                           0.7308, 0.6878, 0.6419, 0.5961,
 *                                           0.5464, 0.4967, 0.4967};
 * <br> double[] sortedSurvivalEstimate2 = {0.8812, 0.8234, 0.7689, 0.6612,
 *                                          0.5644, 0.5034, 0.3416, 0.3001,
 *                                          0.2219}};
 * <br> String[] names = new String[]{"Control", "Treatment"};
 * <br>
 * <br> PlotFrame pf = new PlotFrame("Kaplan-Meier Estimate Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new SurvivalEstimatePlot(names[0], sortedTime1,
 *        sortedSurvivalEstimate1).getPlot(), 500, 270);
 * <br>
 * <br> pf = new PlotFrame("Kaplan-Meier Estimate Plot II",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new SurvivalEstimatePlot(names,
 *        new double[][]{sortedTime1, sortedTime2},
 * <br> &nbsp;&nbsp;&nbsp;
 *        new double[][]{sortedSurvivalEstimate1, sortedSurvivalEstimate2}).
 *        plot, 500, 270);
 * <br>
 * <br> // Another way to generate the time series plot
 * <br> Hashtable argument = new Hashtable();
 * <br> argument.put(DATA_NAMES, names[0]);
 * <br> GraphicalAnalysis graphicalAnalysis = new SurvivalEstimatePlot(
 * <br> &nbsp;&nbsp;&nbsp;
 *        argument, sortedTime1, sortedSurvivalEstimate1).graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Kaplan-Meier Estimate Plot III", myPlot, 500, 270);
 * <br>
 * <br> argument.put(DATA_NAMES, names);
 * <br> graphicalAnalysis = new SurvivalEstimatePlot(argument,
 *        new double[][]{sortedTime1, sortedTime2},
 * <br> &nbsp;&nbsp;&nbsp;
 *        new double[][]{sortedSurvivalEstimate1, sortedSurvivalEstimate2}).
 *        graphicalAnalysis;
 * <br> pf = new PlotFrame("Kaplan-Meier Estimate Plot IV",
 *        graphicalAnalysis.plot, 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class SurvivalEstimatePlot extends GraphicalAnalysis
{

    /**
     * The survival times in ascending order.
     */

    public double[][] sortedTime;

    /**
     * The survival estimates in descending order.
     */

    public double[][] sortedSurvivalEstimate;

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
     * The object represents a survival estimate plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default SurvivalEstimatePlot constructor.
     */

    public SurvivalEstimatePlot() {}

    /**
     * Creates a new survival estimate plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> DATANAMES: the default title "Survival Estimate Plot", x-label
     *                 "Survival Time", and y-label "Survival Estimate".
     * <br><br>
     * @param dataObject the series of survival times in ascending order and
     *                   associated survival estimates in descending order.
     * @exception IllegalArgumentException wrong input argument(s) or data or
     *                                     data type.
     * @exception IllegalArgumentException the sortedTime vector and
     *                                     sortedSurvivalEstimate vector must
     *                                     have the same length.
     */

    public SurvivalEstimatePlot(Hashtable argument,
                                Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (dataObject != null &&
            dataObject.length == 2)
        {
            if (argument.get(DATA_NAMES) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                if (dataObject[0].getClass().getName().
                    equalsIgnoreCase("[[D") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new SurvivalEstimatePlot(
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
                    graphicalAnalysis = new SurvivalEstimatePlot(
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
                if (dataObject[0].getClass().getName().
                    equalsIgnoreCase("[[D") &&
                    dataObject[1].getClass().getName().equalsIgnoreCase("[[D"))
                {
                    graphicalAnalysis = new SurvivalEstimatePlot(
                            (String[]) argument.get(DATA_NAMES),
                            (double[][]) dataObject[0],
                            (double[][]) dataObject[1]);
                }
                else if (dataObject[0].getClass().getName().
                         equalsIgnoreCase("[D") &&
                         dataObject[1].getClass().getName().
                         equalsIgnoreCase("[D"))
                {
                    graphicalAnalysis = new SurvivalEstimatePlot(
                            (String) argument.get(DATA_NAMES),
                            (double[]) dataObject[0], (double[]) dataObject[1]);
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
     * Creates a new survival estimate plot with the specified names of the
     * survival data, title, and labels for the x-coordinate and y-coordinate.
     * @param dataNames the names of these series.
     * <br>             dataNames[j]: the name of the (j+1)'th series.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param sortedTime the series of survival times in ascending order,
     * <br>              sortedTime[j]: the (j+1)'th series of survival times.
     * @param sortedSurvivalEstimate the series of survival estimates in
     *                               descending order,
     * <br>                          sortedSurvivalEstimate[j]: the (j+1)'th
     *                                          series of survival estimates.
     * @exception IllegalArgumentException the sortedTime vector and
     *                                     sortedSurvivalEstimate vector must
     *                                     have the same length.
     */

    public SurvivalEstimatePlot(String[] dataNames,
                                String title,
                                String xLabel,
                                String yLabel,
                                double[][] sortedTime,
                                double[][] sortedSurvivalEstimate)
    {
        this.sortedTime = sortedTime;
        this.sortedSurvivalEstimate = sortedSurvivalEstimate;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createSurvivalEstimatePlot(
                dataNames, title, xLabel, yLabel, sortedTime,
                sortedSurvivalEstimate);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new survival estimate plot with the specified title and
     * labels for the x-coordinate and y-coordinate.
     * @param dataName the name of the input survival data.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param sortedTime the survival times in ascending order.
     * @param sortedSurvivalEstimate the survival estimates in descending order.
     * @exception IllegalArgumentExceptionn the sortedTime vector and
     *                                      sortedSurvivalEstimate vector must
     *                                      have the same length.
     */

    public SurvivalEstimatePlot(String dataName,
                                String title,
                                String xLabel,
                                String yLabel,
                                double[] sortedTime,
                                double[] sortedSurvivalEstimate)
    {
        this(new String[] {dataName}, title, xLabel, yLabel,
             new double[][] {sortedTime},
             new double[][] {sortedSurvivalEstimate});
    }


    /**
     * Creates a new survival estimate plot with the specified names of the
     * survival data and default title "Survival Estimate Plot", x-label
     * "Survival Time", and y-label "Survival Estimate".
     * @param dataNames the names of these series.
     * <br>             dataNames[j]: the name of the (j+1)'th series.
     * @param sortedTime the series of survival times in ascending order,
     * <br>              sortedTime[j]: the (j+1)'th series of survival times.
     * @param sortedSurvivalEstimate the series of survival estimates in
     *                               descending order,
     * <br>                          sortedSurvivalEstimate[j]: the (j+1)'th
     *                                          series of survival estimates.
     * @exception IllegalArgumentException the sortedTime vector and
     *                                     sortedSurvivalEstimate vector must
     *                                     have the same length.
     */

    public SurvivalEstimatePlot(String[] dataNames,
                                double[][] sortedTime,
                                double[][] sortedSurvivalEstimate)
    {
        this(dataNames, "Survival Estimate Plot", "Survival Time",
             "Survival Estiamte",
             sortedTime, sortedSurvivalEstimate);
    }

    /**
     * Creates a new survival estimate plot with the specified name of the
     * survival data and default title "Survival Estimate Plot", x-label
     * "Survival Time", and y-label "Survival Estimate".
     * @param dataName the name of the input survival data.
     * @param sortedTime the survival times in ascending order.
     * @param sortedSurvivalEstimate the survival estimates in descending order.
     * @exception IllegalArgumentException the sortedTime vector and
     *                                     sortedSurvivalEstimate vector must
     *                                     have the same length.
     */

    public SurvivalEstimatePlot(String dataName,
                                double[] sortedTime,
                                double[] sortedSurvivalEstimate)
    {
        this(dataName, "Survival Estimate Plot", "Survival Time",
             "Survival Estiamte",
             sortedTime, sortedSurvivalEstimate);
    }

}
