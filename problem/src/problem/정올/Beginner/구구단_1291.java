package problem.정올.Beginner;

import java.util.Scanner;

public class 구구단_1291 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int e = sc.nextInt();

		while (s > 9 || s < 2 || e > 9 || e < 2) {
			System.out.println("INPUT ERROR!");
			s = sc.nextInt();
			e = sc.nextInt();
		}
		if (s > e) {
			for (int i = 1; i <= 9; i++) {
				for (int tc = 0; tc <= s - e; tc++) {
					int gugu = s - tc;
					if(tc == s - e)
					System.out.printf("%d * %d = %2d", gugu, i, gugu * i);
					else
					System.out.printf("%d * %d = %2d   ", gugu, i, gugu * i);
				}
				if(i<9)
					System.out.println();
			}
		} else if(e > s) {
			for (int i = 1; i <= 9; i++) {
				for (int tc = 0; tc <= e-s; tc++) {
					int gugu = s + tc;
					if(tc == e - s)
					System.out.printf("%d * %d = %2d", gugu, i, gugu * i);
					else
					System.out.printf("%d * %d = %2d   ", gugu, i, gugu * i);
				}
				if(i<9)
					System.out.println();
			}
		}else if(e == s) {
			for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %2d   ",s , i, s * i);
					if(i<9)
						System.out.println();
				}
			}
		}

	}// main
