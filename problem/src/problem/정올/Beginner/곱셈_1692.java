package problem.정올.Beginner;

import java.util.Scanner;

public class 곱셈_1692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(m%100%10 *n);
		System.out.println(m%100/10 * n);
		System.out.println(m/100 * n);
		System.out.println(m * n);
	}
}
