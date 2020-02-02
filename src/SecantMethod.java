// Name: Jayson Cheng
// CSCE440 Assignment 1

public class SecantMethod {

	// error tolerance level
	static final float tolerance = (float) 0.0001;

	// maximum number of iterations
	static final int maxNumOfIterations = 50;
	
	// f(x) for part a
	static double function1(double x) {
		return 2 * Math.pow(x, 3) - Math.pow(x, 2) + 6 * x - Math.exp(x) + 2;
	}
	
	// f(x) for part c
	static double function2(double x) {
		return 3 * Math.pow(x, 4) + Math.pow(x, 2) - 2;
	}
	
	// f(x) for part d
	static double function3(double x) {
		return 2 * x - Math.cos(x);
	}
	
	// secant method
	static void secant(double p0, double p1) {
		int i = 2;
		double q0 = function2(p0);
		double q1 = function2(p1);
		double p ;

		System.out.println("Secant Method : ");
		System.out.println("Iteration \t" + "Results");
		System.out.println("======================================");
		
		while(i < maxNumOfIterations) {
			//compute pi
			p = p1 - (q1 * (p1 - p0) / (q1 - q0));
			
			// print out results for each iteration
			System.out.println(i + "\t\t" + p);
			
			// condition to determine if the procedure is successful
			if(Math.abs(p - p1) < tolerance) {
				return;
			}
			
			i++;
			
			// update p0, q0, p1, q1
			p0 = p1;
			q0 = q1;
			p1 = p;
			q1 = function2(p);
		}
		
		// The method failed after 50 iterations
		System.out.println("The procedure was unsuccessful.");
	}
	
	public static void main(String[] args) {
		secant(-1,1);
	}
}
