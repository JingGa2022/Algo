package problem.백준.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2_12851 {
	static class Loc {
		int x;
		int time;

		public Loc(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static int n, k, cnt;
	static int[] time = new int[100001];
	static int min = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n >= k) {
			System.out.println((n-k) +"\n1");
			return;
		}

		bfs();

		System.out.println(time[k] + "\n" + cnt);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		while (!q.isEmpty()) {
			int now = q.poll();
			
			if(min < time[now]) return;

			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 0)
					nx = now + 1;
				else if (i == 1)
					nx = now - 1;
				else
					nx = now * 2;

				if (nx < 0 || nx > 100000) continue;
				
				if (nx == k) {
					min = time[now];
					cnt++;
				}
				
				if(time[nx] == 0 || time[nx] == time[now] + 1) {
					q.add(nx);
					time[nx] = time[now] + 1;
				}
			}
		}
	}
}
