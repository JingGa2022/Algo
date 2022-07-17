package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7569 {
	static int m, n, h, ans;
	static int[][][] arr;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static class Tomato{
		int x;
		int y;
		int z;
		
		public Tomato (int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static Queue<Tomato> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		ans = 0;

		arr = new int[n][m][h];

		q = new LinkedList<>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					arr[j][k][i] = sc.nextInt();
					
					if(arr[j][k][i] == 1) q.add(new Tomato(j,k,i));
				}
			}
		}
		System.out.println(bfs());
	}// main

	private static int bfs() {
		// TODO Auto-generated method stub
		while(!q.isEmpty()) {
				Tomato t = q.poll();
				
			for (int i = 0; i < 6; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				int nz = t.z + dz[i];
				
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
					if(arr[nx][ny][nz] == 0) {
						q.add(new Tomato(nx,ny,nz));
						
						arr[nx][ny][nz] = arr[t.x][t.y][t.z] +1;
					}
				}
			}
		}
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (arr[j][k][i] == 0)
						return -1;
					result = Math.max(result, arr[j][k][i]);
				}
			}
		}
		if(result==1) return 0;
		else return result-1;
	}

}