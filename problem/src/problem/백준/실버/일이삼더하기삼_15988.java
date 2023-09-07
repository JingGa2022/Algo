package problem.백준.실버;

import java.util.*;

public class 일이삼더하기삼_15988 {
	// 1. dp의 놀라움 dp[i] = dp[i-1] + dp[i-2] + dp[i-3]만으로 나타낼 수 있다니!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
			long[] dp = new long[1000001];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i<=1000000; i++) {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
			}
			
			for (int t = 0; t < T; t++) {
				int n = sc.nextInt();
				System.out.println(dp[n]);
		}
	}
}
