package problem.수업;

import java.util.Scanner;

public class NQueen {
	static int N, ans;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			N = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			
			dropTheQueen(0);
			
			System.out.println("#"+tc+ " " +ans);
		}
	}//main
	static void dropTheQueen(int r) {
		if(r == N) {
			
			//이버넹 놓은 퀸들을 확일할 필요
			
			ans++;
			return;
		}
		for(int c = 0; c<N; c++) {
			if(check(r,c)) {
			map[r][c] = 1; //퀸을 놓았다.
			dropTheQueen(r+1);
			map[r][c] = 0; //다음을 위해 퀸 회수
			}
		}
	}
	//해당 행에서 Queen을 놓아봐야함;
	
	static int[] dc = {-1,0,1};
	private static boolean check(int r, int c) {
		for(int i =0; i<3; i++) {
			int nr = r;
			int nc = c;
			
			while(true) {
				nr -= 1;
				nc += dc[i];
				
				if(nr < 0 || nc <0 || nc>=N) break;
				
				if(map[nr][nc] == 1) return false;
			}
		}
		return true;
	}
	
	private static boolean check2(int r, int c) {
		int left = c;
		int right = c;
		
		for(int i = r-1; i>=0; i--) {
			left--;
			right++;
			//위쪽확인
			if(map[i][c] == 1) return false;
			if(left >= 0 && map[i][left] == 1) return false;//왼쪽 대각 확인
			if(right < N && map[i][right] == 1) return false;
		}
		return true;
	}
	
}
