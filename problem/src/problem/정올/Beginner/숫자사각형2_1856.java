package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자사각형2_1856 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = 1 + i * m;
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					if (j == m - 1)
						sb.append(start + j);
					else
						sb.append(start + j).append(" ");
				}
			} else {
				for (int j = m-1; j >= 0; j--) {
					if (j == 0)
						sb.append(start + j);
					else
						sb.append(start + j).append(" ");
				}

			}
			if (i != n - 1)
				sb.append("\n");
		}
		System.out.println(sb);
	}// main
}
