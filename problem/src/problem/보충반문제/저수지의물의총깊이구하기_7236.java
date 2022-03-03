package problem.보충반문제;

import java.util.Arrays;
import java.util.Scanner;

public class 저수지의물의총깊이구하기_7236 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] puddle = new char[N][N];
			int max = 1;//최대값
			int cnt = 0;//
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++)
					puddle[i][j] = sc.next().charAt(0);
				}
			int[] dr = {-1, -1, 0, +1, +1, +1, 0, -1};//델타로 8방향 탐색시 행의 이동방향 12시부터 시계반대방향
			int[] dc = {0, -1, -1, -1, 0, +1, +1, +1}; 
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++) {
					cnt = 0;
					if(puddle[i][j]=='W') {
					for(int k = 0; k<8; k++) {
							if(i+dr[k]<0 || i+dr[k]>=N || j+dc[k]<0 || j+dc[k]>=N ) {}
							else if(puddle[i+dr[k]][j+dc[k]]=='W') cnt++;
						}
					}//8방향 탐색
					if(cnt>max) max = cnt;
					}//j번 돌기
				}//i번 돌기
			//입력을 받아서 1,1부터 N-2,N-2까지 확인하며 W일경우 주변부를 확인하여 깊이를 구하고, 그 수의 최대치를 구함
			System.out.printf("#%d %d\n",tc,max);
		}
		
	}
}
