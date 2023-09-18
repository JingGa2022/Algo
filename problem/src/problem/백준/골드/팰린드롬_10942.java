package problem.백준.골드;

import java.util.*;

public class 팰린드롬_10942 {
	/* 1. 팬린드롬의 각 길이의 경우 1개 2개 3개 이상을 구하고
	 * 2. dp에 팬린 여부를 넣어서 바로 뽑아준다
	 */
	static int n, m;
	static int[] arr;
	static boolean[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		arr = new int[n+1];
		dp = new boolean[n+1][n+1];
		for(int i = 1; i<=n; i++) arr[i] = sc.nextInt();
		
		palin(arr, n);
		m = sc.nextInt();
		for(int i = 0; i<m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			if(dp[start][end]) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
	}
	private static void palin(int[] arr, int n) {
		// TODO Auto-generated method stub
		for(int i = 1; i<=n; i++) dp[i][i] = true;
		
		for(int i = 1; i<=n-1; i++) 
			if(arr[i] == arr[i+1]) dp[i][i+1] = true;
		
		for(int i = 2; i<n; i++) {
			for(int j = 1; j<= n-i; j++) {
				if(arr[j] == arr[j+i] && dp[j+1][j+i-1])
					dp[j][j+i] = true;
			}
		}
	}
}
