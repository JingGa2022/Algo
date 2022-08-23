package problem.백준.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
	static int n, m, max;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = 0;

		arr = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] =Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j]  = true;
				tetro(i, j,arr[i][j], 1);
				visit[i][j]  = false;
		
			}
		}
		System.out.println(max);
	}

	private static void tetro(int x, int y,int sum,  int cnt) {
		if(cnt == 4) {			
			if(sum > max) max = sum;
			
			return;
		}
		for(int i = 0; i<4; i++) {
			int newX = x + dr[i];
			int newY = y+dc[i];
			
			if(newX < 0 || newY < 0 || newX >= n || newY >= m || visit[newX][newY]) continue;
			
			// ㅜ의 경우
			if(cnt == 2) {
				visit[newX][newY] = true;
				tetro(x, y,sum + arr[newX][newY], cnt+1);
				visit[newX][newY] = false;
				
			}
			
			visit[newX][newY] = true;
			tetro(newX, newY,sum + arr[newX][newY], cnt+1);
			visit[newX][newY] = false;
		}
	}

}
