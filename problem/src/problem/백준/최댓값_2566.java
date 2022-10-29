package problem.백준;

import java.util.Scanner;

public class 최댓값_2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[9][9];
		int x = 0;
		int y = 0;
		int max = 0;
		
		for(int i = 0 ; i<9; i++) {
			for(int j=0; j<9; j++) {
				arr[i][j] = sc.nextInt();
				if(max <= arr[i][j]) {
					max = arr[i][j];
					x = i + 1;
					y = j + 1;
				}
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", x, y);
	}
}
