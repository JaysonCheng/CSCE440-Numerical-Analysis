// Name: Jayson Cheng
// CSCE440 Assignment 2

public class NevillesMethod {
	
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
		
		int[] x = new int[] {1, 5 ,8, 12, 15};
		int[] f = new int[] {30, 33 , 35, 27, 29};
		double[][] q = Neville(x, f, 10);
		
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < f.length; j++) {
				System.out.printf("%.5f \t", q[i][j]);
			}
			System.out.println();
		}

	}
}
