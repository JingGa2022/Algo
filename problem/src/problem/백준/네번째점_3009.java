package problem.백준;

import java.util.Scanner;

public class 네번째점_3009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr1 = new int[1001];
		int[] arr2 = new int[1001];

		int max = 0;
		int min = 1001;

		for (int i = 0; i < 3; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			max = Math.max(b, Math.max(max, a));
			min = Math.min(b, Math.min(min, a));
			arr1[a]++;
			arr2[b]++;

		}

		for (int i = min; i <= max; i++) {
			if (arr1[i] == 1) {
				System.out.print(i + " ");
				break;
			}
		}
		for (int i = min; i <= max; i++) {
			if (arr2[i] == 1) {
				System.out.println(i);
				break;
			}

		}

	}
}
