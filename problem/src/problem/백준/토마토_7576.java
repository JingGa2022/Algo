package problem.백준;

import java.util.Scanner;

public class 토마토_7576 {
	static class Spot{
		int x;
		int y;
		
		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int M;//가로
	static int N;//세로
	static int[][] tomato;
	static int[] dr= {-1, 0, 1, 0};//상우하좌
	static int[] dc= {0, 1, 0, -1};
	static int ans = 0;//정답
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		tomato = new int[M][N];
		for(int i = 0; i<M; i++) {
			for(int j=0; j<N; j++)
				tomato[i][j] = sc.nextInt();
		}
		
		
	}//main
	static void bfs(Spot spot) {
		
	}
	
	//0이 있는지 확인
	static int isZero() {
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++)
				if(tomato[i][j] == 0) return -1;
		}
		return ans;
	}
}
