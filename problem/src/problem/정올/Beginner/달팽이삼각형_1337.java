package problem.정올.Beginner;

import java.util.Scanner;

public class 달팽이삼각형_1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		int idx = 0;
		int x = -1;
		int y = -1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = -1;
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = i; j<n; j++) {
				if(i % 3 == 0) {
					x++;
					y++;
				}else if(i % 3 == 1) {
					y--;
				}else if(i % 3 == 2) {
					x--;
				}
				arr[x][y] = (idx++)%10;
			}
		}
		
		for(int i = 0; i<n ;i++) {
			for(int j = 0; j<i+1; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
