package problem.백준.class4;

import java.util.Scanner;

public class 내려가기_2096 {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][3];
		int[][] dpB = new int[n+1][3];
		int[][] dpS = new int[n+1][3];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i<=n; i++) {
			dpB[i][0] = Math.max(dpB[i-1][0], dpB[i-1][1]) + arr[i][0];
			dpB[i][1] = Math.max(Math.max(dpB[i-1][0], dpB[i-1][1]), dpB[i-1][2])+ arr[i][1];
			dpB[i][2] = Math.max(dpB[i-1][1], dpB[i-1][2]) + arr[i][2];
			
			dpS[i][0] = Math.min(dpS[i-1][0], dpS[i-1][1]) + arr[i][0];
			dpS[i][1] = Math.min(Math.min(dpS[i-1][0], dpS[i-1][1]), dpS[i-1][2]) + arr[i][1];
			dpS[i][2] = Math.min(dpS[i-1][1], dpS[i-1][2]) + arr[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<3; i++) {
			min = Math.min(min, dpS[n][i]);
			max = Math.max(max, dpB[n][i]);
		}
		System.out.println(max + " " + min);
	}
}
