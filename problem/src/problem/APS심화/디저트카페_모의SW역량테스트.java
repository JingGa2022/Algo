package problem.APS심화;

import java.util.Scanner;

public class 디저트카페_모의SW역량테스트 {
	static int[][] arr;
	static int[][] visited;
	static boolean[] num;
	static int[] dr = {-1,1,1,-1};
	static int[] dc = {1, 1, -1, -1};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T; tc++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			num = new boolean[101];
			visited = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) arr[i][j] = sc.nextInt();
			}
		}
	}
}
