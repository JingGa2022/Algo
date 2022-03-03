package problem;

import java.util.Scanner;

public class 파동파동_13705 {
	static int[][] box;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] ans = new int[T][];
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			box = new int[N][N];
			box[R][C] = M;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int max = Math.max(Math.abs(i - R), Math.abs(i - C));
					box[i][j] = M + D * max;
					if (box[i][j] < 0)
						box[i][j] = 0;
					else if (box[i][j] > 255)
						box[i][j] = 255;
				}
			}
			ans[tc-1] = new int[N];
			for (int i = 0; i < N; i++) {
				int sum =0;
				for (int j = 0; j < N; j++) {
					sum+=box[i][j];
					ans[tc-1][i]=sum;
				}
				
			}
			System.out.printf("#%d ",tc);
			for(int i =0; i<ans[tc-1].length; i++)
			System.out.printf("%d ",ans[tc-1][i]);
			System.out.println();
		}//for
	}// main
}
