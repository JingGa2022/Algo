package problem.백준.class5;

import java.util.Scanner;

public class 알파벳_1987 {
	 static class Spot{
	        int x; int y;

	        public Spot(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
	    static int n, m, ans;
	    static boolean[] alphabet = new boolean[26];
	    static int[] dr = {0, 1, 0, -1};
	    static int[] dc = {1, 0, -1, 0};
	    static char arr[][];
	    static boolean visit[][];
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        m = sc.nextInt();
	        arr = new char[n][m];
	        visit = new boolean[n][m];

	        for(int i = 0; i<n; i++){
	            String s = sc.next();
	            for(int j = 0; j<m; j++) arr[i][j] = s.charAt(j);
	        }

	        move(0, 0, 1);

	        System.out.println(ans);
	    }
	    private static void move(int x, int y, int cnt){
	        int num = arr[x][y] - 'A';

	        ans = Math.max(ans, cnt);

	        if(!alphabet[num]){
	            alphabet[num] = true;

	            for (int i = 0; i<4; i++){
	                int nx = x + dr[i];
	                int ny = y + dc[i];

	                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
	                num = arr[nx][ny] - 'A';
	                if(alphabet[num]) continue;

	                move(nx,ny, cnt+1);
	                alphabet[num] = false;
	            }
	        }
	    }
	}