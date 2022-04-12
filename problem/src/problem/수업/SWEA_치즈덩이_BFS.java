import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_치즈덩이_BFS {
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] cheese; // 치즈를 저장할 2차원 배열
	static boolean[][] visited; // 박문철2
	static int N; // 한변의 길이를 저장 2 <= N <= 100
	static int[] dr = { -1, 1, 0, 0 }; // 문제에서 인접한 4방향으로만 이야기를 했으니
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우로 하겠다.
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 한변의 길이를 입력을 받겠다.

			cheese = new int[N][N];
			visited = new boolean[N][N];

			int maxH = -1; // 가장 맛난 치즈값
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if (maxH < cheese[i][j])
						maxH = cheese[i][j];
				}
			}
			ans = 1;
			// 각각의 일차를 진행 시키면서~~~ 최대 덩이를 찾아보자~~~
			for (int h = 1; h < maxH; h++) {
				// 전체를 탐색하면서 살아남은 치즈를 표시를 해보자.
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (cheese[r][c] > h)// 내가 냠냠할거
							visited[r][c] = false;
						else // 요정이 이미 냠냠함.
							visited[r][c] = true;
					}
				}
//				int tmp = bfs();
//				if(tmp > ans) ans = tmp;
				bfs();
			} // 일차를 진행시키는 반복문

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 내가 먹었거나 요정이 냠냠했거나
				if (visited[i][j])
					continue;
				// 시작점이니까
				
				q.add(new Pos(i, j));
				visited[i][j] = true;
				cnt++;

				while (!q.isEmpty()) {
					Pos p = q.poll();

					for (int d = 0; d < 4; d++) {
						int nr = p.r + dr[d];
						int nc = p.c + dc[d];

						if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
							continue;
						
						visited[nr][nc] = true;
						q.add(new Pos(nr,nc));
					}
				}//큐를 while

			}
		}
		if(ans < cnt) ans = cnt;
		
		

	}//bfs 메서드

}
