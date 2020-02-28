// Name: Jayson Cheng
// CSCE440 Assignment 2

public class DividedDifferencesMethod {
	
	// Construct a recursive table by applying Newton Divided Difference Method
	static double[][] dividedDiff(int[] x, int[] f, double point){
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
	static double polynomial(int[] x, int[] f, double point) {
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
		int[] start1 = new int[] {1, 5, 8, 12, 15, 19, 22, 26, 29};
		int[] end1 = new int[] {30, 33, 35, 27, 29, 32, 35, 37, 39};
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
		int[] start2 = new int[] {2, 4, 9, 11, 16, 18, 23, 25, 30};
		int[] end2 = new int[] {36, 35, 30, 28, 34, 32, 36, 37, 40};
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
		int[] start3 = new int[] {6, 13, 20, 27};
		int[] end3 = new int[] {42, 36, 38, 40};
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
		int[] start4 = new int[] {7, 14, 21, 28};
		int[] end4 = new int[] {32, 34, 36, 35};
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
		int[] start5 = new int[] {5, 10, 15, 20};
		int[] end5 = new int[] {28, 30, 33, 31};
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
		int[] start6 = new int[] {8, 15, 22, 29};
		int[] end6 = new int[] {30, 37, 42, 44};
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
	}
}
