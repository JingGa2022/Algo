package problem.삼성sw역량테스트;

import java.util.Scanner;

public class 주사위굴리기_14499 {
	static int n,m,x,y,k;
	static int[] dr = {0, 0, 0, -1, 1}; //동서남북
	static int[] dc = {0, 1, -1, 0, 0};
	static int[][] map;
	static int[] dice = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i = 0 ; i <n ; i++) {
			for(int j = 0 ; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i<k; i++) {
			move(sc.nextInt());
		}
	}
	private static void move(int direct) {
		// TODO Auto-generated method stub
		int nx = x + dr[direct];
		int ny = y + dc[direct];
		
		if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1) return;
		
		roll(direct, nx,ny);
		x = nx; y=ny;
	}
	private static void roll(int direct, int nx, int ny) {
		// TODO Auto-generated method stub
		int tmp = dice[1];
		switch(direct) {
		case 1:
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 2:
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 3:
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 4:
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		if(map[nx][ny] == 0) {
			map[nx][ny] = dice[6];
		}else {
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		System.out.println(dice[1]);
	}
}
