package problem;

import java.util.Scanner;

public class 오목판정_11315 {
	static int[] dr = {0,1,1,1}; //우, 우하, 하 ,좌하
	static int[] dc = {1,1,0,-1};
	
	static char[][]map;
	static int N;//(5<= N<=20)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			
			map = new char[N][N];
			for(int i= 0; i<N; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			boolean isOk = false;
			String ans = "NO";
			for(int i =0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(map[i][j] == 'o' && check(i,j)) {
						isOk =true;
						ans = "YES";
						break;
					}
				}
			}
			if(isOk) {
				System.out.println("#"+tc+"YES");
			}else {
				System.out.println("#"+tc+"NO");
			}
			System.out.println("#"+tc+ " " +(isOk?"YES":"NO"));
			System.out.println("#"+tc+" "+ ans);
		}
	}
	
	public static boolean check(int r, int c) {
		for(int d =0; d<4; d++) {
			//육목이든 칠목이든 상관없음
			int cnt =1;
			for(int i =1; i<5; i++) {
				int nr = r + dr[d] *i;
				int nc = c + dr[d] * i;
				if(nr <0 || nc <0 || nr >=N || nc>=N) continue;
				if(map[nr][nc] =='o')
					cnt++;
			}
			if(cnt == 5)
			return true;
		}
		
		return false;
	}
}
