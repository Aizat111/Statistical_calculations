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

import org.jfree.chart.*;

/**
 *
 * <p>The base class for graphical analysis. A number of classes for generating
 * a variety of plots can inherit from this class. </p>
 */

public abstract class GraphicalAnalysis
{

    /**
     * The arguments in graphical analysis.
     */

    public Hashtable argument = new Hashtable();

    /**
     * The input data in graphical analysis.
     */

    public Object[] dataObject;

    /**
     * The generated plot.
     */

    public Hashtable output = new Hashtable();

    /**
     * The plot.
     */

    public JFreeChart plot;

    /**
     * The key for obtaining the generated plot.
     */

    public static final String PLOT = "PLOT";

    /**
     * Gets the arguments.
     * @return the argument.
     */

    public Hashtable getArgument()
    {
        return this.argument;
    }

    /**
     * Returns the created plot.
     * @return the plot.
     */

    public JFreeChart getPlot()
    {
        return this.plot;
    }

}
