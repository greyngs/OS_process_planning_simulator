package siplapro;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
public class GanttDemo2 extends ApplicationFrame {
    
    List<Integer> historial = new ArrayList<Integer>();
    
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public GanttDemo2(final String title) {
        
        super(title);
        
        for (int i = 0; i < 20; i++) {
            
           // historial[i]=1;
        }
        
        final IntervalCategoryDataset dataset = createSampleDataset();

        // create the chart...
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt Chart",  // chart title
            "Procesos",              // domain axis label
            "Time",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();

        BarRenderer renderer = (BarRenderer)plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setMaximumBarWidth(0.10);
        
        DateAxis axis = (DateAxis) plot.getRangeAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("S"));
        
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1200, 720));
        setContentPane(chartPanel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a sample dataset for a Gantt chart, using sub-tasks.  In general, you won't 
     * hard-code the dataset in this way - it's done here so that the demo is self-contained.
     *
     * @return The dataset.
     */
    private IntervalCategoryDataset createSampleDataset() {

        final TaskSeries s1 = new TaskSeries("Proceso 1");
        //final TaskSeries s2 = new TaskSeries("Proceso 2");
        
        final Task t1 =new Task("Proceso1",  new SimpleTimePeriod(50, 100));
        final Task t2 =new Task("Proceso1",  new SimpleTimePeriod(25, 30));
        s1.add(t1);
        
        

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
       // collection.add(s2);

        return collection;
    }


    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final GanttDemo2 demo = new GanttDemo2("Gantt Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
