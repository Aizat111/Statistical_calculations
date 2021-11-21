package statgraphics.regression.lm;

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
 * <p>Generates a linear regression plot.</p>
 * <p> </p>
 * <br> Example:
 * <br> double [] ydata = {58, 105, 88, 118, 117, 137, 157, 169, 149, 202};
 * <br> double [] xdata = {2, 6, 8, 8, 12, 16, 20, 20, 22, 26};
 * <br> double [] p1 = {0, 60};
 * <br> double [] p2 = {30, 210};
 * <br> String title = "Y = 60 + 5X ";
 * <br> String xLabel = "Student Population";
 * <br> String yLabel = "Quarterly Sales";
 * <br>
 * <br> PlotFrame pf = new PlotFrame("Regression Plot I",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new LinearRegressionPlot(title, xLabel, yLabel, p1, p2, xdata, ydata).
 *        plot, 500, 270);
 * <br> pf = new PlotFrame("Regression Plot II", new LinearRegressionPlot(
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Pizza Data", xLabel, yLabel, xdata, ydata).
 *        getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the regression plot
 * <br> Hashtable argument = new Hashtable();
 * <br> GraphicalAnalysis graphicalAnalysis =
 * <br> &nbsp;&nbsp;&nbsp;
 *        new LinearRegressionPlot(argument, p1, p2, xdata, ydata).
 *        graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Regression Plot III", myPlot, 500, 270);
 * <br>
 * <br> argument.put(TITLE, "Y = 60 + 5X ");
 * <br> argument.put(XLABEL, "Student Population");
 * <br> argument.put(YLABEL, "Quarterly Sales");
 * <br> argument.put(DATA_NAMES, "Pizza Data");
 * <br> pf = new PlotFrame("Line Plot IV",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new LinearRegressionPlot(argument, p1, p2, xdata, ydata).
 *        graphicalAnalysis.plot, 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class LinearRegressionPlot extends GraphicalAnalysis
{

    /**
     * The data for the x-coordinate.
     */

    public double[] xData;

    /**
     * The data for the y-coordinate.
     */

    public double[] yData;

    /**
     * The start of the line.
     */

    public double[] p1;

    /**
     * The end of the line.
     */

    public double[] p2;

    /**
     * The name of the data set.
     */

    public String dataName;

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
     * The object represents a linear regression plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default LinearRegressionPlot constructor.
     */

    public LinearRegressionPlot() {}

    /**
     * Creates a new regression plot given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, TITLE, XLABEL, YLABEL: complete list of arguments;
     * <br> TITLE, XLABEL, YLABEL: the default data name "Data";
     * <br> empty argument: the default data name "Data", title
     *                      "Regression Plot", x-label "X" and y-label "Y".
     * <br><br>
     * @param dataObject the input data for the x-coordinate and y-coordinate.
     * @exception IllegalArgumentException wrong input argument(s) or data or
     *                                     data type.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     */

    public LinearRegressionPlot(Hashtable argument,
                                Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (dataObject != null)
        {
            if (dataObject.length == 4 &&
                dataObject[0].getClass().getName().equalsIgnoreCase("[D") &&
                dataObject[1].getClass().getName().equalsIgnoreCase("[D") &&
                dataObject[2].getClass().getName().equalsIgnoreCase("[D") &&
                dataObject[3].getClass().getName().equalsIgnoreCase("[D"))
            {
                if (argument.get(TITLE) != null &&
                    argument.get(XLABEL) != null &&
                    argument.get(YLABEL) != null)
                {
                    graphicalAnalysis = new LinearRegressionPlot(
                            (String) argument.get(TITLE),
                            (String) argument.get(XLABEL),
                            (String) argument.get(YLABEL),
                            (double[]) dataObject[0], (double[]) dataObject[1],
                            (double[]) dataObject[2], (double[]) dataObject[3]);
                }
                else if (argument.size() == 0)
                {
                    graphicalAnalysis = new LinearRegressionPlot(
                            (double[]) dataObject[0], (double[]) dataObject[1],
                            (double[]) dataObject[2], (double[]) dataObject[3]);
                }
                else
                {
                    throw new IllegalArgumentException(
                            "Wrong input argument(s).");
                }
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


    /**
     * Creates a new regression plot with a fitted line given the title and
     * labels for the x-coordinate and y-coordinate.
     * @param title the plot title.
     * @param xLabel the label for the x-coordinate.
     * @param yLabel the label for the y-coordinate.
     * @param p1 the start of the line,
     * <br>      (p1[0],p1[1]) is the starting point.
     * @param p2 the end of the line,
     * <br>      (p2[0],p2[1]) is the end point.
     * @param xData the data for the x-coordinate.
     * @param yData the data for the y-coordinate.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     */

    public LinearRegressionPlot(String title,
                                String xLabel,
                                String yLabel,
                                double[] p1,
                                double[] p2,
                                double[] xData,
                                double[] yData)
    {
        this.xData = xData;
        this.yData = yData;
        this.p1 = p1;
        this.p2 = p2;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.plot = new Plot2DFactory().createLineAndPointsPlot(title, xLabel,
                yLabel, p1, p2, xData, yData);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new regression plot with a fitted line.
     * @param p1 the start of the line,
     * <br>      (p1[0],p1[1]) is the starting point.
     * @param p2 the end of the line,
     * <br>      (p2[0],p2[1]) is the end point.
     * @param xData the data for the x-coordinate.
     * @param yData the data for the y-coordinate.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     */

    public LinearRegressionPlot(double[] p1,
                                double[] p2,
                                double[] xData,
                                double[] yData)
    {
        this("Regression Plot", "X", "Y", p1, p2, xData, yData);
    }

}
