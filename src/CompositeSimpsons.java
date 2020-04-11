// Name: Jayson Cheng
// CSCE440 Assignment 5
// Part 2a

public class CompositeSimpsons {
	
	// equation for table 1
	static double func(double x) {
		return (3 * Math.pow(x, 5)) - (3 * Math.pow(x, 3)) + Math.exp(x) - Math.sin(x);
	}
	
	// Composite Simpsons Method
	static double compositeSimpsons(double a, double b, int n) {
		// Calculate h
		double h = (b - a) / n;
		double x0 = func(a) + func(b);
		double x1 = 0;
		double x2 = 0;
		
		for(int i = 1; i < n; i++) {
			// Round off to the nearest one decimal place
			double x = a + (i *h);
			if(i % 2 == 0) {
				x1 += func(x);
			} else {
				x2 += func(x);
			}
		}
		double result = (h / 3) * (x0 + (2 * x1) + (4 * x2));
		
		return result;
	}
	
	public static void main(String args[]) {
		double answer = compositeSimpsons(-1, 1, 6);
		System.out.printf("Calculated value : %.5f \n", answer);
		System.out.printf("Actual value : %.5f", Math.exp(1) - (1 / Math.exp(1)));
	}
}
