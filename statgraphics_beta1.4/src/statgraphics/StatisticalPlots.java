package statgraphics;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

import java.util.*;

import statgraphics.eda.*;
import statgraphics.regression.lm.*;
import statgraphics.survival.*;
import static statgraphics.util.Argument.*;
import static statgraphics.util.PlotType.*;
import statgraphics.util.*;

/**
 *
 * <p>This class generates a variety of statistical plots. </p>
 * <p> </p>
 * <br> Example:
 * <br> PlotFrame[] pf=new PlotFrame[12];
 * <br>
 * <br> // 3D bar plot
 * <br> String [] category =
 *        {"Apple", "Compaq", "GateWay 2000", "IBM", "Packard Bell"};
 * <br> double [][] data = {{13, 12, 5, 9, 11}, {12, 13, 6, 8, 11},
 *                          {14, 11, 4, 11, 10}};
 * <br> String [] dataNames = {"2002", "2003", "2004"};
 * <br> Hashtable argument = new Hashtable();
 * <br> argument.put(PLOT_TYPE, BAR);
 * <br> argument.put(TITLE, "Bar Plot B");
 * <br> argument.put(XLABEL, "Company");
 * <br> argument.put(YLABEL, "Frequency");
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(OPTION, "3D");
 * <br> GraphicalAnalysis graphicalAnalysis =
 * <br> &nbsp;&nbsp;&nbsp;
 *        new StatisticalPlots(argument, category, data).graphicalAnalysis;
 * <br> JFreeChart plot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf[0] = new PlotFrame("3D Bar Plot", plot, 500, 270);
 * <br>
 * <br> // 2D bar plot
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, BAR);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(OPTION, "2D");
 * <br> graphicalAnalysis = new StatisticalPlots(argument, category, data).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf[1] = new PlotFrame("2D Bar Plot ", plot, 500, 270);
 * <br>
 * <br> // 2D pie plot
 * <br> category = new String[]{"Apple", "Compaq", "GateWay 2000", "IBM",
 *                              "Packard Bell"};
 * <br> data[0] = new double[]{13, 12, 5, 9, 11};
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, PIE);
 * <br> graphicalAnalysis = new StatisticalPlots(argument, category, data[0]).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[2] = new PlotFrame("2D Pie Plot", plot, 500, 270);
 * <br>
 * <br> // 3D pie plot
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, PIE);
 * <br> argument.put(OPTION, "3D");
 * <br> graphicalAnalysis = new StatisticalPlots(argument, category, data[0]).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[3] = new PlotFrame("3D Pie Plot", plot, 500, 270);
 * <br>
 * <br> // Histogram
 * <br> data [][] = {{12, 14, 19, 18, 15, 15, 18, 17, 20, 27, 22, 23, 22, 21,
 *                    33, 28, 14, 18, 16, 13},
 * <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 *                   {4, 2, 3, 2, 6, 9, 2, 5, 6, 6, 12, 2, 11, 9, 6, 9, 8, 9, 2,
 *                    7}};
 * <br> dataNames = {"2004", "2005"};
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, HISTOGRAM);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(BIN_NUMBER, 5);
 * <br> graphicalAnalysis = new StatisticalPlots(argument, data).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
 * <br> pf[4] = new PlotFrame("Histogram", plot, 500, 270);
 * <br>
 * <br> // Time series plot
 * <br> int [][][] time = new int[2][12][6];
 * <br> data = new double[2][12];
 * <br> dataNames = {"Company A","Company B"};
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
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, TIME_SERIES);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(TITLE, "Time Series Plot");
 * <br> argument.put(XLABEL, "Date");
 * <br> argument.put(YLABEL, "Stock Price");
 * <br> graphicalAnalysis = new StatisticalPlots(argument, time, data).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[5] = new PlotFrame("Time Series Plot", plot, 500, 270);
 * <br>
 * <br> // Box plot
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
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, BOX);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(TITLE, "Box Plot");
 * <br> argument.put(XLABEL, "Category");
 * <br> argument.put(YLABEL, "Data Value");
 * <br> graphicalAnalysis = new StatisticalPlots(argument,data).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[6] = new PlotFrame("Box Plot", plot, 500, 270);
 * <br>
 * <br> // Box plot associated with time
 * <br> Date [] time = new Date[12];
 * <br> for(int i = 0; i < 12; i++)
 * <br> {
 * <br> &nbsp;&nbsp;&nbsp;
 *        time[i] = new Date(105, i - 1, 21);
 * <br> }
 * <br> argument.remove(DATA_NAMES);
 * <br> graphicalAnalysis = new StatisticalPlots(argument, date, data).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[7] = new PlotFrame("Box Plot", plot, 500, 270);
 * <br>
 * <br> // Scatter plot
 * <br> double xdata [][] = {{2, 5, 1, 3, 4, 1, 5, 3, 4, 2},
 *                           {2, 3, 4, 2, 5, 3, 4, 1, 3, 4}};
 * <br> double [][] ydata = {{50, 57, 41, 54, 54, 38, 63, 48, 59, 46},
 *                           {39, 42, 37, 32, 42, 45, 32, 43, 45, 35}};
 * <br> dataNames = {"2004", "2005"};
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, SCATTER);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> graphicalAnalysis = new StatisticalPlots(argument, xdata, ydata).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[8] = new PlotFrame("Scatter Diagram", plot, 500, 270);
 * <br>
 * <br> // Ogive plot
 * <br> double [][] sortXData = {{9, 14, 19, 24, 29, 34},
 *                               {11, 13, 17, 22, 26, 28, 31}};
 * <br> double [][] sortYData = {{0, 4, 12, 17, 19, 20},
 *                               {0, 2, 10, 13, 15, 16, 18}};
 * <br> dataNames = new String[]{"Company A", "Company B"};
 * <br> argument.clear();
 * <br> argument.put(PLOT_TYPE, LINE);
 * <br> argument.put(DATA_NAMES, dataNames);
 * <br> argument.put(TITLE, "Ogive Plot");
 * <br> argument.put(XLABEL, "Audit Time in Days");
 * <br> argument.put(YLABEL, "Cumulative Frequency");
 * <br> graphicalAnalysis =
 *        new StatisticalPlots(argument, sortXData, sortYData).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[9] = new PlotFrame("Exploratory Data Analysis", plot, 500, 270);
 * <br>
 * <br> // Scree plot
 * <br> double [] variance = {3.59, 1.63, 1.11, 0.70, 0.38, 0.30, 0.14, 0.11};
 * <br> String [] componentList = {"Comp. 1", "Comp. 2", "Comp. 3", "Comp. 4",
 *                                 "Comp. 5", "Comp. 6", "Comp. 7", "Comp. 8"};
 * <br> dataNames[0] = "Component";
 * <br> argument.put(DATA_NAMES, dataNames[0]);
 * <br> argument.put(TITLE, "Principal Component Analysis");
 * <br> argument.put(XLABEL, "Principal Component");
 * <br> argument.put(YLABEL, "Variance");
 * <br> graphicalAnalysis =
 *        new StatisticalPlots(argument, componentList, variance).
 *        graphicalAnalysis;
 * <br> plot = (JFreeChart) graphicalAnalysis.plot;
 * <br> pf[10] = new PlotFrame("Scree Plot", plot, 500, 270);
 *
 * <br> new PlotFrameFactory().putPlotFrame(pf);
 */

