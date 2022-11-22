package problem.백준.class4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_14502 {
	static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,cnt,ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Node> virus = new ArrayList<>();
    static int[][] map;
    static int[][] copy;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        copy = new int[n][m];
        ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int tmp = sc.nextInt();
                map[i][j] = tmp;
                copy[i][j] = tmp;
                if(tmp == 2) virus.add(new Node(i,j));
                if(tmp == 0) cnt++;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
               if(copy[i][j] == 0) wall(i, j, 0);
            }
        }

        System.out.println(ans-3);
    }

    private static void wall(int x, int y, int count) {
        map[x][y] = 1;

        if(count == 2) {
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    copy[i][j] = map[i][j];
                }
            }
            bfs();
            return;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0) {
                    wall(i, j, count+1);
                    map[i][j] = 0;
                }
            }
        }
        map[x][y] = 0;
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visit = new boolean[n][m];
        int count = 0;
        for(int i = 0; i< virus.size(); i++) {
            q.add(virus.get(i));

            while(!q.isEmpty()){
                Node node = q.poll();
                visit[node.x][node.y] = true;

                for(int j = 0; j<4; j++){
                    int nx = node.x + dr[j];
                    int ny = node.y + dc[j];

                    if(nx >= n || nx < 0 || ny >=m || ny < 0) continue;
                    if(visit[nx][ny] || copy[nx][ny] != 0) continue;

                    visit[nx][ny] = true;
                    q.add(new Node(nx,ny));
                    count++;
                }
            }
        }
        ans = Math.max(ans, cnt - count);
    }
}