// Name: Jayson Cheng
// CSCE440 Assignment 2

public class HermiteMethod {
	static double[][] hermite(double[] x, double[] f, double[] fp){
		int n = x.length;
		double[] z = new double[2 * n];
		double[][] q = new double[2 * n][2 * n];
		
		for(int i = 0; i < n; i++) {
			z[2 * i] = x[i];
			z[(2 * i) + 1] = x[i];
			q[2 * i][0] = f[i];
			q[(2 * i) + 1][0] = f[i];
			q[(2 * i) + 1][1] = fp[i];
			
			if(i != 0) {
				q[2 * i][1] = (q[2 * i][0] - q[(2 * i) - 1][0]) / (z[2 * i] - z[(2 * i) - 1]);
			}
		}
		
		for(int i = 2; i < (2 * n); i++){
			for(int j = 2; j <= i; j++) {
				q[i][j] = (q[i][j - 1] - q[i - 1][j - 1]) / (z[i] - z[i - j]);
			}
		}
		
		return q;
	}
	
	static double polynomial(double[] x, double[] f, double[] fp, double point) {
		double[][] q = hermite(x, f, fp);
		int n = x.length;
		double[] z = new double[2 * n];
		for(int i = 0; i < n; i++) {
			z[2 * i] = x[i];
			z[(2 * i) + 1] = x[i];
		}
		
		double sum = q[0][0];
		double factor = 1;
		for(int i = 1; i < 2 * n; i++) {
			for(int j = 1; j <= i; j++) {
				if(i == j) {
					factor = factor * (point - z[i - 1]);
					sum += (q[i][j] * factor);
				}
			}
		}
		
		return sum;
	}
	
	public static void main(String args[]) {
		double[] x = {-0.2, 0, 0.2};
		double[] f = {-0.1697, 1, 2.2518};
		double[] fp = {5.7406, 6, 6.5836};
		double[][] q = hermite(x, f, fp);
		
		int n = 2 * x.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%.5f \t", q[i][j]);
			}
			System.out.println();
		}
		
		double sum = polynomial(x, f, fp, 0.1);
		System.out.print("\nP(x) = ");
		System.out.println(sum);
	}
}
