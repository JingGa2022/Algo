package problem;

import java.util.Scanner;

public class 스도쿠검증_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//T번만큼 회전
		for(int tc = 1; tc<=T; tc++) {
			//스도쿠 숫자넣기
			int[][] box = new int[9][9];
			//정답
			int ans = 1;
			//다 집어넣기
			for(int r = 0; r<9; r++) {
				for(int c = 0; c<9; c++) {
				box[r][c] = sc.nextInt();
				}
			}
			//행열검사
			for(int r = 0; r<9; r++) {
				int rsum = 0;
				int csum = 0;
				for(int c = 0; c<9; c++) {
				rsum += box[r][c];
				csum += box[c][r];
				}
				//열검사
				if(ans ==1)
				ans = rsum != 45?0:1;
				//행검사
				if(ans ==1)
				ans = csum != 45?0:1;
			}
			
			int cnt = 3;
			//상자검사
			for(int i = 0; i<9; i++) {
				int sum = 0;
				if(i%3==0) cnt--;
			for(int r = 0; r<3; r++) {
				for(int c = 0; c<3; c++) {
				sum += box[r + cnt*3][c + i%3*3];
				}}
				if(ans==1)
				ans = sum != 45?0:1;
			}
				
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
