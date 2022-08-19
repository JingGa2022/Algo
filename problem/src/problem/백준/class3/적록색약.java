package problem.백준.class3;

import java.util.Scanner;

public class 적록색약 {
	public static class Spot{
		int x;
		int y;
		private Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int ans1, ans2, n;
	static char[][] painting;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		painting = new char[n][n];
		visit = new boolean[n][n];
		
		for(int i =0; i<n; i++) {
			String s = sc.next();
			for(int j = 0; j<n; j++) {
				painting[i][j] = s.charAt(j);
			}
		}
		
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(!visit[i][j]) {
					bfs(i,j);
					ans1++;
				}
			}
		}
		
		visit = new boolean[n][n];
		
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(painting[i][j] == 'G') {
					painting[i][j] = 'R';
				}
			}
		}
		
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(!visit[i][j]) {
					bfs(i,j);
					ans2++;
				}
			}
		}
		System.out.printf("%d %d", ans1, ans2);
	}//main
	private static void bfs(int row, int col) {
		visit[row][col] = true;
		char tmp = painting[row][col];
		
			for(int i = 0  ;i<4; i++) {
				int newX = row + dc[i];
				int newY = col + dr[i];
				
				if(newX<0 || newY<0 || newX >= n || newY>=n ) continue;
				if( !visit[newX][newY] && tmp == painting[newX][newY]) 
					bfs(newX, newY);
				
		}
	
		
	}
}
