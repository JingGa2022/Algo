package problem.백준;

import java.util.Scanner;

public class 두수의합_3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		boolean[] sum = new boolean[2000001];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum[arr[i]] = true;
		}

		int x = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int tmp = 0;
			if (arr[i] <= x) {

				tmp = x - arr[i];
				if (sum[tmp])
					ans++;
			}
		}
		System.out.println(ans / 2);
	}
}
