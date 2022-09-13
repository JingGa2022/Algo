package problem.삼성sw역량테스트;

import java.util.Scanner;

public class 로봇청소기_14503 {
	static class Spot {
		int x;
		int y;

		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, ans;
	static int[][] room;
	static boolean[][] visit;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static Spot start;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		room = new int[n][m];
		visit = new boolean[n][m];
		ans = 0;

		start = new Spot(sc.nextInt(), sc.nextInt());

		int direction = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				room[i][j] = sc.nextInt();
		}
		dfs(start, direction);
		System.out.println(ans);
	}

	private static void dfs(Spot spot, int direction) {
		// TODO Auto-generated method stub
		if (!visit[spot.x][spot.y]) {
			ans++;
			visit[spot.x][spot.y] = true;
		}
		System.out.printf("지금어디? %d %d\n", spot.x, spot.y);
		int cnt = 0;

		int newX = spot.x + dr[(direction+1) % 4];
		int newY = spot.y + dc[(direction+1) %4];

		if (newX < 1 || newY < 1 || newX > n - 2 || newY > m - 2 || room[newX][newY] == 1) {
			cnt++;
			continue;
		}

		if (!visit[newX][newY]) {
			dfs(new Spot(newX, newY), i);
		}

		if (cnt == 4) {

		}
	}
}
