package problem.APS심화;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서_SW문제해결응용 {
	static int V, E;
	static int[][] adj;//인접행렬
	static int[] degree;//진입차수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			StringBuilder sb = new StringBuilder();
			V = sc.nextInt();
			E = sc.nextInt();
			
			adj = new int[V+1][V+1];
			degree = new int[V+1];
			
			for(int i =0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				
				adj[st][ed] = 1;
				degree[ed]++;
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i =1; i<=V; i++) {
				if(degree[i]==0) q.add(i);
			}
			sb.append("#").append(tc).append(" ");
			
			while(!q.isEmpty()) {
				int node = q.poll();
				sb.append(node).append(" ");
				for(int i = 1; i<=V; i++) {
					if(adj[node][i]==1) {
						degree[i]--;
						if(degree[i] == 0) q.add(i);
					}
				}
			}
			System.out.println(sb);
			
		}//tc
	}//main
	
}//class
