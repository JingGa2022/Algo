package problem.APS심화;

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
	static int[][] box = new int[101][101]; // 방문했음 1 아니면 0 고객은 2 회사는 3 집은 4
	static boolean[][] visited = new boolean[101][101]; // 방문했음 1 아니면 0 고객은 2 회사는 3 집은 4
	static Spot com;
	static Spot home;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			com = new Spot(sc.nextInt(), sc.nextInt());// 회사의 좌표 3
			home = new Spot(sc.nextInt(), sc.nextInt());// 집의 좌표 4
			box[com.x][com.y] = 3;
			box[home.x][home.y] = 4;

			for (int i = 0; i < N; i++)
				box[sc.nextInt()][sc.nextInt()] = 2;

			bfs();

			System.out.println(cnt);
		}
	}// main

	private static void bfs() {
		Queue<Spot> q = new LinkedList<>();

		q.add(com);
		cnt = 0;
		visited[com.x][com.y] = true;

		for (int a = 0; a < N; a++) {
			outer: while (!(q.isEmpty())) {
				Spot spot = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = spot.x + dr[i];
					int nc = spot.y + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
						continue;

					q.add(new Spot(nr, nc));
					visited[nr][nc] = true;
					cnt++;

					if (box[nr][nc] == 2)
						break outer;
					
					if (box[nr][nc] == 4)
						break outer;
				}

			}
		}
	}

}// class
