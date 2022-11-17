package problem.백준.class4;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 특정한최단경로_1504 {
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
    static int n,e, point1, point2, ans;
    final static int INF = 207654321;
    static ArrayList<Node>[] road;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        e = sc.nextInt();
        road = new ArrayList[n+1];
        ans = -1;

        for(int i = 0; i <= n; i++) road[i] = new ArrayList<>();

        for(int i = 0; i<e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            road[from].add(new Node(to, cost));
            road[to].add(new Node(from, cost));
        }
        point1 = sc.nextInt();
        point2 = sc.nextInt();
        
        int res1 = 0;
        res1 += Dijkstra(1, point1);
        res1 += Dijkstra(point1, point2);
        res1 += Dijkstra(point2, n);
        
        int res2 = 0;
        res2 += Dijkstra(1, point2);
        res2 += Dijkstra(point2, point1);
        res2 += Dijkstra(point1, n);

        ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    private static int Dijkstra(int start, int end) {
        int[] dist = new int[n+1];
        boolean[] prev = new boolean[n+1];
        for(int i = 0; i<=n; i++) dist[i] = INF;
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	int cur = node.end;
        	
        	if(!prev[cur]) {
        		prev[cur] = true;
        		
        		for(Node n : road[cur]) {
        			if(!prev[n.end] && dist[n.end] > dist[cur] + n.cost) {
        				dist[n.end] = dist[cur] + n.cost;
        				pq.add(new Node(n.end, dist[n.end]));
        			}
        		}
        	}
        }
       
        return dist[end];
    }
}
