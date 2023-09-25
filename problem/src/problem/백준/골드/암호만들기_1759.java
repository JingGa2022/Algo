package problem.백준.골드;

import java.util.*;

public class 암호만들기_1759 {
	/*
	 * 1. 문자를 우선순위 큐에다 넣자 2. 순서대로 뽑 안뽑해서 다 뽑으면 됨
	 * 
	 */
	static int l, c;
	static int[] pick, arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		c = sc.nextInt();
		pick = new int[l + 1];
		arr = new int[c];
		for (int i = 0; i < c; i++) {
			arr[i] = sc.next().charAt(0) - 'a';
		}
		Arrays.sort(arr);
		solve(0, 0);

		System.out.println(sb);
	}

	static void solve(int dept, int start) {
		if (dept == l) {
			int check = 0;
			for (int i = 0; i < l; i++) {
				char tmp = (char) ('a' + pick[i]);
				if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u')
					check++;
			}

			if (check >= 1 && l - check >= 2) {
				for (int i = 0; i < l; i++) {
					char tmp = (char) ('a' + pick[i]);
					sb.append(tmp);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < c; i++) {
			pick[dept] = arr[i];
			solve(dept + 1, i + 1);
		}
	}
}
