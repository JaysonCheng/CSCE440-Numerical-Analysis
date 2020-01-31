
public class BisectionMethod {
	
	static final float tolerance = (float) 0.0001;
	
	static double function(double x) {
		return 2*Math.pow(x, 3) - Math.pow(x, 2) + 6*x - Math.exp(x) + 2;
	}
	
	static void bisection(double a, double b, double maxNumOfIterations) {
		int i = 1;
		double f1 = function(a);
		double f2 = function(b);
		double f3;
		double midpoint;
		double c;
		while(i <= maxNumOfIterations) {
			midpoint = a + ((b - a) / 2);
			f3 = function(midpoint);
			c = (b - a) / 2;
			if(f3 == 0 || c < tolerance) {
				System.out.println("The root is " + midpoint);
				return;
			}
			i++;
			if(f1 * f3 > 0 ) {
				a = midpoint;
				f1 = f3;
			} else {
				b = midpoint;
				f2 = f3;
			}
		}
		System.out.println("The procedure was unsuccessful.");
	}
	
	public static void main(String[] args) {
		bisection(-1,1,50);
	}
}
