import java.lang.Math;

public class CubicSpline {
	
	static double[][] naturalCubic(int[] x, double[] f){
		int n = x.length;
		double[] h = new double[n];
		double[] alpha = new double[n];
		double[] a = new double[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = f[i];
		}
		
		for(int i = 0; i < n - 1; i++) {
			h[i] = x[i+1] - x[i];
		}
		
		for(int i = 1; i < n - 1; i++) {
			alpha[i] = ((3 / h[i]) * (a[i+1] - a[i])) - (3 / h[i - 1]) * (a[i] - a[i - 1]);
		}
		
		double[] l = new double[n];
		l[0] = 1;
		double[] micro = new double [n];
		micro[0] = 0;
		double[] z = new double[n];
		z[0] = 0;
		
		for(int i = 1; i < n - 1; i++) {
			l[i] = 2 * (x[i + 1] - x[i - 1]) - (h[i - 1] * micro[i - 1]);
			micro[i] = h[i] / l[i];
			z[i] = (alpha[i] - h[i - 1] * z[i - 1]) / l[i];
		}
		
		double[] b = new double[n];
		double[] c = new double[n];
		double[] d = new double[n];

		l[n - 1] = 1;
		z[n - 1] = 0;
		c[n - 1] = 0;
		
		int j = n - 2;
		while(j >= 0) {
			c[j] = z[j] - micro[j] * c[j + 1];
			b[j] = (a[j + 1] - a[j]) / ((h[j] - h[j] * (c[j + 1] + 2 * c[j])) / 3);
			d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
		}
		
	}
}
