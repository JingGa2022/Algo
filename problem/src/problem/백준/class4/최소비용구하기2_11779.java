package problem.백준.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class 최소비용구하기2_11779 {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost; 
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}
	}
	static int n,m;
	static int INF = 323456789;
	static ArrayList<Node>[] tree;
	static int[] dist, pre;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		tree = new ArrayList[n+1];
		pre = new int[n+1];
		
		for(int i = 1; i<=n; i++) tree[i] = new ArrayList<>();
		
		for(int i = 0; i<m; i++) {
			int a= sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			tree[a].add(new Node(b,c));
		}
		
		
		int from = sc.nextInt();
		int to = sc.nextInt();
		
		Dijkstra(from, to);

		sb.append(dist[to] + "\n");
		
		int cnt = 1;
		Stack<Integer> st = new Stack<>();
		st.add(to);
		while(pre[to] != 0) {
			cnt++;
			st.add(pre[to]);
			to = pre[to];
		}
		sb.append(cnt +"\n");
		
		while(!st.isEmpty()) {
			sb.append(st.pop() + " ");
		}
		System.out.println(sb);
	}
	private static void Dijkstra(int from, int to) {
		// TODO Auto-generated method stub
		dist = new int[n+1];
		boolean[] visit = new boolean[n+1];
		Arrays.fill(dist, INF);
		dist[from] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(from, 0));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(!visit[n.end]) visit[n.end] = true;
			else continue;
			
			for(int j = 0; j<tree[n.end].size(); j++) {
				Node next = tree[n.end].get(j);
					if(dist[next.end] > dist[n.end] + next.cost) {
						dist[next.end] = dist[n.end] + next.cost;
						q.offer(new Node(next.end, dist[next.end]));
						pre[next.end] = n.end;
				}			
			}
		}
		
//		for(int i = 0; i<n; i++) {
//			int nodeNum = INF;
//			int nodeIdx = 0;
//			
//			for(int j = 1; j<=n; j++) {
//				if(!visit[j] && nodeNum > dist[j]) {
//					nodeNum = dist[j];
//					nodeIdx = j;
//				}
//			}
//			visit[nodeIdx] = true;
//			
//			for(int j = 0; j<tree[nodeIdx].size(); j++) {
//				Node n = tree[nodeIdx].get(j);
//					if(dist[n.end] > dist[nodeIdx] + n.cost) {
//						dist[n.end] = dist[nodeIdx] + n.cost;
//						pre[n.end] = nodeIdx;
//				}			
//			}
//		}
	}
}
