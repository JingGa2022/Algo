package problem.백준.실버;

import java.util.*;

public class N과M11_15665 {
	/*
	 * 1. m개 수열 뽑기 2. 여러번 골라도 됨
	 */
	static int n, m;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[] pick;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		pick = new int[m];
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (isUniq(tmp))
				arr.add(tmp);
		}

		Collections.sort(arr);

		solve(0);

		System.out.println(sb);
	}

	private static boolean isUniq(int tmp) {
		// TODO Auto-generated method stub
		for (int num : arr) {
			if (tmp == num)
				return false;
		}
		return true;
	}

	static void solve(int dept) {
		if (dept == m) {
			for (int i = 0; i < m; i++)
				sb.append(pick[i] + " ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			pick[dept] = arr.get(i);
			solve(dept + 1);
		}
	}
}
