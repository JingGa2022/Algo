package problem.백준;

import java.util.Scanner;

public class 최소공배수_1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int d = gcd(a,b);
			
			System.out.println(a * b / d);
		}
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		while(b!=0) {
			int r = a % b;
			
			a = b;
			b = r;
		}
		return a;
	}
}
