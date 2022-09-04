package problem.백준;

import java.util.Scanner;

public class 쉬운계단_10844 {
	static Long[][] dp;
	static int N;
	final static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		long ans = 0;
		
		dp = new Long[N+1][10];
		
		for(int i = 0; i<= 9; i++) {
			dp[1][i] = 1L;
		}
		
		for(int i = 1; i<= 9; i++) {
			ans += stair(N, i);
		}
		
		System.out.println(ans % mod);
	}

	private static long stair(int n, int i) {
		// TODO Auto-generated method stub
		if(n == 1) {
			return dp[n][i];
		}
		
		if(dp[n][i] == null) {
			if(i == 0) {
				dp[n][i] = stair(n -1, 1);
			}else if(i == 9) {
				dp[n][i] = stair(n -1, 8);
			}else {
				dp[n][i] = stair(n-1, i -1) + stair(n-1, i+1);
			}
		}
		return dp[n][i] % mod;
	}
}
