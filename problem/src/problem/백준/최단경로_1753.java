package problem.백준;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}

}

public class 최단경로_1753 {
	static int V,E,K;
	static int u,v,w;
	static int[] dist;
	static ArrayList[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		 V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		
		// 거리배열 초기화
		dist = new int[V+1];
		for(int i = 1; i<=V; i++) dist[i] = Integer.MAX_VALUE;
		
		// 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for(int i = 1; i<=V; i++) adjList[i] = new ArrayList<Node>();
		
		for(int i = 1; i<=E; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			
			adjList[u].add(new Node(v,w));
		}
		
		dijkstra(K);
		for(int i = 1; i<=V; i++){
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else
				sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.weight > dist[node.end]) continue;
			
			// 현재 위치 연결된 간선 탐색
			int len = adjList[node.end].size();
			
			for(int i = 0; i<len; i++) {
				Node next = (Node) adjList[node.end].get(i);
				
				if(dist[next.end] > node.weight + next.weight) {
					dist[next.end] = node.weight + next.weight;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
		
	}
}
