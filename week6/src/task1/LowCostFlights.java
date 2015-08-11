package task1;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LowCostFlights {
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	static class Pair {
		int start;
		int end;
		
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return this.start + " " + this.end;
		}
	}
	public static int[][] flightsCoastMatrix;
	public static int size;
	static final int MAX_VALUE = 1000000; 
	
	static void lowestFlightPrice() {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (flightsCoastMatrix[i][j] > flightsCoastMatrix[i][k] + flightsCoastMatrix[k][j]) {
						flightsCoastMatrix[i][j] = flightsCoastMatrix[i][k] + flightsCoastMatrix[k][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		size = sc.nextInt();
		
		flightsCoastMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int path = sc.nextInt();
				flightsCoastMatrix[i][j] = path == 0 ? MAX_VALUE : path;
			}
		}
		
		int m = sc.nextInt();
		
		List<Pair> destinations = new ArrayList<LowCostFlights.Pair>();
		
		for (int i = 0; i < m; i++) {
			destinations.add(new Pair(sc.nextInt(), sc.nextInt()));
		}
		
		lowestFlightPrice();
		
		for (Pair pair : destinations) {
			int result = flightsCoastMatrix[pair.start][pair.end];
			
			out.println(result != MAX_VALUE ? result : "NO WAY");
		}
		
		out.flush();
		out.close();
	}

}
