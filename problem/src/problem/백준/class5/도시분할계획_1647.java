package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획_1647 {
	static class Edge implements Comparable<Edge>{
        int x;
        int cost;

        public Edge(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    private static void prim(int start){
        boolean[] visit = new boolean[n+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int max = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.x;
            int cost = edge.cost;

            if(visit[v]) continue;

            visit[v] = true;
            max = Math.max(cost, max);
            ans += cost;

            for(Edge e : graph[v]){
                if(!visit[e.x])
                    pq.add(e);
            }
        }
        ans -= max;
    }
    static int n, m, ans;
    static ArrayList<Edge> graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i = 0; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Edge(w, cost));
            graph[w].add(new Edge(v, cost));
        }

        prim(1);

        System.out.println(ans);
    }
}
