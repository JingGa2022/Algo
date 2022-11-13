package problem.백준.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기_2206 {
	 static class Spot{
	        int x;
	        int y;
	        int dis;
	        int wall;

	        public Spot(int x, int y, int dis, int wall) {
	            this.x = x;
	            this.y = y;
	            this.dis = dis;
	            this.wall = wall;
	        }
	    }
	    static int[][] map, visit;
	    static int[] dr = {-1, 0, 1, 0};
	    static int dc[] = {0, 1, 0, -1};
	    static int n, m, ans;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        m = sc.nextInt();

	        map = new int[n][m];
	        visit = new int[n][m];

	        for(int i = 0 ; i<n; i++){
	            String s = sc.next();
	            for(int j = 0; j<m; j++) {
	                map[i][j] = s.charAt(j) - '0';
	                visit[i][j] = Integer.MAX_VALUE;
	            }
	        }

	        ans = Integer.MAX_VALUE;

	        bfs(0, 0);

	        if(ans == Integer.MAX_VALUE) System.out.println(-1);
	        else System.out.println(ans);
	    }

	    private static void bfs(int x, int y) {
	        Queue<Spot> q = new LinkedList<>();
	        q.add(new Spot(x,y, 1, 0));
	        visit[x][y] = 0;

	        while(!q.isEmpty()){
	            Spot spot = q.poll();

	            if(spot.x == n-1 && spot.y == m-1){
	                ans = spot.dis;
	                break;
	            }
	            for(int i = 0; i<4; i++){
	                int newX = spot.x + dr[i];
	                int newY = spot.y + dc[i];

	                if(newX >= n|| newX < 0 || newY >= m || newY < 0) continue;
	                if(visit[newX][newY] <= spot.wall) continue;
	                if(map[newX][newY] == 0) {
	                    visit[newX][newY] = spot.wall;
	                    q.add(new Spot(newX, newY, spot.dis+1, spot.wall));
	                }
	                else {
	                    if(spot.wall == 0) {
	                        visit[newX][newY] = spot.wall + 1;
	                        q.add(new Spot(newX, newY, spot.dis+1, spot.wall + 1));
	                    }
	                }
	            }
	        }
	    }
	}

