package problem.백준.class3;

import java.util.Scanner;

public class 연결요소의개수_11724 {
	static boolean[] visited;
	static int[][] arr;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(1);
		int ans = 1;
		for(int i = 1; i<=n; i++) {
			if(visited[i] == true) continue;
			dfs(i);
			ans++;
		}
		System.out.println(ans);
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		if(visited[i] == true) return;
		
			visited[i] = true;
		
		for(int j = 1; j<=n; j++) {
			if(arr[i][j] == 1) {
				dfs(j);
			}
		}
	}
}
