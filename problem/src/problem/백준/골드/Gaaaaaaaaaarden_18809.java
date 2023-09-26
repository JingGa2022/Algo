package problem.백준.골드;

import java.util.*;

public class Gaaaaaaaaaarden_18809 {
	/* 1. 배양액 땅이 따로 있고 같은데 또 뿌리기 불가
	 * 2. 배양액이 모든 부분으로 퍼지고 빨 초가 만나면 꽃이핌 (단, 꽃이 핀곳은 배양액 못 퍼짐)
	 * 3. 
	 */
	static int n,m,g,r;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//행열
		n = sc.nextInt();
		m = sc.nextInt();
		//초록 빨강 배양액 수
		g = sc.nextInt();
		r = sc.nextInt();
		
		arr = new int[n][m];
		visit = new boolean[n][m][3];
		
		// 호수 0, 배약액 불가1, 배약액 가능 2 
		for(int i = 0 ; i<n; i++) {
			for(int j = 0 ; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
