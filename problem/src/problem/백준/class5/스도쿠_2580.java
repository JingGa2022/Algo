package problem.백준.class5;

import java.util.Scanner;

public class 스도쿠_2580 {
	static int[][] arr = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) arr[i][j] = sc.nextInt();
		}
		
		sudoku(0, 0);
		
	}
	private static void sudoku(int x, int y) {
		// TODO Auto-generated method stub
		if(y == 9) {
			sudoku(x + 1, 0);
			return;
		}
		
		if(x == 9) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(arr[x][y] == 0) {
			for(int i = 1; i<= 9; i++) {
				if(check(x,y, i)) {
					arr[x][y] = i;
					sudoku(x, y+1);
				}
			}
			arr[x][y] = 0;
			return;
		}
		
		sudoku(x, y+1);
	}
	private static boolean check(int r, int c, int v) {
		for(int i = 0; i<9; i++) {
			if(arr[r][i] == v) return false;
		}
		
		for(int i = 0; i<9; i++) {
			if(arr[i][c] == v) return false;
		}
		
		int nr = (r/3) * 3;
		int nc = (c/3) * 3;
		
		for(int i = nr; i < nr + 3; i++) {
			for(int j = nc; j < nc + 3; j++) {
				if(arr[i][j] == v) return false;
			}
		}
		
		return true;
	}
}
