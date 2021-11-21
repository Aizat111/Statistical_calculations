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
 * <p>Generates a histogram.</p>
 * <p> </p>
 * <br> Example:
 * <br> data [][] = {{12, 14, 19, 18, 15, 15, 18, 17, 20, 27, 22, 23, 22, 21,
 *                    33, 28, 14, 18, 16, 13},
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *                   {4, 2, 3, 2, 6, 9, 2, 5, 6, 6, 12, 2, 11, 9, 6, 9, 8, 9, 2,
 *                    7}};
 * <br> dataNames = {"2004", "2005"};
 * <br> PlotFrame pf = new PlotFrame("Histogram I", new Histogram(dataNames, 5,
 * <br> &nbsp;&nbsp;&nbsp;
 *        "Relative Frequency", "Histogram (R.F.)", "Sales", "R. F.", data).
 *        plot, 500, 270);
 * <br> pf = new PlotFrame("Histogram II", new Histogram(
 * <br> &nbsp;&nbsp;&nbsp;
 *        dataNames, 5, "Histogram (F)", "Sales", "Frequency", data).getPlot(),
 *        500, 270);
 * <br> pf = new PlotFrame("Histogram III",
 *        new Histogram(dataNames, 5, data).plot, 500, 270);
 * <br> pf = new PlotFrame("Histogram IV",
 *        new Histogram(dataNames,data).getPlot(), 500, 270);
 * <br>
 * <br> // Another way to generate the histogram
 * <br> Hashtable argument1 = new Hashtable();
 * <br> argument1.put(DATA_NAMES, dataNames);
 * <br> argument1.put(BIN_NUMBER, 5);
 * <br> argument1.put(FREQUENCY_CHOICE, "Relative Frequency");
 * <br> argument1.put(TITLE, "Histogram (R.F.)");
 * <br> argument1.put(XLABEL, "Sales");
 * <br> argument1.put(YLABEL, "R. F.");
 * <br> pf = new PlotFrame("Histogram V",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new Histogram(argument1, data).graphicalAnalysis.plot, 500, 270);
 * <br>
 * <br> argument1.remove(FREQUENCY_CHOICE);
 * <br> argument1.put(YLABEL, "Frequency");
 * <br> argument1.put(TITLE, "Histogram (Frequency)");
 * <br> pf = new PlotFrame("Histogram VI",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new Histogram(argument1, data).graphicalAnalysis.getPlot(), 500, 270);
 * <br>
 * <br> Hashtable argument2 = new Hashtable();
 * <br> argument2.put(DATA_NAMES, dataNames);
 * <br> argument2.put(BIN_NUMBER, 5);
 * <br> GraphicalAnalysis graphicalAnalysis = new Histogram(argument2, data).
 *        graphicalAnalysis;
 * <br> JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf = new PlotFrame("Histogram VII", myPlot, 500, 270);
 * <br>
 * <br> Hashtable argument3 = new Hashtable();
 * <br> argument3.put(DATA_NAMES, dataNames);
 * <br> pf = new PlotFrame("Histogram VIII",
 * <br> &nbsp;&nbsp;&nbsp;
 *        new Histogram(argument3, data).graphicalAnalysis.getPlot(), 500, 270);
 * <br>
 * <br> // Places the plot frame in a container
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class Histogram extends GraphicalAnalysis
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
     * The number of bins.
     */

    public int binNumber;

    /**
     * The specification of the frequency.
     */

    public String frequencyChoice;

    /**
     * The object represents a histogram.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * The input data series.
     */

    private double[][] doubleData;

    /**
     * Default Histogram constructor.
     */

    public Histogram() {}

    /**
     * Creates a new histogram given the input arguments and data.
     * @param argument the arguments with the following choices,
     * <br> DATANAMES, BIN_NUMBER, FREQUENCY_CHOICE, TITLE, XLABEL, YLABEL:
     *      complete list of arguments;
     * <br> DATANAMES, BIN_NUMBER, TITLE, XLABEL, YLABEL: the frquency being
     *                                                    used;
     * <br> DATANAMES, BIN_NUMBER: the frequency being used, defalut title
     *                             "Histogram", null x-label, and y-label
     *                             "Frequency";
     * <br> DATANAMES: the frequency being used, default number of bins equal
     *                 to 4, title "Histogram", null x-label, and y-label
     *                 "Frequency".
     * <br><br>
     * @param dataObject the input data series.
     * @exception IllegalArgumentException wrong input argument(s) or data or
     *                                     data type.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public Histogram(Hashtable argument,
                     Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (argument.size() > 0 &&
            dataObject != null)
        {
            if (dataObject.getClass().getName().equalsIgnoreCase("[[D"))
            {
                doubleData = (double[][]) dataObject;
            }
            else if (dataObject.getClass().getName().equalsIgnoreCase(
                     "[Ljava.lang.Object;"))
            {
                doubleData = DataCreator.castToDoubleData(0, dataObject);
            }
            else
            {
                throw new IllegalArgumentException("Wrong input data type.");
            }
            if (argument.get(DATA_NAMES) != null &&
                argument.get(BIN_NUMBER) != null &&
                argument.get(FREQUENCY_CHOICE) != null &&
                argument.get(TITLE) != null &&
                argument.get(XLABEL) != null &&
                argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new Histogram(
                        (String[]) argument.get(DATA_NAMES),
                        ((Integer) argument.get(BIN_NUMBER)).intValue(),
                        (String) argument.get(FREQUENCY_CHOICE),
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        doubleData);
            }
            else if (argument.get(DATA_NAMES) != null &&
                     argument.get(BIN_NUMBER) != null &&
                     argument.get(TITLE) != null &&
                     argument.get(XLABEL) != null &&
                     argument.get(YLABEL) != null)
            {
                graphicalAnalysis = new Histogram(
                        (String[]) argument.get(DATA_NAMES),
                        ((Integer) argument.get(BIN_NUMBER)).intValue(),
                        (String) argument.get(TITLE),
                        (String) argument.get(XLABEL),
                        (String) argument.get(YLABEL),
                        doubleData);
            }
            else if (argument.get(DATA_NAMES) != null &&
                     argument.get(BIN_NUMBER) != null)
            {
                graphicalAnalysis = new Histogram(
                        (String[]) argument.get(DATA_NAMES),
                        ((Integer) argument.get(BIN_NUMBER)).intValue(),
                        doubleData);
            }
            else if (argument.get(DATA_NAMES) != null)
            {
                graphicalAnalysis = new Histogram(
                        (String[]) argument.get(DATA_NAMES),
                        doubleData);
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
     * Creates a new histogram with the specified names of the data series, bin
     * number, choice of frequency type, and title.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the number of bins.
     * @param frequencyChoice the specification of the frequency with the
     *                        choices "Frequency" or "Relative Frequency".
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public Histogram(String[] dataNames,
                     int binNumber,
                     String frequencyChoice,
                     String title,
                     String xLabel,
                     String yLabel,
                     double[] ...data)
    {
        this.data = data;
        this.dataNames = dataNames;
        this.binNumber = binNumber;
        this.frequencyChoice = frequencyChoice;
        this.plot = new Plot2DFactory().createHistogram(dataNames, binNumber,
                frequencyChoice, title, xLabel, yLabel, data);
        output.put(PLOT, this.plot);
    }

    /**
     * Creates a new histogram based on the frequency with the specified names
     * of the data series, bin number, and title.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the number of bins.
     * @param title the plot title.
     * @param xLabel the label for the x-axis.
     * @param yLabel the label for the y-axis.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public Histogram(String[] dataNames,
                     int binNumber,
                     String title,
                     String xLabel,
                     String yLabel,
                     double[] ...data)
    {
        this(dataNames, binNumber, "Frequency", title, xLabel, yLabel, data);
    }

    /**
     * Creates a new histogram based on the frequency with the specified names
     * of the data series, bin number and the default title "Histogram", null
     * x-label, and y-label "Frequency"..
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the number of bins.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public Histogram(String[] dataNames,
                     int binNumber,
                     double[] ...data)
    {
        this(dataNames, binNumber, "Frequency", "Histogram", null, "Frequency",
             data);
    }

    /**
     * Creates a new histogram based on the frequency with the specified names
     * of the data series, bin number equal to 4 and the default title
     * "Histogram", null x-label, and y-label "Frequency"..
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @param dataNames the names of the data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public Histogram(String[] dataNames,
                     double[] ...data)
    {
        this(dataNames, 4, data);
    }

}
