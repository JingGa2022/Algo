package problem.백준.class4;

import java.util.Scanner;

public class 구간합구하기5_11660 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n+1][n+1];
		int[][] sum = new int[n+1][n+1];
		
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1 ; j<=n; j++) {
				arr[i][j] = sc.nextInt();
				sum[i][j] = arr[i][j];
			}
		}
		
		//누적합을 구하고 필요없는부분 빼기
		for(int i = 1; i<=n; i++) {
			for(int j = 1 ; j<=n; j++) sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
		}
		
		
		for(int tc = 0; tc<m; tc++) {
			int ans = 0;
			int x1 = sc.nextInt();
			int y1 = sc.nextInt() ;
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
					
				ans = sum[x2][y2] -sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1 - 1];

			System.out.println(ans);
		}
	}
}
