package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자사각형3_1304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		
		for(int j = 1; j<=n; j++) {
	
			for(int i = 0; i<n; i++) {
				if(i != n-1)
					System.out.printf("%d ",j+i*n);
				else
					System.out.printf("%d\n",j+i*n);
					
			}
		}
		
	}
}
