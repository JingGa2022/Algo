package problem;

import java.util.Scanner;

public class 숫자배열회전_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[][] box = new String[N][N];
			int[][] ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					box[i][j] = sc.next();
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				String tmp1 = new String();
				String tmp2 = new String();
				String tmp3 = new String();
				for (int j = 0; j < N; j++) {
					tmp1 += box[N-1-j][i];
					tmp2 += box[N-1-i][N-1-j];
					tmp3 += box[j][N-1-i];
				}
				System.out.println(tmp1 +" "+ tmp2+ " "+ tmp3);
			}
		}//test케이스
	}//main
}
