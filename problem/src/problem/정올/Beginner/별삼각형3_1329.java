package problem.정올.Beginner;

import java.util.Scanner;

public class 별삼각형3_1329 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n < 1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		} else {
			for (int i = 0; i < n; i++) {
				if (i <= n / 2) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < i * 2 + 1; j++) {
						System.out.print("*");
					}
				} else {
					for (int j = 0; j < n - i - 1; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (n - i - 1) * 2 + 1; j++) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
	}
}
