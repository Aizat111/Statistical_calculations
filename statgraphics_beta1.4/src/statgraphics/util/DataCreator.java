package statgraphics.util;

/**
 * <p>Title: statgraphics</p>
 * <p>Description: The statistical graphics</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Tung Hai University </p>
 * @author Wen Hsiang Wei
 * @version 1.4
 */

import java.util.*;

import org.jfree.data.category.*;
import org.jfree.data.general.*;
import org.jfree.data.statistics.*;
import org.jfree.data.time.*;
import org.jfree.data.xy.*;

/**
 *
 * <p> This class contains a collection of utility methods for creating the
 * required datasets for generating statistical plots. </p>
 */

public class DataCreator
{

    /**
     * Default DataCreator constructor.
     */

    public DataCreator() {}

    /**
     * Creates a dataset implementing the interface CategoryDataSet
     * with one or more series, and the values associated with the categories.
     * @param dataNames names of data sets,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param category the categories the data belong to,
     * <br>            category[i]: the (i+1)'th category.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created dataset.
     * @exception IllegalArgumentException the length of the category vector
     *                                     should be equal to the one of the
     *                                     input data series.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public static CategoryDataset createDataset(String[] dataNames,
                                                String[] category,
                                                double[] ...data)
    {
        checkDimension("The length of category vector should be equal to " +
                       "the one of the input data series.", category, data);
        if (data.length != dataNames.length)
        {
            throw new IllegalArgumentException(
                    "The number of data series should be equal to " +
                    "the number of data names.");
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int j = 0; j < data.length; j++)
        {
            for (int i = 0; i < data[j].length; i++)
            {
                dataset.addValue(data[j][i], dataNames[j], category[i]);
            }
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface BoxAndWhiskerXYDataSet
     * with one or more data series.
     * @param time the dates assoicated with the data series,
     * <br>        time[j]: the date associated with data[j].
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created dataset.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to the number of input data
     *                                     series.
     */

