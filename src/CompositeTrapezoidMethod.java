// Name: Jayson Cheng
// CSCE440 Assignment 4

import java.util.HashMap;

public class CompositeTrapezoidMethod {
	
	// Approximate the integral by using Composite Trapezoid Rule 
	static double compositeTrapezoid(double lowerBound, double upperBound, int n) {
		// Creating hashmap for the table of values
		HashMap<Double, Double> newMap = new HashMap<Double, Double>();
		newMap.put(-1.0, 1.209350426);
		newMap.put(-0.9, 1.605426569);
		newMap.put(-0.8, 1.719645055);
		newMap.put(-0.7, 1.665592991);
		newMap.put(-0.6, 1.528174109);
		newMap.put(-0.5, 1.367206198);
		newMap.put(-0.4, 1.221018388);
		newMap.put(-0.3, 1.110048427);
		newMap.put(-0.2, 1.040440084);
		newMap.put(-0.1, 1.007640835);
		newMap.put(0.0, 1.0);
		newMap.put(0.1, 1.002367501);
		newMap.put(0.2, 0.999693427);
		newMap.put(0.3, 0.980628601);
		newMap.put(0.4, 0.941126355);
		newMap.put(0.5, 0.888045732);
		newMap.put(0.6, 0.842756327);
		newMap.put(0.7, 0.84474502);
		newMap.put(0.8, 0.955224838);
		newMap.put(0.9, 1.260746202);
		newMap.put(1.0, 1.876810844);		
		
		// Calculate h
		double h = (upperBound - lowerBound) / n;
		double total = 0;
		for(int i = 1; i < n; i++) {
			// Round off to the nearest one decimal place
			double x = Math.round((lowerBound + (i * h)) * 10) / 10.0;
			// Get the f(x) value corresponding to the x obtained
			double fx = newMap.get(x);
			total += fx;
		}
		
		double fa = newMap.get(lowerBound);
		double fb = newMap.get(upperBound);
		double result = (h/2) * (fa + (2 * total) + fb);
		
		return result;
	}
	
	public static void main(String args[]) {
		double answer = compositeTrapezoid(-1, 1, 6);
		System.out.printf("Calculated value : %.5f \n", answer);
		System.out.println("Actual value : 2.3504");
	}
}
