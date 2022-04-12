import java.util.Scanner;

public class SWEA_치즈덩이_DFS {
	static int[][] cheese; // 치즈를 저장할 2차원 배열
	static boolean[][] visited; // 박문철2
	static int N; // 한변의 길이를 저장 2 <= N <= 100
	static int[] dr = { -1, 1, 0, 0 }; // 문제에서 인접한 4방향으로만 이야기를 했으니
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우로 하겠다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 한변의 길이를 입력을 받겠다.

			cheese = new int[N][N];

			int maxH = -1; // 가장 맛난 치즈값
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if (maxH < cheese[i][j])
						maxH = cheese[i][j];
//					maxH = Math.max(maxH, cheese[i][j]);
				}
			}
			int ans = 1;
			// 각각의 일차를 진행 시키면서~~~ 최대 덩이를 찾아보자~~~
			for (int h = 1; h < maxH; h++) {
				visited = new boolean[N][N]; // 박문철2 초기화
				int cnt = 0; // 이번 일차의 덩어리 수 카운팅
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 어? 너 시작점이네? 이것을 어떻게 알까요?
						//
						if (!visited[r][c] && cheese[r][c] > h) {
							cnt++;
							dfs(r, c, h);
						} // DFS 탐색
					}
				}
				// 이번 일차 냠냠끝
				if (cnt > ans)
					ans = cnt;
			} // 일차를 진행시키는 반복문

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main

	private static void dfs(int r, int c, int h) {
		visited[r][c] = true; // 여기 치즈 맛있넹 내가 먹었다.

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (visited[nr][nc] || cheese[nr][nc] <= h)
				continue;
			dfs(nr, nc, h);
		}

	}// dfs
}
