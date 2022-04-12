package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최적경로_1247 {
	static class Spot {
		int x;
		int y;

		public Spot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int[] dr = { -1, 0, 1, 0 };// 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] box; // 방문했음 1 아니면 0 고객은 2 회사는 3 집은 4
	static boolean[][] visited;
	static Spot com;
	static Spot home;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 0;

			box = new int[101][101];
			visited = new boolean[101][101];

			com = new Spot(sc.nextInt(), sc.nextInt());// 회사의 좌표 3
			home = new Spot(sc.nextInt(), sc.nextInt());// 집의 좌표 4
			box[com.x][com.y] = 3;
			box[home.x][home.y] = 4;

			for (int i = 0; i < N; i++)
				box[sc.nextInt()][sc.nextInt()] = 2;

			bfs();
//			for (int i = 0; i <= 100; i++) System.out.println(Arrays.toString(box[i]));

			System.out.println(ans);
		}
	}// main

	private static void bfs() {
		Queue<Spot> q = new LinkedList<>();

		q.add(com);
		int cnt = N;
		int tmp = 0;

//		for (int a = 0; a <= N; a++) {
		outer : while (!q.isEmpty()) {
			
			int qSize = q.size();
			for(int a = 1; a<=qSize; a++) {
				Spot spot = q.poll();
				visited[spot.x][spot.y] = true;
											
				for (int i = 0; i < 4; i++) {
					int nr = spot.x + dr[i];
					int nc = spot.y + dc[i];

					if (nr < 0 || nc < 0 || nr > 100 || nc > 100 || visited[nr][nc])
						continue;

					q.add(new Spot(nr, nc));
					visited[nr][nc] = true;

					if (box[nr][nc] == 2) {
						box[nr][nc] = 1;// 방문한 고객은 1로 변경
						recovery();
						cnt--;
						break outer;
					}
					
					if (box[spot.x][spot.y] == 4 && cnt == 0)
						break outer;
				}
			}
			ans++;
		}
	}

	private static void recovery() {

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				visited[i][j] = false;
			}
		}

	}

}// class
