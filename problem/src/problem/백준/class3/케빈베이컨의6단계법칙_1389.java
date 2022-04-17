package problem.백준.class3;

import java.util.Scanner;

public class 케빈베이컨의6단계법칙_1389 {
	static int N, ans;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++) map[i][j] = sc.nextInt();
			}
		}
	}
}
