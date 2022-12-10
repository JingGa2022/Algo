package problem.백준.class5;

import java.util.Arrays;
import java.util.Scanner;

public class RGB거리2_17404 {
	static int n, ans;
	static int[][] dp;
	static int[][] paint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		ans = 987654321;
		paint = new int[n][3];
		dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			paint[i][0] = sc.nextInt();
			paint[i][1] = sc.nextInt();
			paint[i][2] = sc.nextInt();
		}

		for (int l = 0; l < 3; l++) {

			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], 987654321);
			
			dp[0][l] = paint[0][l];

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k)
							continue;
						if(i == n-1 && k == l) continue;
						dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + paint[i][k]);
					}
				}
			}
			for(int i = 0; i<3; i++) {
				ans = Math.min(ans, dp[n-1][i]);
			}
		}
		System.out.println(ans);
	}
}
