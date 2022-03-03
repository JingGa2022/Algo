package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 파리퇴치_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 파리가 든 배열
			int[][] fly = new int[N][N];
			// 파리 채우기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					fly[i][j] = sc.nextInt();
			}
			
			int maxF = 0;
			for (int i = 0; i <= N -M; i++) {
				// 시작점을 0부터 N-M까지
				for (int j = 0; j <= N-M; j++) {
					// 파리채의 길이만큼
					int sum = 0;
					for (int l = i; l < i+M; l++) {
						for (int k = j; k < j+M; k++) {
							sum += fly[l][k];
							}
					}
					if (sum > maxF)
						maxF = sum;
				}
			}
			System.out.printf("#%d %d\n", tc, maxF);
		}
	}
}
