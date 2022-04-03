package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 파핑파핑지뢰찾기_1868 {
	static String[][] mine;
	static String[] tmp;
	static int N;
	static boolean flag = false;
	static int ans;
	static int[] dr = {-1, 0, 1, 0, 0}; //본인까지 오방 탐색
	static int[] dc = {0, 1, 0 , -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			mine = new String[N+2][N+2];
			sc.nextLine();
				for(int i = 1; i<=N; i++) {
					tmp= sc.nextLine().split("");
					for(int j =1; j<=N; j++)
						mine[i][j] = tmp[j-1];
				}
				ans=0;
				for(int i = 1; i<=N; i++) {
					for(int j =1; j<=N; j++) {
						bfs(i,j);
					if(flag == true)
						ans++;
					}
				}
				System.out.println("#"+tc+" "+ans);
		}//for
	}// main
	public static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		flag = false;
		que.offer(new Node(x, y));
		while(!(que.isEmpty())) {
			Node node = que.poll();
	
			for(int i = 0; i<5; i++) {
				int ix = node.x + dr[i];
				int iy = node.y + dc[i];
				if(mine[ix][iy] != null && mine[ix][iy] != "*") {
					mine[x][y] = "*";
					mine[ix][iy] = "*";
					flag = true;
					que.offer(new Node(ix, iy));
				}
			}
		}//while
	}
	
	static class Node{
		int x;
		int y;
		
		
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		
	}
}
