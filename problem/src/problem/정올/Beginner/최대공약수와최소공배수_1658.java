package problem.정올.Beginner;

import java.util.Scanner;

public class 최대공약수와최소공배수_1658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int gcd = 0;
		
		for(int i = 1; i<= Math.max(n, m); i++) {
			if(n % i ==0 && m % i==0) {
				gcd = i;
			}
		}
		System.out.println(gcd);
		System.out.println((n*m)/gcd);
		
	}//main
}
