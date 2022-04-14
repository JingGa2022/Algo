package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요리사_모의SW역량테스트 {
	static int N, ans;
	static int[][] ingre;//
	static int[] food;//
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			N = sc.nextInt();
			food = new int[N*(N-1)/2];
			food = new int[N];
			ingre = new int[N][N];
			ans = Integer.MAX_VALUE;
			sel = new int[2];
			
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++) ingre[i][j] = sc.nextInt();
			}
			
			for(int i = 0; i<N; i++) food[i] = i;
			int idx = 0;
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(ingre[i][j] == 0) {
						i++;
						j = -1;
						if(i==N) break;
					}else {
						food[idx++] += ingre[i][j] + ingre[j][i];}
				}
			}
			comb(0,0);
			
			System.out.println(ans);
			
		}//tc
	}//main
	static void comb (int idx, int sidx) {
		if(sidx == 2) {
			System.out.println(Arrays.toString(sel));
			int min = Math.abs(sel[0] - sel[1]);
			if(min != 0 && ans>min) {ans = min;
			
			}
			return;
		}
		for(int i = idx; i<=N - 2+sidx; i++) {
			sel[sidx] = food[i];
			comb(i+1, sidx+1); 
		}
	}
}//class
