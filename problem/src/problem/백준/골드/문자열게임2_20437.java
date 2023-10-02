package problem.백준.골드;

import java.util.*;

public class 문자열게임2_20437 {
	/*
	 * 1. 투 포인터로 제일 짧은 문자열 구하고 2. 제일 긴것 구해서 비교 없다면 -1
	 */
	static String w;
	static int k;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int T = 0; T < t; T++) {
			w = sc.next();
			k = sc.nextInt();
			solve();
		}
		System.out.println(sb);
	}

	private static void solve() {
		int len = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		if(k == 1) {
			sb.append(1 + " " + 1);
			sb.append("\n");
			return;
		}

		for (int i = 0; i < w.length(); i++) {
			int s = i;
			int e = i + 1;
			int cnt = 1;
			len = 0;
			while (e < w.length()) {
				len = e - s + 1;
				if (w.charAt(s) == w.charAt(e)) {
					cnt++;
					if (cnt == k) {
						min = Math.min(len, min);
						max = Math.max(len, max);
					}
				}
				e++;
			}
		}
		if (min != Integer.MAX_VALUE) {
			sb.append(min + " " + max);
		} else
			sb.append(-1);
		sb.append("\n");
	}
}
