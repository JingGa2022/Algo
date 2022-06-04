package problem.정올.Beginner;

import java.util.Scanner;

public class 문자삼각형1_1338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[][] arr = new char[N][N];
		
		char alpha = 'A';
		for(int i = 0; i<N; i++) {
			for(int j = i, k = N-1; j <N; j++, k--) {
				arr[j][k] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
		}
		
		for(int i = 0; i<N; i ++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j]<'A') System.out.print("  ");
				else if(j == N-1) System.out.printf("%c",arr[i][j]);
				else if(j != N-1) System.out.printf("%c ",arr[i][j]);
			}
			System.out.println();
		}
	}
}
