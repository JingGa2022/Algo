package problem.백준.골드;

import java.util.*;

public class 다리만들기_2146 {
	/*
	 * 1. 섬을 각각 구분하여 쪼갠다 2. 각각 최외곽인지 확인 3. 최단길이 보다 길면 할 필요도 없음
	 */
	static class Point {
		int x;
		int y;
		int cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int n, min, ans, landNum;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		ans = Integer.MAX_VALUE;
		arr = new int[n][n];
		visit = new boolean[n][n];
		landNum = 2;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1)
					mkLand(i, j);
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (arr[i][j] >= 2) {
					visit = new boolean[n][n];
					bfs(i, j);
				}

			}

		System.out.println(ans);
	}

	static void mkLand(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		visit[x][y] = true;
		arr[x][y] = landNum;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dr[i];
				int ny = p.y + dc[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny] || arr[nx][ny] != 1)
					continue;
				visit[nx][ny] = true;
				arr[nx][ny] = landNum;
				q.add(new Point(nx, ny, 0));
			}
		}
		landNum++;
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		int now = arr[x][y];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dr[i];
				int ny = p.y + dc[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny] || arr[nx][ny] == now)
					continue;
				visit[nx][ny] = true;
				if (arr[nx][ny] == 0)
					q.offer(new Point(nx, ny, p.cnt + 1));
				else {
					ans = Math.min(ans, p.cnt);
				}
			}
		}
	}
}
