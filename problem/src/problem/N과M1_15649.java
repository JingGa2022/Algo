package problem;

import java.util.Scanner;

public class N과M1_15649 {
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		visit = new boolean[n];

		
		dfs(n, m, 0);
	}
	private static void dfs(int n, int m, int dep) {
		// TODO Auto-generated method stub
		if(dep == m) {
			for(int val : arr)
				System.out.print(val+" ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[dep] = i + 1;
				dfs(n, m, dep + 1);
				visit[i] = false;
			}
		}
		
	}
}
