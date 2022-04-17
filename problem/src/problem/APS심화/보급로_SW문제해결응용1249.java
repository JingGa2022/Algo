package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보급로_SW문제해결응용1249 {
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
				
	}
	
	static int N, min;
	static int[][] map;
	static boolean[][] visited;
	static int[][] ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			
			String[] tmp;
			for(int i = 0; i<N; i++) {				
				tmp = sc.next().split("");
				for(int j = 0; j<N; j++)
					map[i][j] = Integer.parseInt(tmp[j]);							
			}
			
		
			ans = new int[N][N];
			for(int i = 0; i<N; i++)
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			ans[0][0] = 0;
			
			bfs();
			
			
			System.out.println("#"+tc+" "+min);
			
		}//tc
	}// main
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			
			if(x == N-1 && y == N-1)
				min = min > ans[N-1][N-1] ? ans[N-1][N-1] : min;
				
			if(min <= ans[x][y]) continue;
			
			for(int i = 0; i<4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if(isValidPosition(nc, nc)){
                    if(!visited[nc][nc] || ans[nc][nc] > ans[x][y] + map[nc][nc]){
                        visited[nc][nc] = true;
                        ans[nc][nc] = ans[x][y] + map[nc][nc];
                        q.offer(new Pos(nc, nc));
                    }
                }
            }
        }
    }
 
    private static boolean isValidPosition(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }
}
