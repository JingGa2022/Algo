package problem.정올.Beginner;

import java.util.Scanner;

public class 문자삼각형2_1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n <1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
		}
		else {
		char[][] arr = new char[n][n];
		
		char alpha = 'A';
		
		for(int i = n/2; i>=0; i--) {
			for(int j = i; j<n-i ;j++) {
				arr[j][i] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] < 'A') System.out.print("  ");
				else if(j == n-1) System.out.printf("%c", arr[i][j]);
				else if(j != n-1) System.out.printf("%c ", arr[i][j]);
			}
			System.out.println();
		}
		}
	}
}
