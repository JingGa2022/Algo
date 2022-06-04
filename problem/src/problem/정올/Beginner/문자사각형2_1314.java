package problem.정올.Beginner;

import java.util.Scanner;

public class 문자사각형2_1314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] arr = new char[n][n];


		int ch = 65;
		for (int j = 0; j < n; j++) {
			if (j % 2 != 0) {
					for (int i = n - 1; i >= 0; i--) {
					if (ch > 90)
						ch = 65;

					arr[i][j] = (char) ch;

					ch++;
				}
			} else {
					for (int i = 0; i < n; i++) {
						if (ch > 90)
							ch = 65;

					arr[i][j] = (char) ch;

					ch++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%c ", arr[i][j]);
			}
			System.out.println();
		}
	} // main
}
