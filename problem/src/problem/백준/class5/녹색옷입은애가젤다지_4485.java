package problem.백준.class5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 녹색옷입은애가젤다지_4485 {
    static class Spot{
        int x; int y;
        public Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static final int INF = 987654321;
    static int n;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] cost, arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = 0;
        
        while(true){
            n = sc.nextInt();
            if(n == 0) break;
            cost = new int[n][n];
            arr = new int[n][n];

            for(int i = 0; i<n; i++)
                Arrays.fill(arr[i], INF);

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    cost[i][j] = sc.nextInt();
                }
            }
            
            arr[0][0] = cost[0][0];
            dijkstra();
            
            sb.append("Problem "+ (++T) + ": " + arr[n-1][n-1] + "\n");
        }
        System.out.println(sb);
    }
    static void dijkstra(){
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(0, 0));

        while(!q.isEmpty()){
            Spot spot = q.poll();
            for(int i = 0; i<4; i++){
                int nx = spot.x + dr[i];
                int ny = spot.y + dc[i];

                if(nx <0 || nx>=n || ny < 0 || ny >= n) continue;
                if(arr[spot.x][spot.y] + cost[nx][ny] >= arr[nx][ny]) continue;
                
                arr[nx][ny] = arr[spot.x][spot.y] + cost[nx][ny];
                q.add(new Spot(nx, ny));
            }
        }
    }
}