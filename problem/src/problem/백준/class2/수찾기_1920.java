package problem.백준.class2;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기_1920 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		// 확인용
		int[] check = new int[N];

		for (int i = 0; i < N; i++)
			check[i] = sc.nextInt();
		// 이진탐색을 위해 정렬
		Arrays.sort(check);

		M = sc.nextInt();
		// 들었나 봐야할 친구
		int[] num = new int[M];
		for (int i = 0; i < M; i++)
			num[i] = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int bottom = 0;
			int top = N - 1;
			int mid = top / 2;
			boolean flag = false;
			while (bottom <= top) {
				if (check[mid] == num[i]) {
					sb.append(1).append("\n");
					flag = true;
					break;
				} else if (check[mid] < num[i]) {
					bottom = mid + 1;
					mid = (bottom + top) / 2;
				} else if (check[mid] > num[i]) {
					top = mid - 1;
					mid = (bottom + top) / 2;
				}

			}
			if (!flag)
				sb.append(0).append("\n");
		}
		System.out.println(sb);
	}// main
}
