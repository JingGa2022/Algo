package problem.백준.class3;

import java.util.Scanner;

public class 리모컨_1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();// 목표 채널
		int m = sc.nextInt();// 고장난 버튼 수

		boolean[] btn = new boolean[10];

		for (int i = 0; i < m; i++) {
			btn[sc.nextInt()] = true;
		}

		int result = Math.abs(n - 100);
		for (int i = 0; i <= 999999; i++) {
			String s = Integer.toString(i);
			int len = s.length();

			boolean isWorking = false;
			for (int j = 0; j < len; j++) {
				if (btn[s.charAt(j) - '0']) {
					isWorking = true;
					break;
				}
			}
			if (!isWorking) {
				int min = Math.abs(n - i) + len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
