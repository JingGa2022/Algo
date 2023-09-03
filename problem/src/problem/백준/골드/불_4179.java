package problem.백준.골드;

import java.util.*;

public class 불_4179 {
	/*
	 * 1. 지훈이와 불의 동시성을 처리
	 * 
	 */
	static int[][] map, visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		map = new int[x][y];
		visited = new int[x][y];

		Queue<Node> jq = new LinkedList<>();
		Queue<Node> fq = new LinkedList<>();
		for (int i = 0; i < x; i++) {
			String t = sc.next();
			for (int j = 0; j < y; j++) {
				char tmp = t.charAt(j);
				if (tmp == '#') {
					map[i][j] = -1;
				} else if (tmp == 'J') {
					map[i][j] = 1;
					jq.add(new Node(i, j));
				} else if (tmp == 'F') {
					map[i][j] = -2;
					fq.add(new Node(i, j));
				}
			}
		}

		int ans = 0;

		while (true) {
			ans++;
			int fs = fq.size();
			while (fs > 0) {
				fs--;
				Node node = fq.poll();
				int x2 = node.x;
				int y2 = node.y;
				for (int i = 0; i < 4; i++) {
					if (x2 + dx[i] >= 0 && x2 + dx[i] < x && y2 + dy[i] >= 0 && y2 + dy[i] < y) {
						if (map[x2 + dx[i]][y2 + dy[i]] >= 0) {
							fq.add(new Node(x2 + dx[i], y2 + dy[i]));
							map[x2 + dx[i]][y2 + dy[i]] = -2;
						}
					}

				}
			}
			int js = jq.size();
			while (js > 0) {
				js--;
				Node node = jq.poll();
				int x2 = node.x;
				int y2 = node.y;
				for (int i = 0; i < 4; i++) {
					if (x2 + dx[i] < 0 || x2 + dx[i] >= x || y2 + dy[i] < 0 || y2 + dy[i] >= y) {
						System.out.println(ans);
						return;
					}
					if (map[x2 + dx[i]][y2 + dy[i]] == 0) {
						jq.add(new Node(x2 + dx[i], y2 + dy[i]));
						map[x2 + dx[i]][y2 + dy[i]] = 1;
					}
				}

			}
			if (jq.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
	}
}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}