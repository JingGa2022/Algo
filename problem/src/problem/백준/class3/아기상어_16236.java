package problem.백준.class3;

import java.util.Scanner;

public class 아기상어_16236 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) arr[i][j] = sc.nextInt();
		}
		
	}
}
