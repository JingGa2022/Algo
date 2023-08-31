package problem.백준.골드;

import java.util.Scanner;

public class 동전_9084 {
	/* 1. 현재 동전 금액으로 만들 수 있는 수를 찾아본다 
	 * 2. 점화식은 D[N] = D[N-금액1] + D[N-금액2] + D[N-금액3].... 이 될것
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t<T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int m = sc.nextInt();
			int[] dp = new int[m+1];
			
			for(int i = 0; i<n; i++) dp[arr[i]] = 1;
			
			for(int i = 1; i<=m; i++) {
				for(int j = 0; j<n; j++) {
					if(i-arr[j] < 0) continue;
					dp[i] += dp[i-arr[j]] + dp[arr[j]];
				}
			}
			System.out.println(dp[m]);
		}
	}
}
