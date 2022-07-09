package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 케빈베이컨의6단계법칙_1389 {
	static int N, ans;
	static int[][] map;
	static boolean[] visited;
	static int min;
	
	static class Bacon{
		int num;
		int value;
		
		public Bacon(int num, int value) {
			this.num = num;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		min = Integer.MAX_VALUE;
		ans = 0;

		map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
			
		}
		for(int i = 1; i<=N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		System.out.println(ans);
	}
	private static void bfs(int start) {
		// TODO Auto-generated method stub
		Queue<Bacon> q = new LinkedList<>();
		int count = 0;
		
		visited[start] = true;
		q.offer(new Bacon(start,0));
		
		while(!q.isEmpty()) {
			Bacon bacon = q.poll();
			count += bacon.value;
			for(int i = 1 ; i<=N; i++) {
				int num = map[bacon.num][i];
				
				if(num == 1 && visited[i] == false) {
					visited[i] = true;
					q.offer(new Bacon(i, bacon.value +1));
				}
			}
		}
		if(min > count) {
			min = count;
			ans = start;
		}
	}
}
