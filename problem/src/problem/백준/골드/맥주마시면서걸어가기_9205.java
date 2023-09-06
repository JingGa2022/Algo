package problem.백준.골드;

import java.util.*;

public class 맥주마시면서걸어가기_9205 {
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	/* 1. 먼저 1000거리내의 노드를 그래프로 모두 연결
	 * 2. bfs로 1(집)부터 n+2(페스티발) 노드까지 가는게 가능한지 확인
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		ArrayList<Node> map;
		ArrayList<ArrayList<Integer>> graph;
		for(int t = 0; t<T; t++) {
			int n = sc.nextInt();
			
			 map = new ArrayList<>();
			 graph = new ArrayList<>();
			 for(int i = 0; i<n+2; i++) {
				 int a = sc.nextInt();
				 int b = sc.nextInt();
				 map.add(new Node(a,b));
				 graph.add(new ArrayList<>());
			 }
			 
			 for(int i = 0; i<n+2; i++) {
				 for(int j = i+1; j<n+2; j++) {
					 if(Man(map.get(i), map.get(j)) <= 1000) {
						 graph.get(i).add(j);
						 graph.get(j).add(i);
					 }
				 }
			 }
			 
			 sb.append((BFS(graph, n) ? "happy" : "sad") + "\n");
		}
		System.out.println(sb);
	}
	private static boolean BFS(ArrayList<ArrayList<Integer>> graph, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		boolean[] visited = new boolean[n+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == n+1) {
				return true;
			}
			
			for(int next: graph.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return false;
	}
	private static int Man(Node n1, Node n2) {
		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
	}
}
