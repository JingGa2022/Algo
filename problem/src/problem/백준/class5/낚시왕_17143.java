package problem.백준.class5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 낚시왕_17143 {
	 static class Shark{
	        int x; int y; int speed; int dir; int size;
	        public Shark(int x, int y, int speed, int dir, int size){
	            this.x = x;
	            this.y = y;
	            this.speed = speed;
	            this.dir = dir;
	            this.size = size;
	        }
	    }
	    static int n,m,s,ans;
	    static int[] dr = {0, -1, 1, 0, 0};
	    static int[] dc = {0, 0, 0, 1, -1};
	    static Shark map[][];
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        m = sc.nextInt();
	        s = sc.nextInt();

	        map = new Shark[n+1][m+1];

	        for(int i = 1; i<=s; i++){
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            map[x][y] = new Shark(x, y, sc.nextInt(), sc.nextInt(), sc.nextInt());
	        }

	        for(int i = 1; i<=m; i++){
	            fishing(i);
	            moveS();

	           /** for(int q = 1; q<=n; q++){
	                for(int j = 1; j<=m; j++) System.out.print(map[q][j] + " ");
	                System.out.println();
	            }
	            System.out.println(sharks[3].x +" " + sharks[3].y);
	            System.out.println("-----------------------------"); **/
	        }
	        System.out.println(ans);

	    }
	    private static void fishing(int h) {
	        for(int i = 1; i<=n; i++){
	            if(map[i][h] != null){
	                ans += map[i][h].size;
	                map[i][h] = null;
	                return;
	            }
	        }
	    }

	    private static int shift(int d){
	        if(d == 1) return 2;
	        else if(d == 2) return 1;
	        else if(d == 3) return 4;
	        return 3;
	    }
	    private static void moveS() {

	        Queue<Shark> q = new LinkedList<>();
	        for(int i =1; i<=n; i++){
	            for(int j = 1; j<=m; j++){
	                if(map[i][j] != null){
	                    Shark shark = map[i][j];
	                    q.add(new Shark(i, j, shark.speed, shark.dir, shark.size));
	                }
	            }
	        }
	        map = new Shark[n+1][m+1];

	        while(!q.isEmpty()){
	            Shark s = q.poll();

	            int speed = s.speed;
	            if(s.dir == 1 || s.dir == 2){
	                speed %= (n-1) *2;
	            }else if(s.dir == 3 || s.dir == 4){
	                speed %= (m-1) *2;
	            }

	            //위치 계산
	            for(int j = 0; j<speed; j++){
	                int nx = s.x + dr[s.dir];
	                int ny = s.y + dc[s.dir];

	                if(nx > n || nx < 1 || ny > m || ny < 1){
	                    s.x -= dr[s.dir];
	                    s.y -= dc[s.dir];
	                    s.dir = shift(s.dir);
	                    continue;
	                }
	                s.x = nx;
	                s.y = ny;
	            }
	            //위치 변경
	            if(map[s.x][s.y] != null){
	                if(map[s.x][s.y].size < s.size)
	                    map[s.x][s.y] = new Shark(s.x, s.y, s.speed, s.dir, s.size);
	            }else{
	                map[s.x][s.y] = new Shark(s.x, s.y, s.speed, s.dir, s.size);
	            }
	        }
	    }
}
