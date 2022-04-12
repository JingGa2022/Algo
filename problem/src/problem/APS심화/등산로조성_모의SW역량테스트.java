package problem.APS심화;

import java.util.Scanner;

public class 등산로조성_모의SW역량테스트 {

	
	static int[][] mountain;//산 지형저장
	static boolean[][] visited;
	static int N,K, ans, maxH;//지도 길이, 공사가능
	static int[] dr = {0, 1, 0 ,-1};
	static int[] dc = {1, 0 ,-1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			ans = 0;
			// 지형입력
			mountain = new int[N][N];
			visited = new boolean[N][N];
			maxH = 0;//가장 높은 봉우리
			for(int i = 0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					if(mountain[i][j]>maxH) maxH = mountain[i][j];
				}
			}
			for(int i = 0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					if(maxH == mountain[i][j])
						dfs(i, j, maxH,1, true);
				}
			}
			
			System.out.println("#" +tc+" "+ ans);
		}//tc
	}//main
	
	private static void dfs(int r, int c, int h , int far, boolean k) {
		if(far>ans) ans = far;
		
		visited[r][c] = true;
		for(int i =0; i< 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= N || nc >= N || nc < 0|| nr < 0|| visited[nr][nc]) continue;
			
			//공사가능
			if(h> mountain[nr][nc])
				dfs(nr, nc, mountain[nr][nc], far+1, k);
			
			//공사이미 함
			else if(k && mountain[nr][nc] -K < h)
				dfs(nr, nc, mountain[r][c] - 1, far+1, false);
		}
		
		visited[r][c] = false;
	}
	
}//class
