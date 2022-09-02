package problem.백준.class3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어_16236 {
	static class Spot {
		int x;
		int y;
		int time;

		public Spot(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time  = time;
		}
	}

	static int N, size, ans;
	static ArrayList<Spot> fish = new ArrayList<>();
	static Spot baby;
	static int eaten = 0;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][] arr;
	static boolean[][] visit ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		size = 2;
		ans = 0;
		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();

				if (arr[i][j] == 9) {
					baby = new Spot(i, j, 0);
					arr[i][j] = 0;
				}
			}
		}

		bfs(baby.x, baby.y);

		System.out.println(ans);
	}

	private static void bfs(int x, int y) {
		Queue<Spot> q = new LinkedList<>();

		q.add(baby);

		visit[x][y] = true;
		while(true) {
			
		while (!q.isEmpty()) {
			Spot spot = q.poll();

			for (int i = 0; i < 4; i++) {
				int newX = spot.x + dr[i];
				int newY = spot.y + dc[i];

				if (newX < 0 || newY < 0 || newX >= N || newY >= N || visit[newX][newY])
					continue;

				if (arr[newX][newY] < size && arr[newX][newY] != 0) {
					q.add(new Spot(newX, newY, spot.time + 1));
					visit[newX][newY] = true;
					fish.add(new Spot(newX, newY, spot.time + 1));
				}
					if (arr[newX][newY] == size || arr[newX][newY] == 0) {
						q.add(new Spot(newX, newY, spot.time + 1));
						visit[newX][newY] = true;
					}
				}
			}
			//식사후
			if(!fish.isEmpty()) {
				eat();
				
				q.clear();
				visit = new boolean[N][N];
				
				q.add(baby);
				visit[baby.x][baby.y] = true;
			}else
				return;
		}
	}

	private static void eat() {
		// TODO Auto-generated method stub
		Collections.sort(fish, new Comparator<Spot>() {

			@Override
			public int compare(Spot o1, Spot o2) {
				if(o1.time == o2.time) {
					if(o1.x == o2.x) {
						if(o1.y > o2.y) {
							return 1;
						}else
							return -1;
					}else {
						if(o1.x > o2.x) {
							return 1;
						}else
							return -1;
					}
				}else if(o1.time > o2.time) {
					return 1;
				}else
					return -1;
			};
			
		});
		Spot spot = fish.get(0);
		
		baby.x = spot.x;
		baby.y = spot.y;
		
		if(++eaten == size) {
			size ++;
			eaten = 0;
		}
		
		ans += spot.time;
		
		arr[spot.x][spot.y] = 0;
		
		fish.clear();
	}

}
