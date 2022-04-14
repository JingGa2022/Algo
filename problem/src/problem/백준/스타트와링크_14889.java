package problem.백준;

import java.util.Scanner;

public class 스타트와링크_14889 {
	static int[] A, B;
	static int[][] ingre;
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 재료 N/2개를 뽑아야 되니까
	
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

			System.out.println(ans);

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
}
