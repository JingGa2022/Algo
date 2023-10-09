package problem.백준.실버;

import java.util.Scanner;

public class 회전초밥_2531 {
	/*
	 * 1. 투포인터를 활용해 1부터 k번 까지 순차적으로 해보기 2. 최대의 개수 구하기
	 */
	static int n, d, k, c, arr[], visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		d = sc.nextInt(); // 초밥 종류 수
		k = sc.nextInt(); // 연속 접시수
		c = sc.nextInt(); // 쿠폰 번호

		arr = new int[n];
		visit = new int[d + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(slide());
	}

	static int slide() {
		int total = 0, max = 0;
		for (int i = 0; i < k; i++) {
			if (visit[arr[i]] == 0)
				total++;
			visit[arr[i]]++;
		}
		max = total;

		for (int i = 1; i < n; i++) {
			if (max <= total) {
				if (visit[c] == 0)
					max = total + 1;
				else
					max = total;
			}
			
			int end = (i + k - 1) % n;
			// 투포인트로 왼쪽 부분 제거
			visit[arr[i - 1]]--;
			if (visit[arr[i - 1]] == 0)
				total--;

			// 오른쪽 포인트가 n넘어갈 경우 커버
			if (visit[arr[end]] == 0)
				total++;
			visit[arr[end]]++;
		}

		return max;
	}
}
