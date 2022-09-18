package problem.백준;

import java.util.Scanner;

public class N과M3_15651 {
	static int n, m;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		sel = new int[n];

		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int dept) {
	if (dept == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			sel[dept] = i;
			dfs(dept + 1);
		}
	}
}
