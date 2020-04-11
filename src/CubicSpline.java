// Name: Jayson Cheng
// CSCE440 Assignment 2

public class CubicSpline {
	
	// Natural cubic spline method
	static double[][] naturalCubic(int[] x, double[] f){
		int size = x.length;
		// Keep track of the index
		int n = x.length - 1;
		
		double[] h = new double[size];
		double[] alpha = new double[size];
		double[] a = new double[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = f[i];
		}
		
		for(int i = 0; i < n; i++) {
			h[i] = x[i+1] - x[i];
		}
		
		for(int i = 1; i < n; i++) {
			alpha[i] = ((3 / h[i]) * (a[i+1] - a[i])) - (3 / h[i - 1]) * (a[i] - a[i - 1]);
		}
		
		
		double[] l = new double[size];
		double[] micro = new double [size];
		double[] z = new double[size];
		l[0] = 1;
		micro[0] = 0;
		z[0] = 0;
		
		for(int i = 1; i < n; i++) {
			l[i] = 2 * (x[i + 1] - x[i - 1]) - (h[i - 1] * micro[i - 1]);
			micro[i] = h[i] / l[i];
			z[i] = (alpha[i] - (h[i - 1] * z[i - 1])) / l[i];
		}

		
		double[] b = new double[size];
		double[] c = new double[size];
		double[] d = new double[size];

		l[n] = 1;
		z[n] = 0;
		c[n] = 0;
		
		int j = n - 1;
		while(j >= 0) {
			c[j] = z[j] - (micro[j] * c[j + 1]);
			b[j] = ((a[j + 1] - a[j]) / h[j]) - ( (h[j] * (c[j + 1] + 2 * c[j])) / 3);
			d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
			j--;
		}
		
		double[][] result = new double[n][n];
		
		for(int i = 0; i < n; i++) {
			result[i][0] = a[i];
			result[i][1] = b[i];
			result[i][2] = c[i];
			result[i][3] = d[i];
		}
		
		return result;
	}
	
	// Clamped cubic spline method
	static double[][] clampedCubic(int[] x, double[] f, double[] fp){
		int size = x.length;
		int n = x.length - 1;
		
		double[] h = new double[size];
		double[] alpha = new double[size];
		double[] a = new double[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = f[i];
		}
		
		for(int i = 0; i < n; i++) {
			h[i] = x[i+1] - x[i];
		}
		
		double fpo = fp[0];
		double fpn = fp[n];
		
		alpha[0] = ((3 * (a[1] - a[0])) / h[0]) - (3 * fpo);
		alpha[n] = (3 * fpn) - ((3 * (a[n] - a[n - 1]))) / h[n - 1]; 
		
		for(int i = 1; i < n; i++) {
			alpha[i] = ((3 / h[i]) * (a[i+1] - a[i])) - (3 / h[i - 1]) * (a[i] - a[i - 1]);
		}
		
		double[] l = new double[size];
		double[] micro = new double [size];
		double[] z = new double[size];
		l[0] = 2 * h[0];
		micro[0] = 0.5;
		z[0] = alpha[0] / l[0];
		
		double[] b = new double[size];
		double[] c = new double[size];
		double[] d = new double[size];
		
		for(int i = 1; i < n; i++) {
			l[i] = (2 * (x[i + 1] - x[i - 1])) - (h[i - 1] * micro[i - 1]);
			micro[i] = h[i] / l[i];
			z[i] = (alpha[i] - (h[i - 1] * z[i - 1])) / l[i];
		}
		
		l[n] = h[n - 1] * (2 - micro[n - 1]);
		z[n] = (alpha[n] - (h[n - 1] * z[n - 1])) / l[n];
		c[n] = z[n];
		
		int j = n - 1;
		while(j >= 0) {
			c[j] = z[j] - (micro[j] * c[j + 1]);
			b[j] = ((a[j + 1] - a[j]) / h[j]) - ((h[j] * (c[j + 1] + 2 * c[j])) / 3);
			d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
			j--;
		}
		
		double[][] result = new double[n][n];
		
		for(int i = 0; i < n; i++) {
			result[i][0] = a[i];
			result[i][1] = b[i];
			result[i][2] = c[i];
			result[i][3] = d[i];
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		int[] x = {-2, -1, 0, 1, 2};
		double[] f = {3.230639, -0.730600, -0.633970, 0.586080, 12.03208};
		double[] fp = {-9.97685, -0.440230,  0.144338,  3.812855,  22.60286};
		double[][] result = naturalCubic(x,f);
		
		System.out.println("\nNatural Cubic Spline Method : ");
		System.out.println("==========================================================");
		System.out.println("Constant \t x \t\t x^2 \t\t x^3");
		System.out.println("==========================================================");
		
		for(int i = 0; i < x.length - 1; i++) {
			for(int j = 0; j < f.length - 1; j++) {
				System.out.printf("%.5f \t", result[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\nClamped Cubic Spline Method : ");
		System.out.println("==========================================================");
		System.out.println("Constant \t x \t\t x^2 \t\t x^3");
		System.out.println("==========================================================");
		
		double[][] result1 = clampedCubic(x, f , fp);
		for(int i = 0; i < x.length - 1; i++) {
			for(int j = 0; j < f.length - 1; j++) {
				System.out.printf("%.5f \t", result1[i][j]);
			}
			System.out.println();
		}
	}
}
