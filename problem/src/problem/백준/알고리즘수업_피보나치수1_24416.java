package problem.백준;

import java.util.Scanner;

public class 알고리즘수업_피보나치수1_24416 {
	static long fibo, fibonacci;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new int[n+1];
		fibo = 0;
		fibonacci = 1;
		
		dp[1] = 1;
		dp[2] = 1;
		
		fibo(n);
		fibonacci(n);
		
		System.out.printf("%d %d", fibonacci, fibo);
	}
	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		if(n == 1 || n == 2) return 1;	
		else {
			fibonacci += 1;
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	private static int fibo(int n) {
		// TODO Auto-generated method stub
		for(int i = 3; i<=n; i++) {
			fibo+=1;
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
