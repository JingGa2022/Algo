package problem.백준.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최소비용구하기_1916 {
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this. to = to;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static List<Node>[] list;
	static int[] dp;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		list = new ArrayList[n+1];
		dp = new int[n+1];
		check = new boolean[n+1];
		
		for(int i = 1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			list[from].add(new Node(to, cost));
		}
		
		dijkstra(sc.nextInt());
		System.out.println(dp[sc.nextInt()]);
	}
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		q.add(new Node(start,0));
		dp[start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int from = node.to;
			
			if(check[from]) continue;
			
			check[from] = true;
			
			for(Node next: list[from]) {
				if(dp[next.to] >= dp[from] + next.cost) {
					dp[next.to] = dp[from] + next.cost;
					q.add(new Node(next.to, dp[next.to]));
				}
			}
		}
	}
}

