// Name: Jayson Cheng
// CSCE440 Assignment 2

public class NevillesMethod {
	
	// Construct a recursive table by applying Nevilles Method
	static double[][] Neville(int[] x, int[] f, double point){
		int n = x.length;
		double[][] q = new double[n][n];

		
		for(int i = 0; i < n; i ++) {
			q[i][0] = f[i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= i; j++) {
				q[i][j] =  (((point - x[i - j]) * q[i][j - 1]) - ((point - x[i]) * q[i - 1][j - 1])) / (x[i] - x[i - j]);
				
			}
		}
		
		return q;
	} 
	
	public static void main(String args[]) {
		System.out.println("Nevilles Method : ");
		System.out.println("=========================================================================");
		
		// Station 1
		System.out.println("Station 1 : ");
		System.out.println("=========================================================================");
		
		int[] start1 = new int[] {1, 5, 8, 12, 15, 19, 22, 26, 29};
		int[] end1 = new int[] {30, 33, 35, 27, 29, 32, 35, 37, 39};
		double[][] result1 = Neville(start1, end1, 11);
		
		for(int i = 0; i < start1.length; i++) {
			for(int j = 0; j < end1.length; j++) {
				System.out.printf("%.5f \t", result1[i][j]);
			}
			System.out.println();
		}
		
		// Station 2
		System.out.println();
		System.out.println("Station 2 : ");
		System.out.println("=========================================================================");
		
		int[] start2 = new int[] {2, 4, 9, 11, 16, 18, 23, 25, 30};
		int[] end2 = new int[] {36, 35, 30, 28, 34, 32, 36, 37, 40};
		double[][] result2 = Neville(start2, end2, 11);
		
		for(int i = 0; i < start2.length; i++) {
			for(int j = 0; j < end2.length; j++) {
				System.out.printf("%.5f \t", result2[i][j]);
			}
			System.out.println();
		}
		
		// Station 3
		System.out.println();
		System.out.println("Station 3 : ");
		System.out.println("=========================================================================");
		
		int[] start3 = new int[] {6, 13, 20, 27};
		int[] end3 = new int[] {42, 36, 38, 40};
		double[][] result3 = Neville(start3, end3, 11);
		
		for(int i = 0; i < start3.length; i++) {
			for(int j = 0; j < end3.length; j++) {
				System.out.printf("%.5f \t", result3[i][j]);
			}
			System.out.println();
		}
		
		// Station 4
		System.out.println();
		System.out.println("Station 4 : ");
		System.out.println("=========================================================================");
		
		int[] start4 = new int[] {7, 14, 21, 28};
		int[] end4 = new int[] {32, 34, 36, 35};
		double[][] result4 = Neville(start4, end4, 11);
		
		for(int i = 0; i < start4.length; i++) {
			for(int j = 0; j < end4.length; j++) {
				System.out.printf("%.5f \t", result4[i][j]);
			}
			System.out.println();
		}
		
		// Station 5
		System.out.println();
		System.out.println("Station 5 : ");
		System.out.println("=========================================================================");
		
		int[] start5 = new int[] {5, 10, 15, 20};
		int[] end5 = new int[] {28, 30, 33, 31};
		double[][] result5 = Neville(start5, end5, 11);
		
		for(int i = 0; i < start5.length; i++) {
			for(int j = 0; j < end5.length; j++) {
				System.out.printf("%.5f \t", result5[i][j]);
			}
			System.out.println();
		}
		
		// Station 6
		System.out.println();
		System.out.println("Station 6 : ");
		System.out.println("=========================================================================");
		
		int[] start6 = new int[] {8, 15, 22, 29};
		int[] end6 = new int[] {30, 37, 42, 44};
		double[][] result6 = Neville(start6, end6, 11);
		
		for(int i = 0; i < start6.length; i++) {
			for(int j = 0; j < end6.length; j++) {
				System.out.printf("%.5f \t", result6[i][j]);
			}
			System.out.println();
		}
	}
}
