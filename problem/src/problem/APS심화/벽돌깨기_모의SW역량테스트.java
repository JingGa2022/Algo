package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 벽돌깨기_모의SW역량테스트 {
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int N,W,H; //벽돌의 개수, 넓이, 높이
	static int[][] block;
//	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();//공의개수
			W = sc.nextInt();
			H = sc.nextInt();
			
			block = new int[H][W];
			
			
			for(int i = 0; i<H; i++) {
				for(int j =0; j<W; j++) {
					block[i][j] = sc.nextInt();
				}
			}
			
				shoot();
			
			for(int i =0; i<H ; i++)
			System.out.println(Arrays.toString(block[i]));
			
		}//tc
	}//main
	//가장큰 폭탄 찾아서 쏘기
	static void shoot() {
		int max = 0;
		Pos pos = new Pos(0,0);
		for(int i = 0; i<W; i++) {
			for(int j =0; j<H; j++) {
				if(block[j][i] != 0) {
					if(max < block[j][i]) {
						max = block[j][i];
						pos = new Pos(j, i);
					}
					break;
				}
			}
		}

		bomb(pos.x, pos.y, max);
	}//
	//폭발시키기 x y는 폭탄의 위치 pow는 폭탄의 위력
	static void bomb(int x, int y, int pow) {

		block[x][y] = 0;
		for(int i = 1; i<=pow-1; i++) {
			for(int j = 0; j<4; j++) {
				int nr = x + i*dr[j];
				int nc = y + i*dc[j];
				
				if(nr<0 || nc < 0 || nr>= H || nc>= W|| block[nr][nc] == 0) continue;
				System.out.println(block[nr][nc]);
				System.out.println(nr+" "+nc);
				if(block[nr][nc] == 1) block[nr][nc] = 0;
				else if(block[nr][nc] > 1) bomb(nr,nc, block[nr][nc]);
			}
		}
	}
	//폭발하고 남은 벽돌들 정리하기
	static void arrange() {
		boolean flag = false;
		
		for(int i = 0; i<W; i++) {
			int nr = 0;	
			int cnt = 0;
			while(nr != H) {
				if(block[i][nr] == 0) {
					int[] tmp = new int[nr+1];
					flag = true;
					cnt++;
				}else {
					cnt = 0;
					
				}
				
				nr++;
			}
			
			}
		}
}
