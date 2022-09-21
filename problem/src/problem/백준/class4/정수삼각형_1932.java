package problem.백준.class4;

import java.util.Scanner;

public class 정수삼각형_1932 {
	static int n;
	static Integer[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new Integer[n+1][n+1];
		int[][] dp = new int[n+2][n+2];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[1][1] = arr[1][1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
			}
		}
		int ans = 0;
		for(int i = 1; i<=n; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}
}
