package problem.백준.실버;

import java.util.Scanner;

public class 다리놓기_1010 {
	static int dp[][] = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			
			System.out.println(combi(m,n));
		}
		
	}

	private static int combi(int n, int r) {
		if(dp[n][r] > 0) 
			return dp[n][r];
		if(n == r || r == 0)
			return dp[n][r] = 1;
		
		return dp[n][r] = combi(n-1,r-1) + combi(n-1,r);
	}
}
