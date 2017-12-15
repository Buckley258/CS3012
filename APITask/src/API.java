import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JFrame;

/* collect information on my software engineering project in second year
 * about its downloads.
 * then display the amount of downloads each user did as a percentage of total downloads
 * in the form of a pie chart
 */

public class API {
	public static void main(String[] args) throws Exception {
		
		//Create HttpURLConnection 
		HttpURLConnection httpcon = (HttpURLConnection) new URL("https://api.github.com/repos/Seanie96/KinectMultiplayerGame/releases").openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
		
		//Read line by line
		StringBuilder responseSB = new StringBuilder();
		String line;
		while ( ( line = in.readLine() ) != null) {
			responseSB.append("\n" + line);
			//System.out.println(line);
		}
		in.close();
		
		
		//Get GitHub Downloads of KinectMultiplayerGame
		Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).map(l -> l.split(",")[0]).forEach(l -> System.out.println(l));
		
		//Sum up all download counts
		int sum = Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).mapToInt(l -> Integer.parseInt(l.split(",")[0])).sum();
		System.out.println("\nTotal Downloads: " + sum);
		
		double []dArray = Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).mapToDouble(l ->Double.parseDouble( l.split(",")[0])).toArray();
		double total = (double)sum;
		
		// create pie chart
		CreateChart pieChart = new CreateChart("Social Pie Chart", "User Percentage Of Downloads From Total Downloads", dArray, total);
		pieChart.pack();
		pieChart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pieChart.setVisible(true);
		
		
	}
	
}
