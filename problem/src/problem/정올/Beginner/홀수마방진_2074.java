package problem.정올.Beginner;

import java.util.Scanner;

public class 홀수마방진_2074 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		
		int x = 1;
		int y = (n+1)/2;
		for(int i = 1; i<n*n; i++) {
			if(i == 1) arr[x][y] = i;
			
			if(i % n == 0) {
				x++;
				x = restore(x);
			}else {
				x--;
				x = restore(x);
				y--;
				y = restore(y);
			}
			arr[x][y] = i+1;
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n ;j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}//main

	private static int restore(int x) {
		if(x>n) {
			x = 1;
		}
		
		else if( x<1 ) {
			x = n;
		}
		return x;
		// TODO Auto-generated method stub
		
	}
	
}
