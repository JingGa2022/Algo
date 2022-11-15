package problem.백준.class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Road{
    int end;
    int cost;

    public Road(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class 웜홀_1865 {
    static int n, m, w;//지점, 도로, 웜홀
    static int dist[];
    static ArrayList<Road>[] road;
    static final int inf = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 0; t<tc; t++){
            n = sc.nextInt();
            m = sc.nextInt();
            w = sc.nextInt();

            road = new ArrayList[n+1];
            for(int i = 0; i<=n; i++) road[i] = new ArrayList<>();
            dist = new int[n+1];

            for(int i = 0 ; i<m + w; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                if(i<m){
                    road[a].add(new Road(b, c));
                    road[b].add(new Road(a, c));
                }else{
                    road[a].add(new Road(b, -c));
                }
            }

            boolean check = false;
            for(int i = 1; i<=n; i++) {
                if(bellmanFord(i)){
                    check = true;
                    break;
                }
            }

            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, inf);
        dist[start] = 0;
        boolean update = false;

        for(int i = 1; i<n; i++){
            update = false;

            for(int j = 1; j<=n ;j++){
                for(Road r : road[j]){
                    if(dist[j] != inf && dist[r.end] > dist[j] + r.cost){
                        dist[r.end] = dist[j] + r.cost;
                        update = true;
                    }
                }
            }

            if(!update) break;
        }

        if(update){
            for(int i = 1; i<=n; i++){
                for(Road r : road[i]){
                    if(dist[i] != inf && dist[r.end] > dist[i] + r.cost){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
