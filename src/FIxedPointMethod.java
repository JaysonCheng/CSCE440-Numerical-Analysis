// Name: Jayson Cheng
// CSCE440 Assignment 1

public class FIxedPointMethod {

	// error tolerance level
	static final float tolerance = (float) 0.0001;

	// maximum number of iterations
	static final int maxNumOfIterations = 50;
		
	// f(x) for part a
	static double function(double x) {
		return 2 * Math.pow(x, 3) - Math.pow(x, 2) + 6 * x - Math.exp(x) + 2;
	}
	
	// g(x) for part a
	static double gfunc1(double x) {
		return (Math.exp(x) + Math.pow(x, 2) - 2 * Math.pow(x, 3) - 2) / 6;
	}
	
	// f(x) for part b
	static double function2(double x) {
		return 3 * Math.pow(x, 4) + Math.pow(x, 2) - 2;
	}
	
	// g(x) for part b
	static double gfunc2(double x) {
		return 2 / (3 * Math.pow(x, 3) + x);
	}
	
	// f(x) for part d
	static double function3(double x) {
		return 2 * x - Math.cos(x);
	}
	
	// g(x) for part d
	static double gfunc3(double x) {
		return Math.cos(x) / 2;
	}
	
	// fixed point iteration method
	static void fixedPoint(double p0) {
		int i = 1;
		double p;
		
		System.out.println("Fixed Point Iteration Method : ");
		System.out.println("Iteration \t" + "Results");
		System.out.println("======================================");
		
		while(i < maxNumOfIterations) {
			// compute pi
			p = gfunc2(p0);
			
			// print out results for each iteration
			System.out.println(i + "\t\t" + p);
			
			// condition to determine if the procedure is successful
			if(Math.abs(p - p0) < tolerance) {
				return;
			}
			
			i++;
			
			// Update p0
			p0 = p;
		}
		
		// The method failed after 50 iterations
		System.out.println("The procedure was unsuccessful.");
	}
	
	public static void main(String[] args) {
		fixedPoint(1);
	}
}
