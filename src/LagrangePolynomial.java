// Name: Jayson Cheng
// CSCE440 Assignment 2

public class LagrangePolynomial {

	static double lagrange(double x, int point, int[] start) {
		double result = 1;
		for(int i = 0; i < start.length; i ++) {
			if(start[i] != point) {
				result = (result * (x - start[i])) / (point - start[i]);
			}
		}
		return result;
	}
	
	static int getIndex(int point, int[] start) {
		for(int i = 0; i < start.length; i++) {
			if(start[i] == point) {
				return i;
			}
		}
		return 0;
	}
	
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
		int[] start = new int[] {12, 15, 19, 22};
		int[] end = new int[] {27, 29, 32, 35};
		double result = polynomial(17, start, end);
		System.out.println(result);

	}
}
