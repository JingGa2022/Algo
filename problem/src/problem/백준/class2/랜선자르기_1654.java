package problem.백준.class2;

import java.util.Scanner;

public class 랜선자르기_1654 {
	static int K, N, t, b, max;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		N = sc.nextInt();
		t = 0;
		b = 0;

		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (t < arr[i])
				t = arr[i];
		}

		while (b <= t) {
			int mid = (t + b) / 2;
			if (isMax(mid) >= N) {
				b = mid+1;
			}else
				t = mid;
		}
		
		System.out.println(max);
	}// main

	static Integer isMax(int m) {
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i] / m;
		}
		if(sum==N && max < m) {
			max = m;
		}
		return sum;
	}
}
