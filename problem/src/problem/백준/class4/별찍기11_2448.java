package problem.백준.class4;

import java.util.Scanner;

public class 별찍기11_2448 {
	static int n;
	static char[][] arr;
	static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr= new char[n][2*n-1];

		
		for(int i = 0 ; i<n; i++) {
			for(int j = 0; j<2*n-1; j++)
				arr[i][j] = ' ';
		}
		
		star(0, n-1, n);
		
		for(int i = 0 ; i<n; i++) {
			for(int j = 0; j<2*n-1; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
	// x y는 꼭대기 별의 위치 이를 기반으로 세 번을 돌림
	private static void star(int x, int y, int cnt) {
		// TODO Auto-generated method stub
		if(cnt == 3) {
			arr[x][y] = '*';
			arr[x+1][y-1] = arr[x+1][y+1] = '*';
			for(int i = 0; i<5; i++) arr[x+2][y-2+i] = '*';
			return;
		}
		star(x,y, cnt/2);
		star(x + cnt/2, y - cnt/2, cnt/2);
		star(x + cnt/2, y + cnt/2, cnt/2);
		
	}
}
