package problem.삼성sw역량테스트;

import java.util.Scanner;

public class 뱀_3190 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N,K,L;
	static int[][] arr, time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//보드의 크기
		K = sc.nextInt();//사과의 개수
		
		arr = new int[K][2];
		
		for(int i = 0; i<K; i++) {
			for(int j = 0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		L = sc.nextInt();
		
		time = new int[L][2];
		
		for(int i = 0 ; i<L; i++) {
				time[i][0] = sc.nextInt();
				String s = sc.next();
				if(s.equals("D"))
					time[i][1] = 0;//오른쪽
				else
					time[i][1] = 1;//왼쪽
		}
		
	}
}
