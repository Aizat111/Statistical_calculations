import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.date.DateUtilities;
import org.jfree.ui.ApplicationFrame;

public class BoxPlot extends ApplicationFrame {
   
    int boyut;
    double[] kyrgyzstan;
    double[] japan;
    double[] china;
 
    public BoxPlot(String titel,double[] kyrgyzstan,double[] japan,double[] china,int boyut) { // build the constructor of the class
super(titel); // call the constructor of ApplicationFrame

   this.kyrgyzstan = kyrgyzstan;
   this.japan = japan;
   this.china = china;
   this.boyut=boyut;

final BoxAndWhiskerXYDataset dataset = createDataset();
final JFreeChart chart = createChart(dataset);
final ChartPanel spanel = new ChartPanel(chart);
spanel.setPreferredSize(new java.awt.Dimension(1200, 800));
setContentPane(spanel);

}
    
    private BoxAndWhiskerXYDataset createDataset() { // this method will generate the interval of random values to be represented as boxplots
final int ENTITY_COUNT = 3;
   
  DefaultBoxAndWhiskerXYDataset dataset = new 
  DefaultBoxAndWhiskerXYDataset("BoxPlot Graphics");
        
  for (int i = 0; i< ENTITY_COUNT; i++) {
      
     Date str = DateUtilities.createDate(2020,i+11, i+35);
      List values = new ArrayList();
      for (int j = 0; j <boyut; j++) {
        
          if(i==0)
          {
              values.add(new Double (kyrgyzstan[j]));
              values.add(new Double (kyrgyzstan[j]));
          }
          
          else if(i==1)  
          {
              values.add(japan[j]);
              values.add(new Double(japan[j]));
          }
          else  
          {
          values.add(china[j]);
          values.add(new Double(china[j]));
          }
          
      }
     dataset.add(str,
            BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values));
  }
  return dataset;
}
    
    private JFreeChart createChart(final BoxAndWhiskerXYDataset dataset) { // this method creates the chart itself
JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
"Kyrgyzstan,Japonya,Çin ülkelerinin son 4 aydaki vaka sayısının boxplot çizimi","", "Vaka sayısı", dataset, true);
chart.setBackgroundPaint(new Color(249, 231, 236));

  return chart;
    }
}
