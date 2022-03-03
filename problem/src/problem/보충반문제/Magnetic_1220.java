package problem.보충반문제;

import java.util.Scanner;

public class Magnetic_1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRed = false; //빨간휴지줄까 파란휴지줄까..?
		for(int tc = 1; tc<=10; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			int[][] table = new int[N][N];
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) table[i][j] = sc.nextInt();
			}//입력
			for(int i=0; i<N;i++) {
				isRed = false;//열마다 초기화 시켜줄것
				for(int j=0; j<N;j++) {
					if(table[j][i] == 1) {
						isRed = true;//빨간색
					}else if(table[j][i] == 2) {
						if(isRed) ans++;
						isRed = false;//파란색
					}
				}
			}//경합찾기
			System.out.printf("#%d %d\n",tc,ans);
		}
		
	}//main
}
