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
 * The enumerated plot types.
 */

public enum PlotType
{

        /**
         * Pie plot.
         */

        PIE,

        /**
         * Bar plot.
         */

        BAR,

        /**
         * Box plot.
         */

        BOX,

        /**
         * Box plot for displaying the data corresponding to different dates.
         */

        BOX_DATE,

        /**
         * Histogram.
         */

        HISTOGRAM,

        /**
         * Line plot.
         */

        LINE,

        /**
         * Line plot with the categories the data belong to on the x-coordinate.
         */

        LINE_CATEGORY,

        /**
         * Scatter plot.
         */

        SCATTER,

        /**
         * Line plot with data points.
         */

        LINE_POINT,

        /**
         * Residual plot.
         */

        LINEAR_REGRESSION,

        /**
         * Survival estimate plot.
         */

        SURVIVAL,

        /**
         * Time series plot.
         */

        TIME_SERIES,

        /**
         * 3D pie plot.
         */

        PIE3D,

        /**
         * 3D bar plot.
         */

        BAR3D,

        /**
         * Combined line and bar plot.
         */

        COMBINED_LINE_BAR

}
