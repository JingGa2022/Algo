package problem.정올.Beginner;

import java.util.Scanner;

public class 구구단2_1341 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int e = sc.nextInt();

		if (s > e) {
			for (int a = s; a >= e; a--) {
				for (int i = 1; i <= 7; i += 3) {
					for (int j = 0; j < 3; j++) {
						int idx = i + j;
						if (j != 2)
							System.out.printf("%d * %d = %2d   ", a, idx, a * idx);
						else
							System.out.printf("%d * %d = %2d\n", a, idx, a * idx);
					}
				}
				if(a != e)
					System.out.println();
			}
		}
		else if(e > s){
			for (int a = s; a <= e; a++) {
				for (int i = 1; i <= 7; i += 3) {
					for (int j = 0; j < 3; j++) {
						int idx = i + j;
						if (j != 2)
							System.out.printf("%d * %d = %2d   ", a, idx, a * idx);
						else
							System.out.printf("%d * %d = %2d\n", a, idx, a * idx);
					}
				}
				if(a != e)
					System.out.println();
			}
		}
		else if(e == s){
				for (int i = 1; i <= 7; i += 3) {
					for (int j = 0; j < 3; j++) {
						int idx = i + j;
						if (j != 2)
							System.out.printf("%d * %d = %2d   ", e, idx, e * idx);
						else
							System.out.printf("%d * %d = %2d\n", e, idx, e * idx);
					}
			}
		}
	}//main
}
