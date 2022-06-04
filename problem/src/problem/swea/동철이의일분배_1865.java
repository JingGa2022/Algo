package problem.swea;

import java.util.Arrays;
import java.util.Scanner;

public class 동철이의일분배_1865 {
	static int N;
	static double max;
	static double[][] arr;
	static int[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			check = new int[N];
			arr = new double[N][N];
			max = 0;
			
			for(int i = 0; i<N; i ++) {
				for(int j = 0; j<N; j++) {
					arr[i][j] = sc.nextDouble()/100;
				}
			}
			
			tree(0,1);
			
			System.out.println("#"+tc+" "+String.format("%.6f", max * 100));

		}

	}//main
	
	static private void tree (int a, double gop) {
			if(max >= gop) return;
		
			if(a == N) {
				if(max<gop) max = gop;
				return;
			}
			
			for(int i = 0; i<N; i++) {
				if(check[i]==1) continue;
				check[i] = 1;
				tree(a+1, gop * arr[a][i]);
				check[i] = 0;
			}
	}
}
