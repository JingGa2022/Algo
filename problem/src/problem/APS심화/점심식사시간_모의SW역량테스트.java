package problem.APS심화;

import java.util.Scanner;

public class 점심식사시간_모의SW역량테스트 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			
			arr = new int[N][N];
			for(int i =0; i<N; i++) {
				for(int j = 0; j<N; j++) arr[i][j] = sc.nextInt();
			}
		}
	}
}
