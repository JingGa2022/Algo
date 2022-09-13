package problem.백준.class4;

import java.util.Scanner;

public class 곱셈_1629 {
	static long C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		C = sc.nextLong();
		
		long ans = pow(A, B);
		
		System.out.println(ans);
	}
	private static long pow(long a, long b) {
		// TODO Auto-generated method stub
		if(b == 1) return a % C;
		
		long tmp = pow(a, b/2);
		
		if(b % 2 != 0) {
			return (tmp * tmp % C) * a % C;
		}
		
		return tmp * tmp % C;
	}
}
