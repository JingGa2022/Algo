package problem.보충반문제.백준;

import java.util.Scanner;

public class 색종이_10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 색종이 장수
		int[][] box = new int[1001][1001];// 전체크기
		//종이 집어넣기
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();// 가로의좌표
			int b = sc.nextInt();// 세로의좌표
			int row = sc.nextInt();// 가로의 길이
			int col = sc.nextInt();// 세로의 길이
			for (int i = a; i < a + row; i++) {
				for (int j = b; j < b + col; j++) {
					box[i][j] = tc;
				}
			}
		}
		//종이별 드러나는 수 구하기
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (box[i][j] == tc) 
						ans++;
				}
			} System.out.println(ans);
		}
	}//main
}
