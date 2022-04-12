package problem.수업;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 벌꿀채취_모의테스트_우선순위큐 {
	static class Honey implements Comparable<Honey> {
		int cost, r, c;

		public Honey(int cost, int r, int c) {
			super();
			this.cost = cost;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Honey o) {
			return o.cost - this.cost;
		}

	}

	static int N, M, C;
	static int[][] arr;
	static Honey first, second;
	static int[] tmp;
	static int maxCost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();

		arr = new int[N][N];
		tmp = new int[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		}

		PriorityQueue<Honey> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			// 열의 채취 범위를 생각을 해야함
			for (int j = 0; j < N - M + 1; j++) {
				for (int k = 0; k < M; k++)
					tmp[k] = arr[i][j + k];

				maxCost = 0;
				harvest(0, 0, 0);
				pq.add(new Honey(maxCost, i, j));
			}
		}

		first = pq.poll();
		while (!pq.isEmpty()) {
			second = pq.poll();
			if (second.r != first.r || first.c - M >= second.c || first.c + M <= second.c)
				break;
		}

		System.out.println("#"+tc+" "+ (first.cost + second.cost));
		}
	}// main

	// sumHoney 중간 꿀의 합, sumCost 중간 수익의 합
	private static void harvest(int idx, int sumHoney, int sumCost) {
		if (sumHoney > C)
			return;

		maxCost = Math.max(maxCost, sumCost);

		for (int i = idx; i < M; i++) {
			harvest(i + 1, sumHoney + tmp[i], sumCost + (tmp[i] * tmp[i]));
		}
	}// harvest
}// class
