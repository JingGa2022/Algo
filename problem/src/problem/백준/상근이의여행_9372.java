package problem.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상근이의여행_9372 {
	static int n,m,ans;
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0 ;tc<T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			ans = 0;
			
			 arr = new int[n+1][n+1];
			 visit = new boolean[n+1];
			
			for(int i =0; i<m; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				arr[from][to] = 1;
				arr[to][from] = 1;
			}
			
			bfs();
			System.out.println(ans-1);
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			ans++;
			int tmp = q.poll();
			
			for(int i = 1; i<=n; i++) {
				if(arr[tmp][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
