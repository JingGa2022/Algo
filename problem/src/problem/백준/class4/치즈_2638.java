package problem.백준.class4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈_2638 {
	static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static ArrayList<Spot> cheese;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++) map[i][j] = sc.nextInt();
        }

        bfs();

        System.out.println(ans);
    }

    private static void bfs() {

        while(true) {
            cheese = new ArrayList<>();

            int[][] visit = new int[n][m];
            Queue<Spot> q = new LinkedList<>();
            q.add(new Spot(0,0));
            visit[0][0] = -1;

            while (!q.isEmpty()) {
                Spot spot = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = spot.x + dr[i];
                    int ny = spot.y + dc[i];

                    if (nx >= n || nx < 0 || ny >= m || ny < 0 || visit[nx][ny] == -1) continue;

                    if (map[nx][ny] != 0) {
                        visit[nx][ny]++;
                        if (!cheese.contains(new Spot(nx, ny))) cheese.add(new Spot(nx, ny));
                    } else {
                        visit[nx][ny] = -1;
                        q.add(new Spot(nx, ny));
                    }
                }
            }

            melting(visit);

            if (cheese.isEmpty()) {
                break;
            }
            ans += 1;
        }
    }

    private static void melting(int[][] arr) {
            for(Spot s : cheese){
                if(arr[s.x][s.y] > 1){
                    map[s.x][s.y] = 0;
                }
            }
    }
}