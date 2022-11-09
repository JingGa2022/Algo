package problem.백준.class4;

import java.util.Scanner;

public class 거짓말_1043 {
	static int n,m;
	static boolean[] man;
	static boolean[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int ans = 0;

		man = new boolean[n + 1];
		tree = new boolean[n + 1][n + 1];
		int[][] party = new int[m][];

		int whoKnowNum = sc.nextInt();

		for (int i = 0; i < whoKnowNum; i++) {
			man[sc.nextInt()] = true;
		}

		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();
			party[i] = new int[num];
			
			party[i][0] = sc.nextInt();
			
			for (int j = 1; j < num; j++) {
				party[i][j] = sc.nextInt();
				int prev = party[i][j-1];
				int post = party[i][j];
				tree[prev][post] = tree[post][prev] = true;
			}

		}
		for(int i = 1; i<=n; i++) {
			if(man[i]) dfs(i);
		}

		for (int i = 0; i < m; i++) {
			boolean flag = false;
			for (int j = 0; j < party[i].length; j++) {
				if (man[party[i][j]])
					flag = true;
			}
			if (!flag)
				ans++;
		}
		System.out.println(ans);
	}
	private static void dfs(int a) {
		for(int i = 1; i<=n; i++) {
			if(tree[a][i] && !man[i]) {
				man[i] = true;
				dfs(i);
			}
		}
	}
}
