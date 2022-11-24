package problem.백준.class4;

import java.util.ArrayList;
import java.util.Scanner;

public class 미세먼지안녕_17144 {
	static class Spot{
        int x, y;
        public Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,t, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<Spot> airCleaner = new ArrayList<>();
    static int[][] map, copy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        map = new int[n][m];
        copy = new int[n][m];

        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<m; j++){
                map [i][j] = sc.nextInt();
                copy [i][j] = map[i][j];
                if(map[i][j] == -1) airCleaner.add(new Spot(i,j));
                if(map[i][j] > 0) ans += map[i][j];
            }
        }
        while(t > 0){
            t -= 1;
            ArrayList<Spot> al = new ArrayList<>();
            for(int i = 0 ; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(map[i][j] > 0) {
                        al.add(new Spot(i,j));
                    }
                }
            }
            for(Spot s : al)
                diffusion(s.x,s.y);
            duplicate(map, copy);
            clean();
            duplicate(copy, map);
        }

        System.out.println(ans);
    }

    private static void diffusion(int x, int y){
        int dust = map[x][y] / 5;
        int cnt = 0;
        for(int i = 0; i<4; i++){
            int nx = x + dr[i];
            int ny = y + dc[i];

            if(nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if(map[nx][ny] == -1) continue;
            cnt ++;
            copy[nx][ny] += dust;
        }
        copy[x][y] -= dust * cnt;
        if(copy[x][y] < 0) copy[x][y] = 0;
    }

    private static void clean() {
            Spot spot1 = airCleaner.get(0);
            Spot spot2 = airCleaner.get(1);
            int direction = 0;

            int pre = 0;
            while(true){
                Spot preSpot = spot1;
                switch (direction){
                    case 0 :
                        spot1 = new Spot(spot1.x, spot1.y + 1);
                        break;
                    case 1:
                        spot1 = new Spot(spot1.x - 1, spot1.y);
                        break;
                    case 2:
                        spot1 = new Spot(spot1.x, spot1.y - 1);
                        break;
                    case 3:
                        spot1 = new Spot(spot1.x + 1, spot1.y);
                        break;
                }
                if(spot1.x < 0 || spot1.y >= m || spot1.y < 0 ){
                    direction++;
                    spot1 = preSpot;
                    continue;
                }
                if(spot1.x == airCleaner.get(0).x && spot1.y == airCleaner.get(0).y) {
                    ans -= pre;
                    break;
                }

                int now = map[spot1.x][spot1.y];
                map[spot1.x][spot1.y] = pre;
                pre = now;
            }

            direction = 0;
            pre = 0;
            while(true){
                Spot preSpot = spot2;
                switch (direction){
                case 0 :
                    spot2 = new Spot(spot2.x, spot2.y + 1);
                    break;
                case 1:
                    spot2 = new Spot(spot2.x + 1, spot2.y);
                    break;
                case 2:
                    spot2 = new Spot(spot2.x, spot2.y - 1);
                    break;
                case 3:
                    spot2 = new Spot(spot2.x - 1, spot2.y);
                    break;
            }
            if(spot2.x >= n || spot2.y >= m || spot2.y < 0 ){
                direction++;
                spot2 = preSpot;
                continue;
            }
                if(spot2.x == airCleaner.get(1).x && spot2.y == airCleaner.get(1).y) {
                    ans -= pre;
                    break;
                }

            int now = map[spot2.x][spot2.y];
            map[spot2.x][spot2.y] = pre;
            pre = now;
        }
    }
    private static void duplicate(int[][] arr1, int[][] arr2){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++) arr1[i][j] = arr2[i][j];
        }
    }
}

