// Name: Jayson Cheng
// CSCE440 Assignment 1

public class NewtonsMethod {

	// error tolerance level
	static final float tolerance = (float) 0.0001;

	// maximum number of iterations
	static final int maxNumOfIterations = 50;
	
	// f(x) for part a
	static double function1(double x) {
		return 2 * Math.pow(x, 3) - Math.pow(x, 2) + 6 * x - Math.exp(x) + 2;
	}
	
	// derivative for part a
	static double derivative1(double x) {
		return 6 * Math.pow(x, 2) - 2 * x + 6 - Math.exp(x);
	}
	
	// f(x) for part b
	static double function2(double x) {
		return 3 * Math.pow(x, 4) + Math.pow(x, 2) - 2;
	}
	
	// derivative for part b
	static double derivative2(double x) {
		return 12 * Math.pow(x, 3) + 2 * x;
	}
	
	// f(x) for part d
	static double function3(double x) {
		return 2 * x - Math.cos(x);
	}

	// derivative for part d
	static double derivative3(double x) {
		return 2 + Math.sin(x);
	}
	
	// newton method
	static void newton(double p0) {
		int i  = 1;
		double c;
		double p;
		
		System.out.println("Newtons Method : ");
		System.out.println("Iteration \t" + "Results");
		System.out.println("======================================");
		
		while(i < maxNumOfIterations) {
			// compute pi
			c = function2(p0) / derivative2(p0);
			p = p0 - c;

			// print out results for each iteration
			System.out.println(i + "\t\t" + p);
			
			// condition to determine if the procedure is successful
			if(Math.abs(p - p0) < tolerance) {
				return;
			}
			
			i++;
			
			// update p0
			p0 = p;
		}
		
		// The method failed after 50 iterations
		System.out.println("The procedure was unsuccessful.");
	}

	public static void main(String[] args) {
		newton(1);
	}
}
