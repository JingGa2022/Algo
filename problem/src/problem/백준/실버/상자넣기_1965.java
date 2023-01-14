package problem.백준.실버;

import java.util.Arrays;
import java.util.Scanner;

public class 상자넣기_1965 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int dp[] = new int[n]; 
		
		for(int i =0 ; i<n; i++) arr[i] = sc.nextInt();
		Arrays.fill(dp, 1);
		int ans = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(dp[i], ans);
		}
		
		System.out.println(ans);
	}
}
