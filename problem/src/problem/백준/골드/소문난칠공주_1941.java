package problem.백준.골드;

import java.util.*;

public class 소문난칠공주_1941 {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/*
	 * 1. 꿈틀꿈틀 움직이면서 7개를 먹고 2. 만약 y가 3개 이상 포함 되면 다시 뒤로 돌리기
	 */
	static int ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] check = new int[7];
	static int[][] arr = new int[5][5];
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// y = 1, s = 2
		for (int i = 0; i < 5; i++) {
			String s = sc.next();
			for (int j = 0; j < 5; j++) {
				char c = s.charAt(j);
				if (c == 'Y')
					arr[i][j] = 1;
				else
					arr[i][j] = 2;
			}
		}

		comb(0, 0, 0);

		System.out.println(ans);
	}

	static void comb(int cnt, int start, int dCnt) {
		if (cnt - dCnt > 3)
			return;

		if (cnt == 7) {
			visit = new boolean[7];
			bfs(check[0] / 5, check[0] % 5);
			return;
		}

		for (int i = start; i < 25; i++) {
			int x = i / 5;
			int y = i % 5;
			check[cnt] = i;
			comb(cnt + 1, i + 1, arr[x][y] == 2 ? dCnt + 1 : dCnt);
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int len = 1;
		visit[0] = true;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dr[i];
				int ny = tmp.y + dc[i];
				if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
					int nxt = 5 * nx + ny;
					for (int j = 0; j < 7; j++) {
						if (!visit[j] && check[j] == nxt) {
							len++;
							q.add(new Point(nx, ny));
							visit[j] = true;
						}

					}
				}
			}
		}

		if (len == 7) {
			ans++;
		}
	}
}
