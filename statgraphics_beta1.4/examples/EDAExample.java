import java.util.*;

import statgraphics.eda.*;
import statgraphics.util.*;

/**
 *
 * <p>Example: classes for the plots in exploratory data analysis.</p>
 */

public class EDAExample
{

    public static void main(String[] args)
    {
        PlotFrame[] pf = new PlotFrame[14];
        String[] barCategory = {"Apple", "Compaq", "GateWay 2000", "IBM",
                                "Packard Bell"};
        double[][] barData = { {13, 12, 5, 9, 11}, {12, 13, 6, 8, 11},
                               {14, 11, 4, 11, 10} };
        String[] barDataNames = {"2002", "2003", "2004"};
        pf[0] = new PlotFrame("2D Bar Plot",
                              new BarPlot(barDataNames, barCategory, barData).
                              getPlot(), 500, 270);
        pf[1] = new PlotFrame("3D Bar Plot",
                              new BarPlot("3D", barDataNames, barCategory,
                                          barData).getPlot(), 500, 270);

        double[][] boxData = new double[12][20];
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                boxData[i][j] = -10 + Math.random() * 20.0;
            }
        }
        String[] boxDataNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                                 "J", "K", "L"};
        pf[2] = new PlotFrame("Box Plot",
                              new BoxPlot(boxDataNames, boxData).getPlot(),
                              500, 270);
        Date[] boxTime = new Date[12];
        for (int i = 0; i < 12; i++)
        {
            boxTime[i] = new Date(105, i - 1, 21);
        }
        pf[3] = new PlotFrame("Box Plot", new BoxPlot(boxTime, boxData).plot,
                              500, 270);

        double histogramData[][] = { {12, 14, 19, 18, 15, 15, 18, 17, 20, 27,
                                      22, 23, 22, 21, 33, 28, 14, 18, 16, 13},
                                     {4, 2, 3, 2, 6, 9, 2, 5, 6, 6, 12, 2, 11,
                                      9, 6, 9, 8, 9, 2, 7}
                                   };
        String[] histogramDataNames = {"2004", "2005"};
        pf[4] = new PlotFrame("Histogram",
                              new Histogram(histogramDataNames, 5,
                                            histogramData).plot, 500, 270);

        String[] pieCategory = {"Apple", "Compaq", "GateWay 2000", "IBM",
                                "Packard Bell"};
        double[] pieData = {13, 12, 5, 9, 11};
        pf[5] = new PlotFrame("3D Pie Plot",
                              new PiePlot("3D", pieCategory, pieData).getPlot(),
                              500, 270);
        pf[6] = new PlotFrame("2D Pie Plot",
                              new PiePlot("2D", pieCategory, pieData).getPlot(),
                              500, 270);

        double[][] scatterXData = { {2, 5, 1, 3, 4, 1, 5, 3, 4, 2},
                                    {2, 3, 4, 2, 5, 3, 4, 1, 3, 4} };
        double[][] scatterYData = { {50, 57, 41, 54, 54, 38, 63, 48, 59, 46},
                                    {39, 42, 37, 32, 42, 45, 32, 43, 45, 35}
                                  };
        String[] scatterDataNames = {"2004", "2005"};
        ScatterPlot scatterPlot = new ScatterPlot(scatterDataNames,
                                                  "Scatter Diagram",
                                                  "Number of Commercials",
                                                  "Sales", scatterXData,
                                                  scatterYData);
        pf[7] = new PlotFrame("Scatter Plot", scatterPlot.getPlot(), 500, 270);
        double[][] residuals = { { -12, 15, -12, 18, -3, -3, -3, 9, -21, 12} };
        double[][] index = { {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} };
        String[] dataNames2 = {"Residuals"};
        scatterPlot = new ScatterPlot(dataNames2, "Residual Plot", "Index",
                                      "Residuals", index, residuals);
        pf[8] = new PlotFrame("Linear Regression: Residual Plot",
                              scatterPlot.getPlot(), 500, 270);

        String[] lineCategory = {"2001", "2002", "2003", "2004", "2005"};
        double[][] lineData = { {13, 12, 11, 8, 7}, {6, 11, 12, 11, 10},
                                {4, 5, 7, 9, 13} };
        String[] lineDataNames = {"Company A", "Company B", "Company C"};
        LinePlot linePlot = new LinePlot(lineDataNames, "Computer Purchases",
                                         "Company", "Sales", lineCategory,
                                         lineData);
        pf[9] = new PlotFrame("Line Plot", linePlot.getPlot(), 500, 270);
        double[][] sortXData = { {9, 14, 19, 24, 29, 34},
                                 {11, 13, 17, 22, 26, 28, 31} };
        double[][] sortYData = { {0, 4, 12, 17, 19, 20},
                                 {0, 2, 10, 13, 15, 16, 18} };
        String[] lineDataNames2 = {"Company A", "Company B"};
        linePlot = new LinePlot(lineDataNames2, "Ogive Plot",
                                "Audit Time in Days", "Cumulative Frequency",
                                sortXData, sortYData);
        pf[10] = new PlotFrame("Exploratory Data Analysis", linePlot.plot, 500,
                               270);
        double[][] variance = { {3.59, 1.63, 1.11, 0.70, 0.38, 0.30, 0.14, 0.11}
        };
        String[] componentList = {"Comp. 1", "Comp. 2", "Comp. 3", "Comp. 4",
                                  "Comp. 5", "Comp. 6", "Comp. 7", "Comp. 8"};
        String[] lineDataNames3 = {"Component"};
        linePlot = new LinePlot(lineDataNames3, "Principal Component Analysis",
                                "Principal Component", "Variance",
                                componentList, variance);
        pf[11] = new PlotFrame("Scree Plot", linePlot.getPlot(), 500, 270);
        double[][] lineXData = new double[2][2000];
        double[][] lineYData = new double[2][2000];
        String[] lineDataNames4 = {"Power function", "Sine Function"};
        for (int j = 0; j < 2; j++)
        {
            if (j == 0)
            {
                for (int i = 0; i < 2000; i++)
                {
                    lineXData[j][i] = -10 + 0.01 * i;
                    lineYData[j][i] = Math.pow(lineXData[j][i], 2.0);
                }
            }
            else
            {
                for (int i = 0; i < 2000; i++)
                {
                    lineXData[j][i] = -20 + 0.02 * i;
                    lineYData[j][i] = 100 * Math.sin(lineXData[j][i]);
                }
            }
        }
        linePlot = new LinePlot(lineDataNames4, "Mathematical Functions", "x",
                                "f(x)", lineXData, lineYData);
        pf[12] = new PlotFrame("Mathematical Functions", linePlot.plot,
                               500, 270);

        int[][][] time = new int[2][12][6];
        double[][] timeData = new double[2][12];
        String[] timeDataNames = {"Company A", "Company B"};
        for (int j = 0; j < 2; j++)
        {
            for (int i = 0; i < 12; i++)
            {
                time[j][i][0] = 0;
                time[j][i][1] = 0;
                time[j][i][2] = 0;
                time[j][i][3] = 1;
                time[j][i][4] = i + 1;
                time[j][i][5] = 2005;
                timeData[j][i] = 100 + Math.random() * 20.0;
            }
        }
        pf[13] = new PlotFrame("Time Series Plot",
                               new TimeSeriesPlot(timeDataNames,
                                                  "Time Series Plot", "Date",
                                                  "Stock Price",
                                                  time, timeData).
                               getPlot(), 500, 270);

        new PlotFrameFactory().putPlotFrame(pf);
    }

}
