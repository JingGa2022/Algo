package problem.백준.실버;

import java.util.Scanner;

public class 오르막수_11057 {
	/* 1. DP문제에서는 점화식을 구해야한다.
	 * 2. 맨 앞자리 수의 값부터 전단계 9까지의 개수의 합이다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n+1][10];
		
		for(int i = 0; i<10; i++) arr[0][i] = 1;
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 0; j<10; j++) {
				for(int k = j; k<10; k++) {
					arr[i][j] += arr[i-1][k];
					arr[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(arr[n][0]);
	}
}
