package problem.백준.class3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기_2667 {
	static class Spot {
		int x;
		int y;
		
		private  Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visit;
	static LinkedList<Integer> ans = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			String s = sc.next();
			for(int j = 0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					bfs(new Spot(i,j));
				}
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		
		for(int i =  0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	private static void bfs(Spot spot) {
		Queue<Spot> q = new LinkedList<>();
		
		q.add(spot);
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Spot nSpot = q.poll();
			for(int i = 0; i<4; i++) {
				int newX = nSpot.x + dr[i];
				int newY = nSpot.y + dc[i];
				
				if(newX <0 || newY < 0 || newX >= N || newY >= N || visit[newX][newY]) continue;
				
				if(map[newX][newY] == 1) {
					visit[newX][newY] = true;
					cnt++;
					q.add(new Spot(newX, newY));
				}
			}
		}
		ans.add(cnt);
	}
}
