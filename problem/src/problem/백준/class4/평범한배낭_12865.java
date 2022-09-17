package problem.백준.class4;

import java.util.Scanner;

public class 평범한배낭_12865 {
	static int n,k;
	static int[][] dp;
//	static int[] dp;
	static int[][] items;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		items = new int[n+1][n+1];
		dp = new int[k+1][k+1];
//		dp = new int[k+1];
		
		for(int i = 1; i<=n; i++) {
			items[i][0] = sc.nextInt();//무게
			items[i][1] = sc.nextInt();//가치
		}
		
//		for(int i = 1; i<=n; i++) {
//			for(int j = k; j - items[i][0] >= 0; j--) {
//				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
//			}
//		}
//		System.out.println(dp[k]);
		
		System.out.println(knapsack(n-1,k));
	}
	private static int knapsack(int i, int k2) {
		// TODO Auto-generated method stub
		if(i < 0)
			return 0;
		
		if(dp[i][k2] == 0) {
			if(items[i][0] > k2) {
				dp[i][k2] = knapsack(i-1, k2);
			}
			else {
				dp[i][k2] = Math.max(knapsack(i-1, k2), knapsack(i-1, k2 - items[i][0]) + items[i][1]);
			}
		}
		return dp[i][k2];
	}
}
