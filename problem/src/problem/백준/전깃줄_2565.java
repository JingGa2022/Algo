package problem.백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 전깃줄_2565 {
		static Integer[] dp;
		static int[][] wire;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new Integer[n];
		wire = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			wire[i][0] = sc.nextInt();
			wire[i][1] = sc.nextInt();
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			max = Math.max(recur(i), max);
		}
		
		System.out.println(n - max);
	}
	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(dp[n] == null) {
			dp[n] = 1;
			
			for(int i = n+1; i<dp.length; i++) {
				if(wire[n][1] < wire[i][1]) {
					dp[n] = Math.max(dp[n], recur(i) + 1);
				}
			}
		}
		return dp[n];
	}
}
