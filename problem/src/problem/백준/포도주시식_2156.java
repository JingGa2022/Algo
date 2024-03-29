package problem.백준;

import java.util.Scanner;

public class 포도주시식_2156 {
	static int n, ans;
	static int[] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n+1];
		ans = 0;
		int[] dp = new int[n+1];
		
		for(int i = 1; i<=n; i++) arr[i] = sc.nextInt();
		
		dp[1] = arr[1];
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-1], 
					Math.max(dp[i-2] + arr[i], dp[i-3]+ arr[i-1] + arr[i]));
		}
		System.out.println(dp[n]);
	}
}
