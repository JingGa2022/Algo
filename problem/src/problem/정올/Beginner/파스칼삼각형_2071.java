package problem.정올.Beginner;

import java.util.Scanner;

public class 파스칼삼각형_2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		
		for(int i = 0; i<n ;i++) {
			for(int j = 0; j< n; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = 2; i<n ;i++) {
			for(int j = 1; j< i; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		switch (m) {
		case 1:
			for(int i = 0; i<n ;i++) {
				for(int j = 0; j<= i; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			break;

		case 2:
			for(int i = n-1; i>=0 ;i--) {
				for(int j = 0; j < n - i -1; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i+1; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			break;
			
		case 3:
			for(int i = n-1; i>=0 ;i--) {
				for(int j = n-1; j>= i; j--) {
					System.out.print(arr[j][i]+" ");
				}
				System.out.println();
			}
			break;
		}
		
	}
}
