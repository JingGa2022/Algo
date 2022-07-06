package problem.백준.class3;

import java.util.Scanner;

public class 계단오르기_2579_2 {
	static int n;
	static int[] arr;
	static Integer[] score;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		arr = new int[n+1];
		score = new Integer[n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		score[0] = arr[0];
		score[1] = arr[1];
		
		if(n>= 2) score[2] = arr[1] + arr[2];
		
		System.out.println(stair(n));
	}
	private static int stair(int n) {
		if(score[n] == null) {
			score[n] = Math.max(stair(n-2), stair(n-3) + arr[n-1]) + arr[n];
		}
		
		return score[n]; 
	}
}
