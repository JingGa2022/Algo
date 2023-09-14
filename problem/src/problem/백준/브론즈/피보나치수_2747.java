package problem.백준.브론즈;

import java.util.Scanner;

public class 피보나치수_2747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] pibo = new long[50];
		
		int n = sc.nextInt();
		pibo[1] = 1;
		
		for(int i = 2 ; i<=45; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
		}
		
		System.out.println(pibo[n]);
	}
}
