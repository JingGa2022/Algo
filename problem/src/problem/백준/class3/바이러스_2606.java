package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_2606 {

	static boolean[] visited;
	static int ans, n, m;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();// 노드의 수
		m = sc.nextInt();// 관계의 수

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		ans = 0;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}

		DFS(1);
		//BFS(1);

		System.out.println(ans);
	} // main

	private static void DFS(int a) {
		visited[a] = true;

		for (int i = 1; i <= n; i++) {
			if (arr[a][i] == 1 && visited[i] == false) {
				ans++;
				DFS(i);
			}
		}
	}

	private static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int j = 1; j<n; j++) {
				if(!visited[j] && arr[tmp][j] ==1) {
					visited[j] = true;
					q.add(j);
					ans++;
				}
			}
		}
	}
}
