package statgraphics.util;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

/**
 * The enumerated arguments.
 */

public enum Argument
{

        /**
         * The names of data series.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * all classes in packages regression.lm and survival, all classes
         * except PiePlot in package eda, Plot2DFactory and Plot3DFactory.
         */

        DATA_NAMES,

        /**
         * The plot title.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * all classes in packages eda, regression.lm and survival,
         * Plot2DFactory, and Plot3DFactory.
         */

        TITLE,

        /**
         * The label for the x-axis.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * all classes in packages regression.lm and survival, all classes
         * except PiePlot in package eda, Plot2DFactory, and Plot3DFactory.
         */

        XLABEL,

        /**
         * The label for the y-axis.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * all classes in packages regression.lm and survival, all classes
         * except PiePlot in package eda, Plot2DFactory, and Plot3DFactory.
         */

        YLABEL,

        /**
         * The number of bins a histogram has.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * Histogram and Plot2DFactory.
         */

        BIN_NUMBER,

        /**
         * The specification of the frequency.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * Histogram and Plot2DFactory.
         */

        FREQUENCY_CHOICE,

        /**
         * The type of the plot.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * Plot2DFactory and Plot3DFactory.
         */

        PLOT_TYPE,

        /**
         * The choice of two or three dimensional plot.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * BarPlot and PiePlot.
         */

        OPTION,

        /**
         * The choice of two or three dimensional plot.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * BarPlot and PiePlot.
         */

        PLOT_OPTION,

        /**
         * The boolean value indicating if the upper of the combined
         * plot is line plot.
         * <br>
         * The constant can be used with the following classes:
         * <br>
         * CombinedLineBarPlot.
         */

        IS_LINE_PLOT_UPPER;

    /**
     * The descriptions of the outputs.
     * @return the description.
     */

    public String description()
    {
        switch(this)
        {
            case DATA_NAMES:
                return
                "Description: names of data series;\n" +
                "Classes: all classes in packages regression.lm and " +
                "survival, all classes except PiePlot in package eda,\n" +
                "Plot2DFactory, Plot3DFactory";
            case TITLE:
                return
                "Description: the plot title;\n" +
                "Classes: all classes in packages eda, regression.lm and " +
                "survival, Plot2DFactory, Plot3DFactory";
            case XLABEL:
                return
                "Description: the label for the x-axis;\n" +
                "Classes: all classes in packages regression.lm and " +
                "survival, all classes except PiePlot in package eda,\n" +
                "Plot2DFactory, Plot3DFactory";
            case YLABEL:
                return
                "Description: the label for the y-axis;\n" +
                "Classes: all classes in packages regression.lm and " +
                "survival, all classes except PiePlot in package eda,\n" +
                "Plot2DFactory, Plot3DFactory";
            case BIN_NUMBER:
                return
                "Description: number of bins a histogram has;\n" +
                "Classes: Histogram, Plot2DFactory";
            case FREQUENCY_CHOICE:
                return
                "Description: the specification of the frequency;\n" +
                "Classes: Histogram, Plot2DFactory";
            case PLOT_TYPE:
                return
                "Description: the type of the plot;\n" +
                "Classes: Plot2DFactory, Plot3DFactory";
            case OPTION:
                return
                        "Description: two or three dimensional plot;\n" +
                        "Classes: BarPlot, PiePlot";
            case PLOT_OPTION:
                return
                "Description: two or three dimensional plot;\n" +
                "Classes: BarPlot, PiePlot";
            case IS_LINE_PLOT_UPPER:
                return
                "Description: The boolean value indicating if the upper of" +
                " the combined plot is line plot;\n" +
                "Classes: CombinedLineBarPlot";
            default:
                return "Unknown argument";
        }
    }

}
