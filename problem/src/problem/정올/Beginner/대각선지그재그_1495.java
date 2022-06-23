package problem.정올.Beginner;

import java.util.Scanner;

public class 대각선지그재그_1495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			int cnt = 0;

			if (i % 2 != 0) {
				for (int j = 0; j <= i; j++) {
					arr[i - cnt][cnt] = ++idx;1
					cnt++;
				}
			} else {
				for (int j = 0; j <= i; j++) {
					arr[cnt][i - cnt] = ++idx;
					cnt++;

				}
			}
		}
		for (int i = 1; i <= n - 1; i++) {
			int cnt = 0;
			if ((i + n -1) % 2 != 0) {
				for (int j = i; j < n; j++) {
					arr[n-1 - cnt][i+cnt] = ++idx;
					cnt++;
				}
			} else {
				for (int j = i; j < n; j++) {
					arr[i+cnt][n - 1 - cnt] = ++idx;
					cnt++;
				}

			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}// main
}
