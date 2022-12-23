package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 피리부는사나이_16724 {
	static class Spot{
        int x; int y;
        public Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static HashMap<Character, Integer> hm = new HashMap<>();
    static int n, m, cnt, ans;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        hm.put('R', 0);
        hm.put('D', 1);
        hm.put('L', 2);
        hm.put('U', 3);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new int[n][m];

        for(int i = 0; i<n; i++){
            String s = br.readLine();
            for(int j = 0; j<m; j++) arr[i][j] = hm.get(s.charAt(j));
        }

        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visit[i][j] == 0)
                    safezone(i,j);
            }
        }
        System.out.println(ans);
    }
    private static void safezone(int x, int y){
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));
        cnt++;

        while(!q.isEmpty()){
            Spot spot = q.poll();
            int d = arr[spot.x][spot.y];
            visit[spot.x][spot.y] = cnt;

            int nx = spot.x + dr[d];
            int ny = spot.y + dc[d];

            if(visit[nx][ny] != 0) {
                if (visit[nx][ny] != cnt) {
                    ans--;
                }
                break;
            }
            q.add(new Spot(nx, ny));
        }
        ans++;
    }
}
