package problem;

import java.util.Scanner;

public class 기지국_13707 {
	static char[][] map;
	static int[] dr = {-1,0,1,0};//상좌하우
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
		int N = sc.nextInt();
		int ans = 0;
		map = new char[N][N];
		for(int i =0; i <N; i++) {
			map[i]=sc.next().toCharArray();
		}
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				switch(map[i][j]) {
				case 'A':
					cover(1,i,j);
					break;
				case 'B':
					cover(2,i,j);
					break;
				case 'C':
					cover(3,i,j);
					break;
				}
			}
		}
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(map[i][j] == 'H') ans++;
			}
		}
		System.out.printf("#%d %d\n",tc,ans);
		}//for
		
	}//main
	public static void cover(int num, int y, int x) {
		int idx = 1;
		int n = map.length;
		for(int i =0; i<num; i++) {
			for(int j=0; j<4;j++) {
				if( y+dr[j]*idx>=0 && y+dr[j]*idx <n && x+dc[j]*idx>=0 && x+dc[j]*idx <n){
				if(map[y+dr[j]*idx][x+dc[j]*idx] == 'H' ) {
					map[y+dr[j]*idx][x+dc[j]*idx]='O';
				}
			}
			}
			idx++;
		}
	}
}
