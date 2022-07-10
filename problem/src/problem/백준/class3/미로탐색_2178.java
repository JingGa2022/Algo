package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
	static int n,m, min;
	static int[][] arr,visit;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class spot{
		int x;
		int y;
		int c;
		public spot(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		min = Integer.MAX_VALUE;
		
		arr = new int[n+1][m+1];
		visit = new int[n+1][m+1];
		
		for(int i = 1 ; i<=n; i++) {
			String tmp = sc.next();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		bfs(new spot(1, 1, 0));
		
		System.out.println(arr[n][m]);
	}
	private static void bfs(spot spot) {
		Queue<spot> q = new LinkedList<>();
		visit[spot.x][spot.y] = 1;
		
		q.offer(spot);
		while(!q.isEmpty()) {
			spot s = q.poll();
			
			for(int i = 0;i<4; i++) {
				spot sp = new spot(s.x + dr[i],s.y + dc[i], s.c++);
				
				if(sp.x > n || sp.x < 1 || sp.y >m || sp.y <1) continue;
				if(visit[sp.x][sp.y] == 1 || arr[sp.x][sp.y] == 0) continue;
				
				q.offer(sp);
				arr[sp.x][sp.y] = arr[s.x][s.y] +1;
				visit[sp.x][sp.y] = 1;
			}
		}
	}
}
