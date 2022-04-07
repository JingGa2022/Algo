package problem.백준.class4;

import java.util.Scanner;

public class N과M4_15652 {
	static int[] box;
	//결과 담는
	static int[] sel;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		sel = new int[M];
		box = new int[N];
		for (int i = 1; i <= N; i++)
			box[i - 1] = i;

		nCr(0,0);
	}// main

	//주석
	static void nCr(int idx, int sidx) {
		if (sidx == M) {
			for(int i = 0; i<M; i++)
				System.out.print(sel[i]+" ");
			System.out.println();
			return;
		}else if(idx == N) return;
		else {
			sel[sidx] = box[idx];
			nCr(idx, sidx+1);
			nCr(idx+1, sidx);
			
		}
	}
}// class
