package problem.백준.골드;

import java.util.*;

public class Gaaaaaaaaaarden_18809 {
	/*
	 * 1. 배양액 땅이 따로 있고 같은데 또 뿌리기 불가 2. 배양액이 모든 부분으로 퍼지고 빨 초가 만나면 꽃이핌 (단, 꽃이 핀곳은 배양액
	 * 못 퍼짐) 3.
	 */
	static class Pos {
		int x;
		int y;
		int time;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 0;
		}
	}

	static class Pair {
		int time;
		int type;

		Pair() {

		}

		Pair(int time, int type) {
			this.time = time;
			this.type = type;
		}
	}

	static int n, m, g, r, max;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] reds, greens;
	static int[][] arr;
	static boolean[] visit;
	static final int RED = 3;
	static final int GREEN = 4;
	static final int FLOWER = 5;
	static ArrayList<Pos> ground = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행열
		n = sc.nextInt();
		m = sc.nextInt();
		// 초록 빨강 배양액 수
		g = sc.nextInt();
		r = sc.nextInt();

		arr = new int[n][m];
		visit = new boolean[10];
		// 0 초록 1 빨강
		greens = new int[g];
		reds = new int[r];

		int cnt = 0;
		// 호수 0, 배약액 불가1, 배약액 가능 2
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 2) {
					ground.add(new Pos(i, j));
				}
			}
		}

		gSolve(0, 0);
		
		System.out.println(max);
	}

	private static void gSolve(int start, int dept) {
		// TODO Auto-generated method stub
		if (dept == g) {
			rSolve(0, 0);
			return;
		}

		for (int i = start; i < ground.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				greens[dept] = i;
				gSolve(i + 1, dept + 1);
				visit[i] = false;
			}
		}
	}

	private static void rSolve(int start, int dept) {
		if (dept == r) {
			bfs();
			return;
		}

		for (int i = start; i < ground.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				reds[dept] = i;
				rSolve(i + 1, dept + 1);
				visit[i] = false;
			}
		}
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		Pair[][] state = new Pair[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				state[i][j] = new Pair();

		// 배양지로 선택한 곳에 배약액 넣기
		for (int i = 0; i < g; i++) {
			Pos p = ground.get(greens[i]);
			state[p.x][p.y] = new Pair(0, GREEN);
			q.add(new Pos(p.x, p.y));
		}

		for (int i = 0; i < r; i++) {
			Pos p = ground.get(reds[i]);
			state[p.x][p.y] = new Pair(0, RED);
			q.add(new Pos(p.x, p.y));
		}

		int sum = 0;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			int time = state[p.x][p.y].time;
			int type = state[p.x][p.y].type;
			if (state[p.x][p.y].type == FLOWER)
				continue;
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dr[i];
				int ny = p.y + dc[i];
				if (nx >= n || nx < 0 || ny >= m || ny < 0)
					continue;
				if (arr[nx][ny] == 0)
					continue;
				

				if (state[nx][ny].type == 0) {
					state[nx][ny] = new Pair(time + 1, type);
					q.offer(new Pos(nx, ny));
				} else if (state[nx][ny].type == RED) {
					if (type == GREEN && state[nx][ny].time == time + 1) {
						sum++;
						state[nx][ny].type = FLOWER;
					}
				} else if (state[nx][ny].type == GREEN) {
					if (type == RED && state[nx][ny].time == time + 1) {
						sum++;
						state[nx][ny].type = FLOWER;
					}
				}
			}
		}
		max = max < sum ? sum : max;
	}
}
