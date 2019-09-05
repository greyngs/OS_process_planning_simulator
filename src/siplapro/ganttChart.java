package siplapro;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a Gantt chart with multiple bars per
 * task. 
 *
 */
public class ganttChart extends ApplicationFrame {
    
    procesos[] Procesos;
    int Time;
    String[] Historial = new String[200];
    
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public ganttChart(String title, String[] historial1, int Time1, procesos[] iProcesos) {
        
        super(title);
        
        Historial = historial1;
        Time = Time1;
        Procesos = iProcesos;
        
        final IntervalCategoryDataset dataset = createSampleDataset();

        // create the chart...
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Diagrama de Gantt",  // chart title
            "Procesos",              // domain axis label
            "Time",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();

        BarRenderer renderer = (BarRenderer)plot.getRenderer();
        //renderer.setSeriesPaint(0, Color.red);
        renderer.setMaximumBarWidth(0.30);
        
        DateAxis axis = (DateAxis) plot.getRangeAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("S"));
        
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1200, 720));
        setContentPane(chartPanel);

    }    
    
    private IntervalCategoryDataset createSampleDataset() {
        
        System.out.println(Procesos.length + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
        final TaskSeries[] s = new TaskSeries[Procesos.length];
        final Task[] t = new Task[Procesos.length];
        
        
        for (int i = 0; i < Procesos.length; i++) {
            s[i] = new TaskSeries(Procesos[i].Name);
            t[i] = new Task(Procesos[i].Name, new SimpleTimePeriod(Procesos[i].Tlleg,Procesos[i].Tfinal));
        }
        
        final Task[] st = new Task[Time];
        
        for (int i = 0; i < Procesos.length; i++) {
            for (int j = 0; j < Time-1; j++) {
                if (Procesos[i].Name.equals(Historial[j])) {
                    st[j] = new Task(Procesos[i].Name, new SimpleTimePeriod(j, j+1));
                    t[i].addSubtask(st[j]);
                }
            }
        }
        
        final TaskSeriesCollection collection = new TaskSeriesCollection();
        
        for (int i = 0; i < Procesos.length; i++) {
            s[i].add(t[i]);
            collection.add(s[i]);
        }
        

        return collection;
        
      /*final TaskSeries s = new TaskSeries("Proceso 1");
        final Task t = new Task("Proceso 1", new SimpleTimePeriod(0,10));
        
        final Task st = new Task("vacio",new SimpleTimePeriod(6,8));
        final Task tt = new Task("vacio",new SimpleTimePeriod(0,2));
        
        final TaskSeries ss = new TaskSeries("Proceso 2");
        final Task sss = new Task("Proceso 2", new SimpleTimePeriod(15,30));
        
        final Task ssss = new Task("vacio",new SimpleTimePeriod(15,20));
        final Task sssss = new Task("vacio",new SimpleTimePeriod(28,30));
        
        
        
        
        sss.addSubtask(ssss);
        sss.addSubtask(sssss);
        
        t.addSubtask(st);
        t.addSubtask(tt);
        
        ss.add(sss);
        s.add(t);
        
        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s);
        collection.add(ss);
       
        
        return collection;
        */
        
    }
}
