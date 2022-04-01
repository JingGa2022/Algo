package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 미로1_1226 {
	static int[][] map ;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <=10; tc++) {
			tc = sc.nextInt();
			map = new int[16][16];
			String[] tmp;
			//입력받기
			sc.nextLine();
			for(int i = 0; i<16; i++) {		
				tmp =sc.nextLine().split("");
				for(int j =0; j<16; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			ans = 0;
			maize(1,1);
			System.out.println("#"+tc+" "+ ans);
			
		}
	}//main
	private static void maize(int startI, int startJ) {
		map[startI][startJ] = 1;//방문기록
		
		for(int i=0; i<4; i++) {
			if(map[startI + dr[i]][startJ+dc[i]] ==0) {
				maize(startI + dr[i],startJ+dc[i]);
			}
			else if(map[startI + dr[i]][startJ+dc[i]] == 3) 
				ans= 1;	
		}
		return;
	}
	
}
