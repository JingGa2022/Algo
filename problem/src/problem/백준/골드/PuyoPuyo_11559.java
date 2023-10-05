package problem.백준.골드;

import java.io.*;
import java.util.*;

public class PuyoPuyo_11559 {
	/*
	 * 1. bfs로 찾아서 터뜨리기 2. 중력으로 내려서 정렬하기 3. 다시 1번 반복
	 */
	static class Point {
		int x;
		int y;
		char color;

		Point(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	static int ans = 0;
	static boolean isPop = false;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static char[][] arr = new char[12][6];
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		while (true) {
			isPop = false;
			
			solve();
			gravity();

			if(!isPop)
				break;
			
			ans++;
		}

		System.out.println(ans);
	}

	private static void solve() {
		visit = new boolean[12][6];
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] != '.' && !visit[i][j]) {
					ArrayList<int[]> list = new ArrayList<>();

					q.add(new Point(i, j, arr[i][j]));
					list.add(new int[] {i,j});
					visit[i][j] = true;

					while (!q.isEmpty()) {
						Point p = q.poll();
						for (int t = 0; t < 4; t++) {
							int nx = p.x + dr[t];
							int ny = p.y + dc[t];
							
							if(nx < 0 || ny < 0 || nx >= 12 || ny >= 12) continue;
							
							if(!visit[nx][ny] && arr[nx][ny] == p.color) {
								q.add(new Point(nx, ny, arr[nx][ny]));
								list.add(new int[] {nx,ny});
								visit[nx][ny] = true;
							}
						}
					}
					if(list.size() >= 4) {
						for(int k =0; k<list.size(); k++) {
							int x = list.get(k)[0];
							int y = list.get(k)[1];
							
							arr[x][y] = '.';
							
							isPop = true;
						}
					}
				}

			}
		}
	}

	private static void gravity() {
		for (int j = 0; j < 6; j++) {
			Queue<Point> puyo = new LinkedList<>();
			int idx = 11;
			for (int i = 11; i >= 0; i--) {
				if(arr[i][j] != '.') {
					puyo.add(new Point(i, j, arr[i][j]));
					arr[i][j] = '.';
				}
			}
			
			while(!puyo.isEmpty()) {
				Point p = puyo.poll();
				
				arr[idx][j] = p.color;
				idx--;
			}
		}
	}

}
