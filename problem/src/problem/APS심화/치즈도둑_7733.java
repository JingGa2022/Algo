package problem.APS심화;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑_7733 {
	static class Cheese {
		int x;
		int y;

		public Cheese(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int[][] box;
	static int days;
	static int[] dr = { -1, 0, 1, 0 };// 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			box = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					box[i][j] = sc.nextInt();
			}

			days = 0; // 날짜

		} // for
	}// main

	static void bfs() {
		Queue<Cheese> q = new LinkedList<>();

		q.add(new Cheese(0, 0));
		while (!(q.isEmpty())) {
			Cheese cheese = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cheese.x + dr[i];
				int nc = cheese.y + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || box[nr][nc] == 0)
					continue;
				
				//날짜와 같은것이 있다면 먹어버리기
				if(box[nr][nc]==days)
					box[nr][nc] = 0;
				q.add(new Cheese(nr, nc));
			}
		}
	}//bfs

}//class
