package problem.swea;

import java.util.Arrays;
import java.util.Scanner;

public class 동철이의일분배_1865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			boolean[] check = new boolean[N];
			boolean[] checkR = new boolean[N];
			float[][] arr = new float[N][N];
			int a = 0;
			int b = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextFloat();
				
				}
			}
			check[a] = true;
			checkR[b] = true;

			float ans = 1;
	
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!check[j] && !checkR[i]) {
							a = i;
							b = j;
						}
					}
				checkR[a] = true;
				check[b] = true;
				ans *= (arr[a][b] / 100);
			}
			
			
			
			ans *= 100;
			System.out.println("#"+tc+" "+String.format("%.6f", ans));

		}

	}
}
