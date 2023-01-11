package problem.백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
	  static class Ball{
	        int x, y, bx, by, cnt;
	        public Ball(int x, int y, int bx, int by, int cnt){
	            this.x = x;
	            this.y = y;
	            this.bx = bx;
	            this.by = by;
	            this.cnt = cnt;
	        }
	    }
	    static int n ,m;
	    static int dr[] = {-1, 0, 1, 0};
	    static int dc[] = {0, 1, 0, -1};
	    static boolean visit[][][][];
	    static Ball rb, bb, hole;
	    static char[][] arr;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());

	        arr = new char[n][m];
	        visit = new boolean[n][m][n][m];

	        for(int i = 0; i<n; i++){
	            String s = br.readLine();
	            for(int j = 0; j<m; j++){
	                arr[i][j] = s.charAt(j);
	                if(s.charAt(j) == 'B') bb = new Ball(0, 0, i, j,0);
	                if(s.charAt(j) == 'R') rb = new Ball(i, j,0, 0, 0);
	                if(s.charAt(j) == 'O') hole = new Ball(i, j, 0, 0,0);
	            }
	        }

	        System.out.println(exit());
	    }
	    static private int exit(){
	        Queue<Ball> q = new LinkedList<>();
	        q.add(new Ball(rb.x, rb.y, bb.bx, bb.by, 1));
	        visit[rb.x][rb.y][bb.bx][bb.by] = true;

	        while(!q.isEmpty()){
	            Ball b = q.poll();
	            int cnt = b.cnt;

	            if(cnt > 10) return -1;

	            for(int i = 0; i<4; i++){
	                int rx = b.x ;
	                int ry = b.y ;
	                int bx = b.bx ;
	                int by = b.by ;


	                boolean rh = false;
	                boolean bh = false;

	                while(arr[rx + dr[i]][ry + dc[i]] != '#' ) {
	                    rx += dr[i];
	                    ry += dc[i];
	                    if(rx == hole.x && ry == hole.y){
	                        rh = true;
	                        break;
	                    }
	                }
	                while(arr[bx + dr[i]][by + dc[i]] != '#' ) {
	                    bx += dr[i];
	                    by += dc[i];
	                    if(bx == hole.x && by == hole.y){
	                        bh = true;
	                        break;
	                    }
	                }
	                if(bh) continue;
	                if(rh) return cnt;

	                if(rx == bx && ry == by){
	                    if(i == 0){
	                        if(b.x > b.bx) rx -= dr[i];
	                        else bx -= dr[i];
	                    }else if(i == 1){
	                        if(b.y < b.by) ry -= dc[i];
	                        else by -= dc[i];
	                    } else if (i == 2) {
	                        if(b.x < b.bx) rx -= dr[i];
	                        else bx -= dr[i];
	                    }else{
	                        if(b.y > b.by) rx -= dc[i];
	                        else by -= dc[i];
	                    }
	                }

	                if(!visit[rx][ry][bx][by]){
	                    visit[rx][ry][bx][by] = true;
	                    q.add(new Ball(rx,ry,bx, by,cnt +1));
	                }
	            }
	        }
	        return -1;
	    }
}
