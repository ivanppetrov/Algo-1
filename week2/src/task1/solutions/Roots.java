package task1.solutions;

public class Roots {
	public static double squareRoot(int number) {
//		double precision = 0.00001;
		double result = -1d;
		double low = 0;		
		double high = number;
		double mid = low + (high - low) / 2;
		
		for (int i = 0; i < 100; i++) {
			result = mid * mid;
			if (result <= number) {
				low = mid;
			} else {
				high = mid;
			}
			
			mid = low + (high - low) / 2;
		}
		
		return mid;
	}
}
