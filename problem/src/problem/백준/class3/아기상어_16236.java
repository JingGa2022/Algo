package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어_16236 {
	static class Spot{
		int x;
		int y;
		
		public Spot(int x, int y) {		
			this.x = x;
			this.y = y;
		}
	}
	static int N, size, ans;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		size = 1;
		ans = 0;
		arr = new int[N][N];
		Spot start = new Spot(0,0);
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				
				if(arr[i][j] == 9) {
					start = new Spot(i,j);
				}
			}
		}
		
		
		bfs(start.x, start.y);
		
		
		System.out.println(ans);
	}
	private static void bfs(int x, int y) {
		Queue<Spot> q = new LinkedList<>();
		
		q.add(new Spot(x ,y));
		
		int check = size;
		
		outer: while(!q.isEmpty()) {
			Spot spot = q.poll();
			
			for(int i=0; i<4; i++) {
				int newX = spot.x + dr[i];
				int newY = spot.y + dc[i];
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				
				q.add(new Spot(newX, newY));
				if(arr[newX][newY] != 0|| arr[newX][newY] <= size) {
					check --;
					ans += Math.abs(newX - x) + Math.abs(newY - y);
					arr[x][y] = 0;
					arr[newX][newY] = 9;
					if(check == 0) {
						size++;
						check = size;						
					}
					x = newX;
					y = newY;
					if(isLeft()) break outer;
				}
			}
		}
		
	}
	private static boolean isLeft() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] != 0 && arr[i][j] != 9) return false;
			}
		}
		return true;
	}
}
