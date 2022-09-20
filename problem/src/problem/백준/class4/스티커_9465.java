package problem.백준.class4;

import java.util.Scanner;

public class 스티커_9465 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			n = sc.nextInt();
					
			arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for(int i = 0; i<2; i++) {
				for(int j =1 ; j<=n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i = 2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
		}
		System.out.println(sb);
	}
}
