package problem.백준.class3;

import java.util.Scanner;

public class 파도반수열_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();

			long[] dp = new long[N + 1];
			

			for(int i = 1; i<=N; i++) {
				if(i <= 3) {
					dp[i] = 1;
				}
				else if(i <= 5)
					dp[i] = 2;
			}
			
			for(int i = 6; i<=N; i++) {
				dp[i] = dp[i - 5] + dp[i -  1];
			}
			
			System.out.println(dp[N]);
		}
	}
}
