package problem.백준.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {
	static int N,K;
	static boolean[] visit;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[100001];
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Spot> q = new LinkedList<>();
		q.add(new Spot(N, 0));
		
		while(!q.isEmpty()) {
			Spot spot = q.poll();
			visit[spot.idx] = true;
			if(spot.idx == K) {
				ans = Math.min(ans, spot.time);
			}
			if(spot.idx * 2 <= 100000 && !visit[spot.idx * 2]) q.add(new Spot(spot.idx * 2, spot.time));
			if(spot.idx + 1 <= 100000 && !visit[spot.idx + 1]) q.add(new Spot(spot.idx + 1, spot.time + 1));
			if(spot.idx - 1 >= 0 && !visit[spot.idx - 1]) q.add(new Spot(spot.idx - 1, spot.time + 1));
			
		}
	}
}

class Spot {
	int idx;
	int time;
	
	public Spot(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}