// Name: Jayson Cheng
// CSCE440 Assignment 1

public class BisectionMethod {
	
	// error tolerance level
	static final float tolerance = (float) 0.0001;
	
	// maximum number of iterations
	static final int maxNumOfIterations = 50;
		
	// f(x) for part a
	static double function1(double x) {
		return 2 * Math.pow(x, 3) - Math.pow(x, 2) + 6*x - Math.exp(x) + 2;
	}
	
	// f(x) for part b
	static double function2(double x) {
		return 3 * Math.pow(x, 4) + Math.pow(x, 2) - 2;
//		return 3 * x - 3 * Math.pow(x, 2) + 2 * Math.exp(x) - 2;
	}
		
	// f(x) for part d
	static double function3(double x) {
		return 2 * x - Math.cos(x);
	}
	
	// bisection method
	static void bisection(double a, double b) {
		
		int i = 1;
		double f1 = function2(a);
		double f2;
		double midpoint;
		double c;
		
		System.out.println("Bisection Method : ");
		System.out.println("Iteration \t" + "Results");
		System.out.println("======================================");

		while(i <= maxNumOfIterations) {
			// compute pi
			midpoint = a + ((b - a) / 2);
			f2 = function2(midpoint);

			// print out results for each iteration
			System.out.println(i + "\t\t" + midpoint);
	
			c = (b - a) / 2;
			
			// condition to determine if the procedure is successful
			if(f2 == 0 || c < tolerance) {
				return;
			}
			
			i++;
			
			// compute ai, bi
			if(f1 * f2 > 0 ) {
				a = midpoint;
				f1 = f2;
			} else {
				b = midpoint;
			}
		}
		
		// The method failed after 50 iterations
		System.out.println("The procedure was unsuccessful.");
	}
	
	public static void main(String[] args) {
		bisection(-3,1);
	}
}
