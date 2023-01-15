package problem.백준.실버;

import java.util.Scanner;

public class 동물원_1309 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        final int MOD = 9901;

	        int[][] dp = new int[n+1][3];


	        dp[1][0] = dp[1][1] = dp[1][2] = 1;

	        for(int i = 2; i<=n; i++){
	            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
	            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
	            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
	        }

	        long ans = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;

	        System.out.println(ans);
	}
}
