package problem.수업;

import java.util.Scanner;

public class 등산로조성 {
	static int N, K, maxH, ans;
	static int[][] mountain;
	static boolean[][] visited;
	static int[] dr= {0, 1, 0 ,-1};
	static int[] dc = {1, 0 , -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
				N = sc.nextInt();
				K = sc.nextInt();
				maxH = 0;
				ans = 0;
				
				// 지형입력
				mountain = new int[N][N];
				visited = new boolean[N][N];

				for(int i = 0; i<N; i++) {
					for (int j = 0; j < N; j++) {
						mountain[i][j] = sc.nextInt();
						if(mountain[i][j]>maxH) maxH = mountain[i][j];
					}
				}
				//등산로 조성 시도
				for(int i = 0; i<N; i++) {
					for (int j = 0; j < N; j++) {
						if(mountain[i][j] == maxH)
							crash(i,j,1,true);
					}
				}
				System.out.println("#" + tc+ " "+ ans);
		}
	}//main
	//행, 열 좌표, dist : 조성한 거리의 길이, skill : 공사를 할 수 있는지 여부
	private static void crash(int r, int c, int dist, boolean skill) {
		visited[r][c] = true;
		for(int i = 0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0|| nr >=N|| nc<0 || nc>=N || visited[nr][nc]) continue;
			
			//1.좌표가 나보다 낮을때
			if(mountain[r][c] > mountain[nr][nc])
				crash(nr,nc,dist+1, skill);
			//2. 나보다 같거나 높을떼
			//2-1. 공사 기회가 있는지.
			//2-2. 공사 견적이 있는지
			else if(skill && mountain[r][c] > mountain[nr][nr] - K) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[r][c] -1;
				crash(nr, nc, dist+1, false);
				mountain[nr][nc] = tmp;
				
			}
		}
		
		visited[r][c] = false;
	}
}//class
