package problem.백준.class4;

import java.util.Scanner;

public class RGB거리_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N+1][3];
		
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<3; j++) {
				// 0: R cost, 1: G cost, 2: B cost
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 2; i<=N; i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][1], arr[i-1][0]);
		}
		System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));
	}
}
