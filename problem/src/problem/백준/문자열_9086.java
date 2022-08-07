package problem.백준;

import java.util.Scanner;

public class 문자열_9086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String s = sc.next();
			sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append("\n");
		}
		System.out.println(sb);
	}
}
