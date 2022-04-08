package problem.수업;

import java.util.Scanner;

public class 벌꿀채취_모의테스트 {
	static class Honey {
		int cost, r, c;

		public Honey(int cost, int r, int c) {
			super();
			this.cost = cost;
			this.r = r;
			this.c = c;
		}

	}

	static int N, M, C;
	static int[][] arr;
	static Honey first, second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++)
			N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		}

		first = new Honey(0, 0, 0);
		second = new Honey(0, 0, 0);
		// 벌통을 뽑아보자
		for (int i = 0; i < N; i++) {
			// 열의 채취 범위를 생각을 해야함
			for (int j = 0; j < N - M + 1; j++)
				harvest(i, j);
		}

		System.out.println(first +" "+ second);
	}// main

	private static void harvest(int r, int c) {
		int maxCost = 0;// 이번차례 벌통 최대값

		int[] tmp = new int[M];
		for (int i = 0; i < M; i++)
			tmp[i] = arr[r][c + i];

		// powerset구하기
		for (int i = 0; i < (1 << M); i++) {
			int sumHoney = 0;
			int sumCost = 0;

			for (int j = 0; j < M; j++) {
				if ((i & 1 << j) != 0) {
					sumHoney += tmp[j];
					sumCost += tmp[j] * tmp[j];
				}
			}
			// i번째 부분집합의 값을 계산
			if (sumHoney <= C)
				maxCost = Math.max(maxCost, sumCost);
		}

		// 이번 벌통의 최고 값

		// 이번차례 최고의 값이 first의 수익보다 더 많아
		if (maxCost > first.cost) {
			// 겹치는경우
			if (r == first.r && c < first.c + M) {
				first = new Honey(maxCost, r, c);
			}
			// 안겹치는 경우
			else {
				second = first;
				first = new Honey(maxCost, r, c);
			}
		} else if (maxCost > second.cost) {
			if (r != first.r || c >= first.c + M)
				second = new Honey(maxCost, r, c);
		}
	}
}
