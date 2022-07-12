package problem.백준.class3;

import java.util.Scanner;

public class 피보나치함수_1003 {
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int tmp = sc.nextInt();
			dp = new int[tmp + 2][2];
			
			dp[0][0] = dp[1][1] = 1;
			dp[0][1] = dp[1][0] = 0;
			fibo(tmp);
			System.out.printf("%d %d\n", dp[tmp][0], dp[tmp][1]);
		}

	}// main

	private static void fibo(int tmp) {
		// TODO Auto-generated method stub
		for (int i = 2; i <= tmp; i++) {
			if (dp[i][0] == 0) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			}
			if (dp[i][1] == 0) {
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			} else {
				continue;
			}

		}
	}

}
