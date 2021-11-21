package statgraphics;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

import java.io.*;
import java.util.*;

/**
 *
 * <p> This abstract class contains a method for obtaining the object which
 * creates 2D or 3D statistical plots.</p>
 */

public abstract class PlotFactory extends GraphicalAnalysis
{

    /**
     * Default PlotFactory constructor.
     */

    public PlotFactory() {}


    /**
     * Returns the plot facotory.
     * @param plotFactoryName the name of the plot factory with the choices
     *                        "Plot2DFactory" or "Plot3DFactory".
     * @return the plot factory.
     */

    public static PlotFactory getPlotFactory(String plotFactoryName)
    {
        PlotFactory plotFactory = null;
        try
        {
            plotFactory = (PlotFactory) Class.forName(plotFactoryName).
                          newInstance();
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("can not find the class " +
                               plotFactoryName + ".");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return plotFactory;
    }

    /**
     * Returns the plot.
     * @param plotFactoryName the name of the plot factory with the choices
     *                        "Plot2DFactory" or "Plot3DFactory".
     * @param argument the input arguments.
     * @param dataObject the input data.
     * @return the plot factory.
     */

    public static Object getPlot(String plotFactoryName,
                                 Hashtable argument,
                                 Object ...dataObject)
    {
        return getPlotFactory(plotFactoryName).createPlot(argument, dataObject);
    }

    /**
     * Serializes the plot and saves in the specified file.
     * @param fileName the file name.
     * @param argument the input arguments.
     * @param dataObject the input data.
     */

    public void plotSerialized(String fileName,
                               Hashtable argument,
                               Object ...dataObject)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(new File(
                    new File(System.getProperty("user.dir") +
                             System.getProperty("file.separator")), fileName));
            ObjectOutputStream outfile = new ObjectOutputStream(file);
            outfile.writeObject(createPlot(argument, dataObject));
            outfile.flush();
            outfile.close();
        }
        catch (java.io.IOException IOE)
        {
            System.out.println("IOException");
        }
    }

    /**
     * Deserializes a plot object and saves in the specified file.
     * @param fileName the file name.
     * @return the deserialized plot object.
     */

    public Object plotDeserialized(String fileName)
    {
        Object inputObject = null;
        try
        {
            FileInputStream file = new FileInputStream(new File(
                    new File(System.getProperty("user.dir") +
                             System.getProperty("file.separator")), fileName));
            ObjectInputStream input = new ObjectInputStream(file);
            inputObject = input.readObject();
            input.close();
        }
        catch (java.io.IOException IOE)
        {
            System.out.println("IOException");
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("IOException");
        }

        return inputObject;
    }

    /**
     * Creates the plot.
     * @param argument the input arguments.
     * @param dataObject the input data.
     * @return the plot.
     */

    public abstract Object createPlot(Hashtable argument,
                                      Object ...dataObject);

}
