package galiciareader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GaliciaLineChart extends ApplicationFrame {

    private List<Date> time;
    private List<Double> saldo;

    public GaliciaLineChart(String applicationTitle, String chartTitle, List<Date> t, List<Double> s) {

        super(applicationTitle);
        time = t;
        saldo = s;
        JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                chartTitle,
                "Fecha", "Saldo",
                createDataset(),true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        TimeSeries serie1 = new TimeSeries("Caja de Ahorro En Pesos");
        String s;
        int k = 0;
        for (Double d : saldo) {
            System.out.println("k="+k+";time="+time.get(k));
            serie1.addOrUpdate(new Day(time.get(k)), d);
            k++;
        }
        dataset.addSeries(serie1);
        return dataset;
    }
}
