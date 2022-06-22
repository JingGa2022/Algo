package problem.정올.Beginner;

import java.util.Scanner;

public class 문자마름모_1331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[2*n-1][2*n-1];
		
		int x = -1;
		int y = n;
		int m = n;
		char alpha = 'A';
		
		while(m >0) {
			
			for(int i = 0; i<m; i++) {
				x++;
				y--;
				arr[x][y] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			if(m==n) {
				m--;
			}
			for(int i = 0; i<m; i++) {
				x++;
				y++;
				arr[x][y] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			for(int i = 0; i<m; i++) {
				x--;
				y++;
				arr[x][y] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			m--;
			for(int i = 0; i<m; i++) {
				x--;
				y--;
				arr[x][y] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			y--;
			arr[x][y] = alpha++;
			if(alpha > 'Z') alpha = 'A';
		}
		for(int i = 0; i<2*n-1; i++) {
			for(int j = 0; j<2*n-1; j++) {
				if(arr[i][j] != 0)
					System.out.print((char)arr[i][j] + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
