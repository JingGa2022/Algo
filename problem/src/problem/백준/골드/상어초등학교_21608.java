package problem.백준.골드;

import java.util.*;

public class 상어초등학교_21608 {
	/*
	 * 1. 좋아하는 사람 많은 칸 -> 빈칸이 많은 칸 -> 행열번호가 작은칸 순의 의사결정을 한다. 2.
	 */
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int nearCount;
		int likeCount;

		public Point(int x, int y, int nearCount, int likeCount) {
			this.x = x;
			this.y = y;
			this.nearCount = nearCount;
			this.likeCount = likeCount;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (this.likeCount > o.likeCount)
				return -1;
			else if (this.likeCount < o.likeCount)
				return 1;
			else {
				if (this.nearCount > o.nearCount)
					return -1;
				else if (this.nearCount < o.nearCount)
					return 1;
				else {
					if (this.x > o.x)
						return 1;
					else if (this.x < o.x)
						return -1;
					else {
						if (this.y > o.y)
							return 1;
						else
							return -1;
					}
				}
			}
		}
	}

	static int n;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] arr;
	static List<Integer>[] list;
	static int[][] map;
	static PriorityQueue<Point> q = new PriorityQueue<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n * n+1];
		map = new int[n +1][n+1];
		list = new ArrayList[n*n+1];

		for (int i = 1; i <= n * n; i++) {
				list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= n * n; i++) {
			int s = sc.nextInt();
			arr[i] = s;
			for(int j = 1; j<5; j++) {
				int tmp = sc.nextInt();
				list[s].add(tmp);
			}
		}
		
		for(int i = 1; i<=n*n; i++) {
			solve(arr[i]);
			q.clear();
		}
		
		int ans = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) ans += getPrice(i,j);
		}
		
		System.out.println(ans);
	}
	static int getPrice(int a, int b) {
		int num = map[a][b];
		
		int nx, ny, likeCount = 0;
		for(Integer now : list[num]) {
			for(int j = 0; j<4; j++) {
				nx = a + dr[j];
				ny = b + dc[j];
				if(nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
					if(map[nx][ny] == now) likeCount++;
				}
			}
		}
		if(likeCount==0) return 0;
		else if(likeCount==1) return 1;
		else if(likeCount==2) return 10;
		else if(likeCount==3) return 100;
		else return 1000;
	}

	static void solve(int num) {
		int nx, ny;
		int nearCount, likeCount;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				nearCount = 0;
				likeCount = 0;
				if (map[i][j] != 0) continue;
				
				for(int k = 0; k<4; k++) {
					nx = i + dr[k];
					ny = j + dc[k];
					if(nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
						for(Integer now : list[num]) {
							if(now == map[nx][ny]) likeCount++;
						}
						if(map[nx][ny] == 0) nearCount++;
					}
				}
				q.add(new Point(i,j,nearCount,likeCount));
			}
		}
		Point tmp = q.poll();
		map[tmp.x][tmp.y] = num;
	}
}
