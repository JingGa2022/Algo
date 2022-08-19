package problem.백준.class3;

import java.util.Scanner;

public class 경로찾기_11403 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j =0; j<n; j++) arr[i][j] = sc.nextInt();
		}
		
		for(int k =0; k<n; k++) {
		for(int i = 0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
			}
		}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