public class StatisticalPlots extends GraphicalAnalysis
{

    /**
     * The object represents a bar plot.
     */

    public GraphicalAnalysis graphicalAnalysis;

    /**
     * Default StatisticalPlots constructor.
     */

    public StatisticalPlots() {}

    /**
     * The plot of interest.
     * @param argument the argument with the following choices,
     * <br> PLOT_TYPE: the enum in the class PlotType or the choices "BAR",
     *                 "COMBINED_LINE_BAR", "BOX", "HISTOGRAM", "LINE","PIE",
     *                 "TIME_SERIES", "LINEAR_REGRESSION", "SURVIVAL" and
     *                 "SCATTER";
     * <br> See the class Argument for other arguments.
     * <br><br>
     * @param dataObject the input data.
     * @exception IllegalArgumentException wrong input argument(s) or data.
     */

    public StatisticalPlots(Hashtable argument,
                            Object ...dataObject)
    {
        this.argument = argument;
        this.dataObject = dataObject;
        if (dataObject != null &&
            argument.get(PLOT_TYPE) != null)
        {
            switch ((PlotType) argument.get(PLOT_TYPE))
            {
                case BAR:
                    graphicalAnalysis = new BarPlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case BAR3D:
                    argument.put(OPTION, "3D");
                    graphicalAnalysis = new BarPlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case COMBINED_LINE_BAR:
                    graphicalAnalysis =
                            new CombinedLineBarPlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case BOX_DATE:
                    graphicalAnalysis = new BoxPlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case BOX:
                    graphicalAnalysis = new BoxPlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case HISTOGRAM:
                    graphicalAnalysis = new Histogram(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case LINE_CATEGORY:
                    graphicalAnalysis = new LinePlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case LINE:
                    graphicalAnalysis = new LinePlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case PIE:
                    graphicalAnalysis = new PiePlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case PIE3D:
                    argument.put(OPTION, "3D");
                    graphicalAnalysis = new PiePlot(argument, dataObject).
                                        graphicalAnalysis;
                    break;
                case TIME_SERIES:
                    graphicalAnalysis =
                        new TimeSeriesPlot(argument, dataObject).
                        graphicalAnalysis;
                    break;
                case LINE_POINT:
                    graphicalAnalysis = new LinearRegressionPlot(argument,
                            dataObject).graphicalAnalysis;
                    break;
                case LINEAR_REGRESSION:
                    graphicalAnalysis = new LinearRegressionPlot(argument,
                            dataObject).graphicalAnalysis;
                    break;
                case SURVIVAL:
                    graphicalAnalysis = new SurvivalEstimatePlot(argument,
                            dataObject).graphicalAnalysis;
                    break;
                default:
                    graphicalAnalysis = new ScatterPlot(argument, dataObject).
                                        graphicalAnalysis;
            }
        }
        else
        {
            throw new IllegalArgumentException("Wrong input arguments or " +
                                               "data.");
        }
    }

}
