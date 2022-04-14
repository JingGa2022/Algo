import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1249_보급로2 {
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N; // 한변의 길이
	static final int INF = Integer.MAX_VALUE;
	static int[][] map, dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N]; // 초기화 해야될거같은데 대전 4반 안성진님 아이디어~~

			// 입력이 붙어서 들어오는데 한칸씩 떼서 저장을 해야할 거같다.

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					dist[i][j] = INF;
				}
			}

			Queue<Pos> q = new LinkedList<>();
			dist[0][0] = 0;
			q.add(new Pos(0, 0));

			while (!q.isEmpty()) {
				Pos curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];

					if (inRange(nr, nc) && dist[nr][nc] > dist[curr.r][curr.c] + map[nr][nc]) {
						dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
						q.add(new Pos(nr, nc));
					}
				}
			}

			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
		} // tc
	}// main

	static boolean inRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
