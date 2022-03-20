package problem.백준;

import java.util.Scanner;

public class 유기농배추_1012 {
	static int M; // 밭의 가로길이
	static int N; // 밭의 세로길이
	static int K; // 배추가 심긴 위치의 개수
	static int X;// 밭의 x좌표
	static int Y;// 밭의 Y좌표

	static int[][] farm;
	static boolean[][] check; // 방문체크

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 밭의 가로길이
			N = sc.nextInt(); // 밭의 세로길이
			K = sc.nextInt(); // 배추가 심긴 위치의 개수
			farm = new int[M][N];
			check = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				X = sc.nextInt();
				Y = sc.nextInt();
				farm[X][Y] = 1;
			}
			
			int ans = 0;// 답
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					//방문 한했을떄
					if (farm[i][j] == 1 && !check[i][j]) {
						warm(i, j);
						ans++;
					}
				}

			}
			System.out.println(ans);
		}

	}

	public static void warm(int i, int j) {
		check[i][j] = true;// 배추가 확인 한건지 표시

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];

			// 범위 내일때
			if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
				// 배추가 있고 탐색 안했다면
				if (farm[nr][nc] == 1 && !check[nr][nc]) {
					warm(nr, nc);
				}
			}
		}

	}
}