// Name: Jayson Cheng
// CSCE440 Assignment 2

public class DividedDifferencesMethod {
	
	// Construct a recursive table by applying Newton Divided Difference Method
	static double[][] dividedDiff(double[] x, double[] f, double point){
		int n = x.length;
		double[][] q = new double[n][n];

		
		for(int i = 0; i < n; i ++) {
			q[i][0] = f[i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= i; j++) {
				q[i][j] =  (q[i][j - 1] - q[i - 1][j - 1]) / (x[i] - x[i - j]);
			}
		}
		
		return q;
	}
	
	// Calculate the value of the interpolating polynomial
	static double polynomial(double[] x, double[] f, double point) {
		double[][] q = dividedDiff(x, f, point);
		double sum = q[0][0];
		double factor = 1;
		for(int i = 1; i < x.length; i++) {
			for(int j = 1; j <= i; j++) {
				if(i == j) {
					factor = factor * (point - x[i - 1]);
					sum += (q[i][j] * factor);
				}
			}
		}
		
		return sum;
	}
		
	public static void main(String args[]) {
		System.out.println("Newton Divided Difference Method : ");
		System.out.println("=======================================================");
		
		// Station 1
		System.out.println("Station 1 : ");
		System.out.println("=======================================================");
		double[] start1 = new double[] {1, 5, 8, 12, 15, 19, 22, 26, 29};
		double[] end1 = new double[] {30, 33, 35, 27, 29, 32, 35, 37, 39};
		double[][] q1 = dividedDiff(start1, end1, 7);
		
		for(int i = 0; i < start1.length; i++) {
			for(int j = 0; j < end1.length; j++) {
				System.out.printf("%.5f \t", q1[i][j]);
			}
			System.out.println();
		}
		
		double sum1 = polynomial(start1, end1, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum1);
		
		// Station 2
		System.out.println();
		System.out.println("Station 2 : ");
		System.out.println("=======================================================");
		double[] start2 = new double[] {2, 4, 9, 11, 16, 18, 23, 25, 30};
		double[] end2 = new double[] {36, 35, 30, 28, 34, 32, 36, 37, 40};
		double[][] q2 = dividedDiff(start2, end2, 7);
		
		for(int i = 0; i < start2.length; i++) {
			for(int j = 0; j < end2.length; j++) {
				System.out.printf("%.5f \t", q2[i][j]);
			}
			System.out.println();
		}
		
		double sum2 = polynomial(start2, end2, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum2);
		
		// Station 3
		System.out.println();
		System.out.println("Station 3 : ");
		System.out.println("=======================================================");
		double[] start3 = new double[] {6, 13, 20, 27};
		double[] end3 = new double[] {42, 36, 38, 40};
		double[][] q3 = dividedDiff(start3, end3, 7);
		
		for(int i = 0; i < start3.length; i++) {
			for(int j = 0; j < end3.length; j++) {
				System.out.printf("%.5f \t", q3[i][j]);
			}
			System.out.println();
		}
		
		double sum3 = polynomial(start3, end3, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum3);
		
		// Station 4
		System.out.println();
		System.out.println("Station 4 : ");
		System.out.println("=======================================================");
		double[] start4 = new double[] {7, 14, 21, 28};
		double[] end4 = new double[] {32, 34, 36, 35};
		double[][] q4 = dividedDiff(start4, end4, 7);
		
		for(int i = 0; i < start4.length; i++) {
			for(int j = 0; j < end4.length; j++) {
				System.out.printf("%.5f \t", q4[i][j]);
			}
			System.out.println();
		}
		
		double sum4 = polynomial(start4, end4, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum4);
		
		// Station 5
		System.out.println();
		System.out.println("Station 5 : ");
		System.out.println("=======================================================");
		double[] start5 = new double[] {5, 10, 15, 20};
		double[] end5 = new double[] {28, 30, 33, 31};
		double[][] q5 = dividedDiff(start5, end5, 7);
		
		for(int i = 0; i < start5.length; i++) {
			for(int j = 0; j < end5.length; j++) {
				System.out.printf("%.5f \t", q5[i][j]);
			}
			System.out.println();
		}
		
		double sum5 = polynomial(start5, end5, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum5);
		
		// Station 6
		System.out.println();
		System.out.println("Station 6 : ");
		System.out.println("=======================================================");
		double[] start6 = new double[] {8, 15, 22, 29};
		double[] end6 = new double[] {30, 37, 42, 44};
		double[][] q6 = dividedDiff(start6, end6, 7);
		
		for(int i = 0; i < start6.length; i++) {
			for(int j = 0; j < end6.length; j++) {
				System.out.printf("%.5f \t", q6[i][j]);
			} 
			System.out.println();
		}
		
		double sum6 = polynomial(start6, end6, 7);
		System.out.print("\nP(x) = ");
		System.out.println(sum6);
		
		
		System.out.println();
		System.out.println("Problem 8 : ");
		System.out.println("=======================================================");
		double[] start7 = new double[] {-0.2, 0, 0.2};
		double[] end7 = new double[] {-0.1697, 1, 2.2518};
		double[][] q7 = dividedDiff(start7, end7, 0.1);
		
		for(int i = 0; i < start7.length; i++) {
			for(int j = 0; j < end7.length; j++) {
				System.out.printf("%.5f \t", q7[i][j]);
			} 
			System.out.println();
		}
		
		double sum7 = polynomial(start7, end7, 0.1);
		System.out.print("\nP(x) = ");
		System.out.println(sum7);
		
		System.out.println();
		System.out.println("Problem 9 : ");
		System.out.println("=======================================================");
		double[] start8 = new double[] {-0.2, 0, 0.2};
		double[] end8 = new double[] {-0.1697, 1, 2.2518};
		double[][] q8 = dividedDiff(start7, end7, 0.1);
		
		for(int i = 0; i < start8.length; i++) {
			for(int j = 0; j < end8.length; j++) {
				System.out.printf("%.5f \t", q8[i][j]);
			} 
			System.out.println();
		}
		
		double sum8 = polynomial(start8, end8, 0.1);
		System.out.print("\nP(x) = ");
		System.out.println(sum8);
		
	}
}
