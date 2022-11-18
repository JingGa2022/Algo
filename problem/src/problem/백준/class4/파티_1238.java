package problem.백준.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 파티_1238 {
	static class Node{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}
	}
	static int n, m, x, ans; // n : 학생의 수 m : 도로의 수 x : 모이고자 하는 마을 
	final static int INF = 234567890;
	static ArrayList<Node>[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		
		tree = new ArrayList[n+1];
		
		for(int i = 0; i<=n; i++) tree[i] = new ArrayList<>();
		
		for(int i = 1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			tree[a].add(new Node(b, c));
		}
		
		for(int i = 1; i<=n; i++) {
			int let = 0;
			let += Dijkstra(i, x);
			let += Dijkstra(x, i);
			ans = Math.max(ans, let);
		}
		System.out.println(ans);
	}
	private static int Dijkstra(int start, int end) {
		// TODO Auto-generated method stub
		int[] dist = new int[n+1];
		boolean[] visit = new boolean[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		for(int i = 0; i<n; i++) {
			int node = INF;
			int nodeIdx = 0;
			
			for(int j = 1; j<=n; j++) {
				if(!visit[j] && dist[j] < node) {
					node = dist[j];
					nodeIdx = j;
				}
			}
			
			visit[nodeIdx] = true;
			
			for(Node n : tree[nodeIdx]) {
				if(dist[n.end] > dist[nodeIdx] + n.cost) dist[n.end] = dist[nodeIdx] + n.cost;
			}
		}
		return dist[end];
	}
}
