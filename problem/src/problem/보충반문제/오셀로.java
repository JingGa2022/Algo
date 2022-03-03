package problem.보충반문제;

import java.util.Arrays;
import java.util.Scanner;

public class 오셀로 {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1 , -1 ,0, 1, 1, 1};
	static int[][] othello;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //게임판 길이 4 6 8
			int M = sc.nextInt();//돌을 놓는 횟수
			
			int[][] othello = new int[N+1][N+1];
			
			int S = N/2;
			
			othello[S][S] = othello[S+1][S+1] = 2;
			othello[S][S+1] = othello[S+1][S] = 1;
			
			for(int i =0; i<M; i++) {
				int c =sc.nextInt();
				int r =sc.nextInt();
				int color = sc.nextInt();
				
				othello[r][c] = color;
				//내가 돌을 두면서 바뀌어야 할 곳이 뭔지
				for(int d=0; d<8; d++) {
					
					int nr = r;
					int nc = c;
					//해당 d바얗ㅇ으로 쭉 벋어나가면서 나와 같은 돌을 처음 만날때까지 이동
					while(true) {
						nr += dr[d];
						nc += dc[d];
						if(nr <= 0 || nc <=0 || nr>N || nc>N || othello[nr][nc]==0) break;
						//같은색을 만나면
						if(othello[nr][nc]== color) {
							while(!(nr == r && nc == c)) {
								nr -= dr[d];
								nc -= dc[d];
								othello[nr][nc] = color;
							}
							break;
						}
					}
				}
			}//오셀로 돌놓기
			
			int bCnt = 0;
			int wCnt = 0;
			
			int[] ans = new int[3];
			for(int i =1; i<=N; i++) {
				for(int j =1; j <=N; j++) {
					if(othello[i][j]==1) {
						bCnt++;
					}else if(othello[i][j] == 2) {
						wCnt++;
					}
				}
			}
			System.out.println(());
		}
	}//main
	
	public static void printo() {
		for(int i =0; i<othello.length; i++) {
			System.out.println(Arrays.toString(othello[i]));
		}
	}
}
