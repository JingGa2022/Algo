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
	static boolean[][] visited;
	static int days;
	static int[] dr = { -1, 0, 1, 0 };// 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 1;
			int maxD = 0;//최대 날짜
			
			box = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					box[i][j] = sc.nextInt();
					if(box[i][j] > maxD) maxD = box[i][j];
				}
			}

			visited = new boolean[N][N];
			
			//날짜가 하루씩 가면서 치즈를 먹고
			for(int a = 1; a<=maxD; a++) {
			for(int i =0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(box[i][j] <= a)
						visited[i][j] = true;
					else 
						visited[i][j] = false;
				}
			}
			//거기서 돌려서 개수를 찾아보자
			bfs();
			}
			
			System.out.println("#"+tc+" "+ans);
		} // for
	}// main

	static void bfs() {
		Queue<Cheese> q = new LinkedList<>();
		
		int cnt = 0;
		for(int x = 0; x < N; x++) {
			for(int y = 0; y<N; y++) {
				
				if(visited[x][y]) continue;
				
				visited[x][y] = true;
				q.add(new Cheese(x, y));
				cnt++;
				while (!(q.isEmpty())) {
					Cheese cheese = q.poll();
					for (int i = 0; i < 4; i++) {
						int nr = cheese.x + dr[i];
						int nc = cheese.y + dc[i];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] )
							continue;
						
						//날짜와 같은것이 있다면 먹어버리기
						visited[nr][nc] = true;
						q.add(new Cheese(nr, nc));
					}
				}
				
			}
		}
		if(cnt > ans) ans = cnt;
	}//bfs

}//class
