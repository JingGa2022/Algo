package problem.APS심화;

import java.util.Scanner;

public class 파핑파핑지뢰찾기_1868 {
	static String[][] mine;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0 ,-1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			mine = new String[N+2][N+2];
			sc.nextLine();
				for(int i = 1; i<=N; i++) {
					mine[i] = sc.nextLine().split("");
				}
		}//for
	}// main
}
