package problem.백준.class4;

import java.util.Scanner;

public class 가장긴증가하는부분수열_11053 {
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N];
		dp = new Integer[N];
		int ans = 1;
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		/**
		for(int i = 0; i<N; i++) {
			LTS(i);
		}
		**/
		
		for(int i = 0; i<N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			ans = dp[i] > ans ? dp[i] : ans;
		}
		
		System.out.println(ans);
		
	}//main
	
	public static int LTS (int num) {
		if(dp[num] == null) {
			dp[num] = 1;
			
		for(int i = num - 1 ; i >= 0; i--) {
			if(arr[i] < arr[num]) {
				dp[num] = Math.max(LTS(i) + 1, dp[num]);
			}
		}
		}
		return dp[num];
	}
}
