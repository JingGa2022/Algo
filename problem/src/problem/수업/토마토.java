package problem.수업;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
	static class Tomato{
		int x;
		int y;
		
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int M, N;
	static int[] dr= {-1, 0, 1, 0};//상우하좌
	static int[] dc= {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		int[][] box = new int[N][M];
		
		int empty = N *M;
		
		Queue<Tomato> q = new LinkedList<>();
		
		for(int i =0; i<N; i++) {
			for(int j =0; j<M; j++) {
				box[i][j] = sc.nextInt();
				
				switch (box[i][j]) {
				case 1:
					q.add(new Tomato(i,j));
				case -1:
					--empty;
					break;
				}
			}
		}
		//bfs탐색을 하겠다
		int days = 0;
		
		while(!q.isEmpty() && empty != 0) {
			//큐 사이즈로 묶어서 처리
			int size = q.size();
			
			//같은 날짜의 친구끼리만 처리
			for(int i =0; i<size; i++){
				Tomato t = q.poll();
				
				for(int d = 0; d<4; d++) {
					int nr = t.x + dr[d];
					int nc = t.y + dc[d];
					
					if(nr<0 || nr >=N || nc <0 || nc>=M || box[nr][nc] !=0)
						continue;
					
					box[nr][nc] = 1;
					q.add(new Tomato(nr,nc));
					--empty;
				}
			}
			++ days;
			
		}
		System.out.println(empty == 0 ? days : -1);
		
	}//main
}
