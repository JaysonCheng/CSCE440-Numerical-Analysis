// Name: Jayson Cheng
// CSCE440 Assignment 5
// Part 2b

public class RombergIntegration {
	
	// error tolerance level
	static final float tolerance = (float) 0.00001;

	// equation for table 1
	static double func(double x) {
		return (3 * Math.pow(x, 5)) - (3 * Math.pow(x, 3)) + Math.exp(x) - Math.sin(x);
	}
	
	// Romberg Integration method
	static double[][] rombergIntegration(double a, double b, int n) {
		// declare a 2D array
		double[][] r = new double[n+1][n+1]; 
		
		// loop to output values of i and j for each iteration
		for(int i = 1; i <= n; i++) {
			r[i][0] = i;
			r[0][i] = i;
		}
		
		// calculate h
		double h = b - a;
		
		// calculate R_{1,1}
		r[1][1] = (h / 2) * (func(a) + func(b));
		
		for(int i = 2; i <= n; i++) {
			h = h / 2;
			double total = 0;
			// Approximation from Trapezoidal method
			for(int k = 1; k <= Math.pow(2, i - 1) - 1; k++) {
				double x = a + (k * h);
				total += func(x);
			}
			r[i][1] = (h / 2) * (func(a) + (2 * total) + func(b));
			
			for(int j = 2; j <= i; j++) {
				r[i][j] = r[i][j-1] + (1 / (Math.pow(4, j-1) - 1)) * (r[i][j-1] - r[i-1][j-1]);
				// stop iteration when the approximation is within 0.00001 of the actual answer
				if(r[i][j] - 2.35040 < tolerance) {
					return r;
				}
			}
		}
		return r;
	}
	
	public static void main(String args[]) {
		double [][] result = rombergIntegration(-1, 1, 4);
		System.out.println("Romberg Integration");
		System.out.println("===================");
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.printf("%.5f \t", result[i][j]);
			}
			System.out.println();
		}
	}
}
