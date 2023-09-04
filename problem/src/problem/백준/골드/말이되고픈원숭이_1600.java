package problem.백준.골드;

import java.util.*;

public class 말이되고픈원숭이_1600 {
	/*
	 * 1. 말과 원숭이의 이동방향 12가지
	 * 2. 말 이동 별로 방문 체크
	 */
	static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hc = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		int c = sc.nextInt();
		int r = sc.nextInt();

		int[][] arr = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, k));
		boolean[][][] visited = new boolean[r][c][k + 1];
		visited[0][0][k] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == r - 1 && node.y == c - 1) {
				System.out.println(node.m);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int x = node.x + dr[i];
				int y = node.y + dc[i];
				if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y][node.k] && arr[x][y] == 0) {
					visited[x][y][node.k] = true;
					q.add(new Node(x, y, node.m + 1, node.k));
				}
			}
			if(node.k > 0) {
				for (int i = 0; i < 8; i++) {
					int x = node.x + hr[i];
					int y = node.y + hc[i];
					if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y][node.k - 1] && arr[x][y] == 0) {
						visited[x][y][node.k - 1] = true;
						q.add(new Node(x, y, node.m + 1, node.k - 1));
					}
				}
			}
		}

		System.out.println(-1);
	}

	static class Node {
		int x;
		int y;
		int m;
		int k;

		Node(int x, int y, int m, int k) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.k = k;
		}
	}
}
