package problem.백준.골드;

import java.util.*;

public class 퇴사2_15486 {
	/* 1. 각각에 대해 DFS로 끝까지 가본다
	 * 2. 만약 그 경로의 금액이 원래 금액보다 크다면 최신화한다.
	 */
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[][] arr = new int[n+2][2];
		int[] dp = new int[n+2];
		
		for(int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 1; i <= n+1; i++) {
			ans = Math.max(ans, dp[i]);
			
			int next = i + arr[i][0];
			if(next < n+2) {
				dp[next] = Math.max(dp[next], ans + arr[i][1]);
			}
		}

		System.out.println(dp[n+1]);
	}
}
