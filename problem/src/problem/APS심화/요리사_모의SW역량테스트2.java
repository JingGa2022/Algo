package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요리사_모의SW역량테스트2 {
	static int[] A, B;
	static int[][] ingre;
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 재료 N/2개를 뽑아야 되니까
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ingre = new int[N][N];
			ans = Integer.MAX_VALUE;

			A = new int[N / 2];
			B = new int[N / 2];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					ingre[i][j] = sc.nextInt();
			}
			comb(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}// main

	static void comb(int idx, int sidx) {
		if (idx == N / 2) {
			
			boolean[] check = new boolean[N];
			
			for (int i = 0; i < A.length; i++) {				
				check[A[i]] = true;
			} 
				// A뽑고 남은 재료들을 B에 넣어 줄꺼니까
			int Idx = 0;
			for (int i = 0; i <N; i++) {
				if (!check[i])
					B[Idx++] = i;
			}
			
			int gap = Math.abs(cal(A) - cal(B));
			ans = Math.min(ans, gap);
			return;
		}

		for (int i = sidx; i < N; i++) {
			A[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	static int cal(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			for (int j : arr) {
				sum += ingre[i][j];
			}
		}
		return sum;
	}
}// class
