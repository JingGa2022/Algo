package problem.백준.class4;

import java.util.Scanner;

public class 플로이드_11404 {
	  static int[][] visit;
	    static int n,m;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StringBuilder sb = new StringBuilder();

	        n = sc.nextInt();
	        m = sc.nextInt();

	        visit = new int[n + 1][n + 1];
	        for (int i = 0; i <= n; i++) {
	            for (int j = 0; j <= n; j++){
	                visit[i][j] = 999999999;
	                if(i == j) visit[i][j] = 0;
	            }
	        }

	        for (int i = 0; i < m; i++) {
	            int from = sc.nextInt();
	            int to = sc.nextInt();
	            int cost = sc.nextInt();

	            visit[from][to] = Math.min(visit[from][to], cost);
	        }

	        for(int k = 1; k<=n; k++){
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                   if(visit[i][j] > visit[i][k] + visit[k][j]){
	                       visit[i][j] = visit[i][k] + visit[k][j];
	                   }
	                }
	            }
	        }

	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                if(visit[i][j] == 999999999) visit[i][j] =0;
	                sb.append(visit[i][j] +" ");
	            }
	            sb.append("\n");
	        }

	        System.out.println(sb);
	    }
	}
