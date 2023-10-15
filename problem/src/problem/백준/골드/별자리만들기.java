package problem.백준.골드;

import java.util.*;

public class 별자리만들기 {
	static class Edge implements Comparable<Edge>{
		int start, end;
		double cost;
		
		public Edge(int start, int end, double cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			if(this.cost < e.cost) return -1;
			return 1;
		}
	}
	public static class Node{
		int num;
		double x, y;
		
		Node(int num, double x, double y){
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	/* 1. 최소 스패닝 트리의 활용
	 * 2. 크루스칼 활용
	 */
	static ArrayList<Node> starList = new ArrayList<>();
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int[] parent;
	static PriorityQueue<Edge>q = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i<n; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			starList.add(new Node(i, x,y));
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				double tmp = Math.pow(starList.get(i).x - starList.get(j).x, 2) - Math.pow(starList.get(i).y - starList.get(j).y, 2);
				double dist = Math.sqrt(tmp);
				q.add(new Edge(i, j, dist));
						
			}
		}
		
		parent = new int[starList.size()];
		double ans = kruskal();
		System.out.println(ans);
	}
	static double kruskal() {
		for(int i = 0; i<starList.size(); i++) parent[i] = i;
		
		double dist = 0;
		
		while(!q.isEmpty()) {
			Edge now = q.poll();
			
			int p1 = find(now.start);
			int p2 = find(now.end);
			
			if(p1 != p2) {
				union(p1, p2);
				dist += now.cost;
			}
		}
		return dist;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		parent[a] = b;
	}
}
