package problem.백준.실버;

import java.util.Scanner;

public class 점프_1890 {
	/*
	 * 1. dp와 게임판 행렬 따로 관리 
	 * 2. 이전 경로의 갯수를 다음경로에 더해주면서 완성시키면 된다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int x, y = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				x = i + arr[i][j];
				y = j + arr[i][j];

				if (dp[i][j] >= 1 && arr[i][j] != 0) {

					if (x <= n - 1) {
						dp[x][j] += dp[i][j];
					}
					if (y <= n - 1) {
						dp[i][y] += dp[i][j];
					}
				}
			}
		}

		System.out.println(dp[n - 1][n - 1]);
	}
}
