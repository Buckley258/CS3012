import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class CreateChart extends JFrame
{
	
	public CreateChart(String appTitle, String chartTitle, double[] downloads, double total) {
		
		PieDataset dataset = createDataset(downloads, total);
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
		setContentPane(chartPanel);
		
	}

	private PieDataset createDataset(double[] downloads, double total) {
		
		DefaultPieDataset result = new DefaultPieDataset();
		double user1Percentage = (downloads[0]/total)*100;
		double user2Percentage = (downloads[1]/total)*100;
		double user3Percentage = (downloads[2]/total)*100;
		result.setValue("User 1",user1Percentage);
		result.setValue("User 2", user2Percentage);
		result.setValue("User 3", user3Percentage);
		return result;
		
	}

	private JFreeChart createChart(PieDataset dataset, String title){
		
		JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(0);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
	
}
