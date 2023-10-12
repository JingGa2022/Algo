package problem.백준.골드;

import java.util.*;

public class 상범빌딩_6593 {
	static class Whereami {
		int floor, x, y, time;

		Whereami(int floor, int x, int y, int time) {
			this.floor = floor;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int l, r, c;
	static int[] dr = { -1, 0, 1, 0, 1, -1 };
	static int[] dc = { 0, 1, 0, -1, 1, -1 };
	static Whereami start;
	static boolean[][][] visit;
	static char[][][] building;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			l = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			if(l == 0 && r == 0 && c == 0) break;
			building = new char[l][r][c];

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String tmp = sc.next();
					for (int k = 0; k < c; k++) {
						building[i][j][k] = tmp.charAt(k);
						if (building[i][j][k] == 'S')
							start = new Whereami(i, j, k, 0);
					}
				}
			}
			
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						System.out.print( building[i][j][k]);
					}
					System.out.println();
				}
				System.out.println();
			}
			bfs(start);
		}

		System.out.println(sb);
	}

	static void bfs(Whereami start) {
		Queue<Whereami> q = new LinkedList<>();
		q.add(start);
		visit = new boolean[l][r][c];
		visit[start.floor][start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Whereami w = q.poll();
			int nx = w.x;
			int ny = w.y;
			int nf = w.floor;
			int time = w.time;
			
			System.out.printf("nf : %d, nx : %d, ny : %d, char : %c \n", nf, nx, ny, building[nf][nx][ny]);
			if(building[nf][nx][ny] == 'E') {
				sb.append("Escaped in " + time + " minute(s).\n" );
				return;
			}
			
			for(int i = 0; i<6; i++) {
				if(i < 4) {
					nx = w.x + dr[i];
					ny = w.y + dc[i];
				}else {
					nf = w.floor + dr[i];
				}
				
				if(nx < 0 || ny < 0 || nf < 0 || nx >= r || ny >= c || nf >= l) continue;
				if(visit[nf][nx][ny] || building[nf][nx][ny] == '#') continue;
				
				visit[nf][nx][ny] = true;
				q.add(new Whereami(nf,nx,ny,time+1));
			}
		}
		sb.append("Trapped!\n");
	}
}
