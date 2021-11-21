import java.util.*;

import org.jfree.chart.*;

import statgraphics.*;
import statgraphics.regression.lm.*;
import static statgraphics.util.Argument.*;
import statgraphics.util.*;

/**
 *
 * <p>Example: class LinearRegressionPlot.</p>
 */

public class LinearRegressionPlotExample
{

    public static void main(String[] args)
    {
        double[] ydata = {58, 105, 88, 118, 117, 137, 157, 169, 149, 202};
        double[] xdata = {2, 6, 8, 8, 12, 16, 20, 20, 22, 26};
        double[] p1 = {0, 60};
        double[] p2 = {30, 210};
        String title = "Y = 60 + 5X ";
        String xLabel = "Student Population";
        String yLabel = "Quarterly Sales";
        PlotFrame[] pf = new PlotFrame[4];
        pf[0] = new PlotFrame("Regression Plot I",
                              new LinearRegressionPlot(title, xLabel, yLabel,
                p1, p2, xdata, ydata).plot, 500, 270);
        pf[1] = new PlotFrame("Regression Plot II", new LinearRegressionPlot(
                "Pizza Data", xLabel, yLabel,
                p1, p2, xdata, ydata).getPlot(), 500, 270);

        Hashtable argument = new Hashtable();
        GraphicalAnalysis graphicalAnalysis = new LinearRegressionPlot(argument,
                p1, p2, xdata, ydata).graphicalAnalysis;
        JFreeChart myPlot = (JFreeChart) graphicalAnalysis.output.get("PLOT");
        pf[2] = new PlotFrame("Regression Plot III", myPlot, 500, 270);

        argument.put(TITLE, "Y = 60 + 5X ");
        argument.put(XLABEL, "Student Population");
        argument.put(YLABEL, "Quarterly Sales");
        argument.put(DATA_NAMES, "Pizza Data");
        pf[3] = new PlotFrame("Line Plot IV", new LinearRegressionPlot(
                argument, p1, p2, xdata, ydata).graphicalAnalysis.plot,
                              500, 270);

        new PlotFrameFactory().putPlotFrame(pf);
    }

}
