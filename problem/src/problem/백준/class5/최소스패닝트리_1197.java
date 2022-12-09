package problem.백준.class5;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소스패닝트리_1197 {
	static class Spot implements Comparable<Spot>{
		int x;
		int cost;

		public Spot(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Spot o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}

	static int v, e, ans;
	static ArrayList<Spot> tree[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();
		tree = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			tree[a].add(new Spot(b, c));
			tree[b].add(new Spot(a, c));
		}
		
		System.out.println(prim());
		
		
	}

	private static long prim() {
		boolean[] visit = new boolean[v + 1];
		PriorityQueue<Spot> pq = new PriorityQueue<>();
		pq.add(new Spot(1,0));
		
		long tmp = 0;
		int cnt = 0;
		
		while (!pq.isEmpty()) {
			Spot spot = pq.poll();
			if(visit[spot.x]) continue;

			tmp += spot.cost;
			visit[spot.x] = true;
			cnt++;
			if(cnt == v) return tmp;
			
			for(int i = 0; i<tree[spot.x].size(); i++) {
				Spot next = tree[spot.x].get(i);
				
				if(visit[next.x]) continue;
				
				pq.add(next);
			}
		}
		return tmp;
	}
}
