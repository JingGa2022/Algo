package problem.백준.실버;

import java.util.*;

public class 촌수계산_2644 {
	// 그래프를 만들고 BFS로 계산
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		n = sc.nextInt();// 노드 수
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int m = sc.nextInt();// 관계 수

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		System.out.println(BFS(graph, p1, p2));
	}

	static int BFS(ArrayList<ArrayList<Integer>> graph, int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		int cnt = 0;
		
		int[] visited = new int[n+1];
		
		while(!q.isEmpty()) {
			int tmp = q.poll();

			if(tmp == e) return visited[tmp];
			
			for(int next : graph.get(tmp)) {
				if(visited[next] == 0) {
					visited[next] = visited[tmp] + 1;
					q.add(next);
				}
			}
		}
		return -1;
	}
}
