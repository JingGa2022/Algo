package problem.정올.Beginner;

import java.util.Scanner;

public class 달팽이사각형_1707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = n;
		
		int num = 1;
		
		int x = 1;
		int y = 0;
		
		int[][] arr = new int[n+1][n+1];
		
		while(n > 0) {
			
			for(int i = 0; i<n; i++) {
				y++;
				arr[x][y] = num++;
			}
			
			n--;
			for(int i = 0; i<n; i++) {
				x++;
				arr[x][y] = num++;
			}
			
			for(int i = 0; i<n; i++) {
				y--;
				arr[x][y] = num++;
			}
			n--;
			for(int i = 0; i<n; i++) {
				x--;
				arr[x][y] = num++;
			}
		}
		
		for(int i = 1; i<=m; i++) {
			for(int j=1; j<=m; j++) {
				
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
