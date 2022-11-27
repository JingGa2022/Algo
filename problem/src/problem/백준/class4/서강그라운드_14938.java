package problem.백준.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 서강그라운드_14938 {
	static class Spot{
        int x;
        int cost;
        public Spot(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }
    static int n,m,r,ans;
    final static int INF = 987654321;
    static int[] item;
    static ArrayList<Spot>[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

       item = new int[n+1];
        tree = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            tree[i] = new ArrayList<>();
            item[i] = sc.nextInt();
        }
        for(int i = 0; i<r; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            tree[a].add(new Spot(b, c));
            tree[b].add(new Spot(a, c));
        }

        for (int i = 1; i<=n; i++)
            dijkstra(i);

        System.out.println(ans);
    }

    private static void dijkstra(int start) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, INF);
        boolean[] visit = new boolean[n+1];
        dist[start] = 0;
        int cnt = 0;

        for(int i = 0; i<n; i++){
            int numV = INF;
            int numI = 0;

            for(int j = 1; j<=n; j++){
                if(!visit[j] && dist[j] < numV){
                    numV = dist[j];
                    numI = j;
                }
            }
            visit[numI] = true;
            if(dist[numI] > m) continue;;

            cnt += item[numI];

            for(Spot spot : tree[numI]){
                if(dist[spot.x] > dist[numI] + spot.cost){
                    dist[spot.x] = dist[numI] + spot.cost;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}