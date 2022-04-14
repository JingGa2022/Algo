import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static class Pos {
		int r, c, cost;

		public Pos(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
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
//				char[] chars = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
//					map[i][j] = chars[j] - '0';
					dist[i][j] = INF;
				}
			}

			System.out.println("#" + tc + " " + dijkstra(0, 0));
		} // tc
	}// main

	static int dijkstra(int stR, int stC) {
		boolean[][] visited = new boolean[N][N]; // 방문처리

		// 우선순위큐를 맹글어야대
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				return o1.cost - o2.cost;
			}
		});

		dist[stR][stC] = 0;
		pq.add(new Pos(stR, stC, dist[stR][stC]));

		while (true) {
			Pos curr = pq.poll();

			if (visited[curr.r][curr.c])
				continue; // 이미 처리된 정점이면 다음으로
			visited[curr.r][curr.c] = true; // 아니면 방문 처리

			if (curr.r == N - 1 && curr.c == N - 1)
				return curr.cost; // 도착지면 끝냄

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (inRange(nr, nc) && !visited[nr][nc] && dist[nr][nc] > curr.cost + map[nr][nc]) {
					dist[nr][nc] = curr.cost + map[nr][nc];
					pq.add(new Pos(nr, nc, dist[nr][nc]));
				}

			}
		}
	}

	static boolean inRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