    public static BoxAndWhiskerXYDataset createDataset(Date[] time,
                                                       double[] ...data)
    {
        if (data.length != time.length)
        {
            throw new IllegalArgumentException(
                    "The length of the time vector should be equal to " +
                    "the number of input data series.");
        }
        DefaultBoxAndWhiskerXYDataset dataset =
                new DefaultBoxAndWhiskerXYDataset("Box Plot");
        Vector<Double> datalist = new Vector<Double>();
        for (int j = 0; j < data.length; j++)
        {
            for (int i = 0; i < data[j].length; i++)
            {
                datalist.add(new Double(data[j][i]));
            }
            dataset.add(time[j], BoxAndWhiskerCalculator.
                        calculateBoxAndWhiskerStatistics(datalist));
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface
     * BoxAndWhiskerCategoryDataSet with one or more data series.
     * @param dataNames the names of data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created dataset.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public static BoxAndWhiskerCategoryDataset createDataset(String[] dataNames,
                                                             double[] ...data)
    {
        if (data.length != dataNames.length)
        {
            throw new IllegalArgumentException(
                    "The number of data series should be equal to " +
                    "the number of data names.");
        }
        DefaultBoxAndWhiskerCategoryDataset dataset =
                new DefaultBoxAndWhiskerCategoryDataset();
        List<Double> datalist;
        for (int j = 0; j < data.length; j++)
        {
            datalist = new java.util.ArrayList<Double>();
            for (int i = 0; i < data[j].length; i++)
            {
                datalist.add(new Double(data[j][i]));
            }
            dataset.add(datalist, dataNames[j], "Box Plot");
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface IntervalXYDataSet
     * with one or more data series.
     * @param dataNames the names of data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param binNumber the specified number of bins.
     * @param frequencyChoice the specification of the frequency with the
     *                        choices "Frequency" or "Relative Frequency".
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th data series.
     * @return the created dataset.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public static IntervalXYDataset createDataset(String[] dataNames,
                                                  int binNumber,
                                                  String frequencyChoice,
                                                  double[] ...data)
    {
        if (data.length != dataNames.length)
        {
            throw new IllegalArgumentException(
                    "The number of data series should be equal to " +
                    "the number of data names.");
        }
        HistogramDataset dataset = new HistogramDataset();
        if (frequencyChoice.equalsIgnoreCase("Relative Frequency"))
        {
            dataset.setType(HistogramType.RELATIVE_FREQUENCY);
        }
        else
        {
            dataset.setType(HistogramType.FREQUENCY);
        }
        for (int j = 0; j < data.length; j++)
        {
            dataset.addSeries(dataNames[j], data[j], binNumber);
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface PieDataSet.
     * @param category the categories the data belong to,
     * <br>            category[j]: the (j+1)'th category.
     * @param counts the number of data corresponding to the categories,
     * <br>          counts[j]: the number of data belonging to the category
     *                          category[j].
     * @return the created dataset.
     * @exception IllegalArgumentException the category vector and counts vector
     *                                     must have the same length.
     */

    public static PieDataset createDataset(String[] category,
                                           double[] counts)
    {
        if (category.length != counts.length)
        {
            throw new IllegalArgumentException(
                    "The category vector and counts vector must have the " +
                    "same length.");
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < category.length; i++)
        {
            dataset.setValue(category[i], counts[i]);
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface XYDataSet
     * with one or more data series.
     * @param dataNames the names of data series,
     * <br>             dataNames[j]: the name of the (j+1)'th data series.
     * @param xData the data series for the x-coordinate,
     * <br>         xData[j]: the (j+1)'th data series.
     * @param yData the data series for the y-coordinate,
     * <br>         yData[j]: the (j+1)'th data series.
     * @return the created dataset.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same sample size.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public static XYDataset createDataset(String[] dataNames,
                                          double[][] xData,
                                          double[][] yData)
    {
        checkDimension(xData, yData);
        if (xData.length != dataNames.length)
        {
            throw new IllegalArgumentException(
                    "The number of data series should be equal to " +
                    "the number of data names.");
        }
        XYSeries series;
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (int j = 0; j < xData.length; j++)
        {
            series = new XYSeries(dataNames[j]);
            for (int i = 0; i < xData[j].length; i++)
            {
                series.add(xData[j][i], yData[j][i]);
            }
            dataset.addSeries(series);
        }

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface XYDataSet with one data
     * series.
     * @param dataName the name of the data.
     * @param xData the data series for the x-coordinate.
     * @param yData the data series for the y-coordinate.
     * @return the created dataset.
     * @exception IllegalArgumentException the two input data should have the
     *                                     same sample size.
     */

    public static XYDataset createDataset(String dataName,
                                          double[] xData,
                                          double[] yData)
    {
        if (xData.length != yData.length)
        {
            throw new IllegalArgumentException(
                    "The xData vector and yData vector must have the " +
                    "same length.");
        }
        XYSeries series = new XYSeries(dataName);
        for (int i = 0; i < xData.length; i++)
        {
            series.add(xData[i], yData[i]);
        }
        XYDataset dataset = new XYSeriesCollection(series);

        return dataset;
    }

    /**
     * Creates a dataset implementing the interface XYDataSet with one or
     * more time series.
     * @param dataNames the names of time series,
     * <br>             dataNames[j]: the name of the (j+1)'th time series.
     * @param data the data series,
     * <br>        data[j]: the (j+1)'th time series.
     * @param time the dates assoicated with the collection of time series,
     * <br>        time[j][i][0]: the second (0-59) associated with the i'th
     *                            data of the j'th time series;
     * <br>        time[j][i][1]: the minute (0-59) associated with the i'th
     *                            data of the j'th time series;
     * <br>        time[j][i][2]: the hour (0-23) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][3]: the day (1-31) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][4]: the month (1-12) associated with the i'th data
     *                            of the j'th time series;
     * <br>        time[j][i][5]: the year (1900-9999) associated with the i'th
     *                            data of the j'th time series.
     * @return the created dataset.
     * @exception IllegalArgumentException the number of time series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of data series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to 6.
     * @exception IllegalArgumentException the number of data series should be
     *                                     equal to the number of data names.
     */

    public static XYDataset createDataset(String[] dataNames,
                                          int[][][] time,
                                          double[] ...data)
    {
        checkDimension(time, data);
        if (data.length != dataNames.length)
        {
            throw new IllegalArgumentException(
                    "The number of data series should be equal to" +
                    " the number of data names.");
        }
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries timeSeries;
        for (int j = 0; j < data.length; j++)
        {
            timeSeries = new TimeSeries(dataNames[j], Second.class);
            for (int i = 0; i < data[j].length; i++)
            {
                timeSeries.add(new Second(time[j][i][0], time[j][i][1],
                                          time[j][i][2], time[j][i][3],
                                          time[j][i][4], time[j][i][5]),
                               data[j][i]);
            }
            dataset.addSeries(timeSeries);
        }

        return dataset;
    }

    /**
     * Checks if the length of one-dimensioanl vector data1 is equal to the
     * number of columns of two-dimensional vector data2.
     * @param errorMessage the errorMessage to be thrown.
     * @param data1 the input one-dimensional vector.
     * @param data2 the input two-dimensional vector.
     * @exception IllegalArgumentException errorMessage.
     */

    private final static void checkDimension(String errorMessage,
                                             String[] data1,
                                             double[] ...data2)
    {
        for (int i = 0; i < data2.length; i++)
        {
            if (data1.length != data2[i].length)
            {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    /**
     * Checks if the rows of the input covariate have the same length.
     * @param data1 the first input dataset.
     * @param data2 the second input dataset.
     * @exception IllegalArgumentException the input datasets should have the
     *                                     same number of data series.
     * @exception IllegalArgumentException the data series of the two datasets
     *                                     should have the same sample size.
     */

    private final static void checkDimension(double[][] data1,
                                             double[][] data2)
    {
        if (data1.length != data2.length)
        {
            throw new IllegalArgumentException(
                    "The two data sets should have " +
                    "the same number of data series.");
        }
        for (int i = 0; i < data2.length; i++)
        {
            if (data1[i].length != data2[i].length)
            {
                throw new IllegalArgumentException(
                        "The " + (i + 1) +
                        "'th data series of the two datasets should " +
                        "have the same length.");
            }
        }
    }

    /**
     * Checks if the input time series and the input dates are consistent.
     * @param time the input dates.
     * @param data the input time series.
     * @exception IllegalArgumentException the number of time series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of data series should be
     *                                     equal to the one of the associated
     *                                     dates.
     * @exception IllegalArgumentException the length of the time vector should
     *                                     be equal to 6.
     */

    private final static void checkDimension(int[][][] time,
                                             double[] ...data)
    {
        for (int j = 0; j < data.length; j++)
        {
            if (data.length != time.length)
            {
                throw new IllegalArgumentException(
                        "The number of time series should be equal to " +
                        "the one of the associated dates.");
            }
            if (data[j].length != time[j].length)
            {
                throw new IllegalArgumentException(
                        "The length of data series should be equal to " +
                        "the one of the associated dates.");
            }
            for (int i = 0; i < data[j].length; i++)
            {
                if (time[j][i].length != 6)
                {
                    throw new IllegalArgumentException(
                            "The length of the time vector should be equal " +
                            "to 6.");
                }
            }
        }
    }

    /**
     * Converts the original data to a double array.
     * @param fromIndex the starting index.
     * @param dataObject the original data.
     * @return the double array.
     * @exception IllegalArgumentException wrong input data.
     */

    public static double[][] castToDoubleData(int fromIndex,
                                              Object ...dataObject)
    {
        double[][] doubleData = new double[dataObject.length - fromIndex][];
        for (int i = fromIndex; i < dataObject.length; i++)
        {
            if (!dataObject[i].getClass().getName().equalsIgnoreCase("[D"))
            {
                throw new IllegalArgumentException("Wrong input data type.");
            }
            else
            {
                doubleData[i - 1] = (double[]) dataObject[i];
            }
        }

        return doubleData;
    }

}
