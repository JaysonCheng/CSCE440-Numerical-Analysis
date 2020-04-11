// Name: Jayson Cheng
// CSCE440 Assignment 2

public class LagrangePolynomial {
	
	// Calculate the lagrange polynomial for each k=0,1,....,n
	static double lagrange(double x, int point, int[] start) {
		double result = 1;
		for(int i = 0; i < start.length; i ++) {
			if(start[i] != point) {
				result = (result * (x - start[i])) / (point - start[i]);
			}
		}
		return result;
	}
	
	// Calculate the value of the interpolating polynomial
	static double polynomial(double x, int[] start, int[] end) {
		double sum = 0;
		double result = 0;
		for(int i = 0; i < start.length; i++) {
			result = lagrange(x, start[i], start);
			sum += result * end[i]; 
		}
		return sum;
	}
	
	public static void main(String args[]) {
		System.out.println("Lagrange Polynomial Method : ");
		System.out.println("=========================================================================");
		//station 1
		int[] start1 = new int[] {1, 5, 8, 12, 15, 19, 22, 26, 29};
		int[] end1 = new int[] {30, 33, 35, 27, 29, 32, 35, 37, 39};
		double result1 = polynomial(17, start1, end1);
		System.out.print("PM 2.5 for weather station 1: ");
		System.out.println(result1);
		
		//station 2
		int[] start2 = new int[] {2, 4, 9, 11, 16, 18, 23, 25, 30};
		int[] end2 = new int[] {36, 35, 30, 28, 34, 32, 36, 37, 40};
		double result2 = polynomial(17, start2, end2);
		System.out.print("PM 2.5 for weather station 2: ");
		System.out.println(result2);
		
		//station 3
		int[] start3 = new int[] {6, 13, 20, 27};
		int[] end3 = new int[] {42, 36, 38, 40};
		double result3 = polynomial(17, start3, end3);
		System.out.print("PM 2.5 for weather station 3: ");
		System.out.println(result3);
		
		//station 4
		int[] start4 = new int[] {7, 14, 21, 28};
		int[] end4 = new int[] {32, 34, 36, 35};
		double result4 = polynomial(17, start4, end4);
		System.out.print("PM 2.5 for weather station 4: ");
		System.out.println(result4);
		
		//station 5
		int[] start5 = new int[] {5, 10, 15, 20};
		int[] end5 = new int[] {28, 30, 33, 31};
		double result5 = polynomial(17, start5, end5);
		System.out.print("PM 2.5 for weather station 5: ");
		System.out.println(result5);
		
		//station 6
		int[] start6 = new int[] {8, 15, 22, 29};
		int[] end6 = new int[] {30, 37, 42, 44};
		double result6 = polynomial(17, start6, end6);
		System.out.print("PM 2.5 for weather station 6: ");
		System.out.println(result6);
	}
}
