package problem.백준.실버;

import java.util.Arrays;
import java.util.Scanner;

public class 퇴사_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n+1][2];
		int[] dp = new int[n+1];
		
		for(int i = 0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i<n; i++) {	
				if(i + arr[i][0] <= n) {
						dp[i+arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
				
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[n]);
	}
}
