import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

// collect information on my software engineering project in second year
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
		int i =0;
		//int[] dArray = new int[5];
		
		//Get GitHub Downloads of KinectMultiplayerGame
		Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).map(l -> l.split(",")[0]).forEach(l -> System.out.println(l));
		
		//Sum up all download counts
		int total = Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).mapToInt(l -> Integer.parseInt(l.split(",")[0])).sum();
		System.out.println("\nTotal Downloads: " + total);
		
		int []dArray = Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).mapToInt(l ->Integer.parseInt( l.split(",")[0])).toArray();
		
		for(i=0; i<=dArray.length; i++) {
			
			System.out.println(dArray[i] + " test" + '\n');
			
		}
		
		
		
	}
	
}
