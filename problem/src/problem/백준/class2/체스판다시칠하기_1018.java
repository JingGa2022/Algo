package problem.백준.class2;

import java.io.IOException;
import java.util.Scanner;

public class 체스판다시칠하기_1018 {
	static boolean[][] box;
	static int ans = Integer.MAX_VALUE;
	static int N; // 행
	static int M; // 열

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	

		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		box = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j<M; j++) {
				if(str.charAt(j) == 'W') {
					box[i][j] = true;
				}
				else 
					box[i][j] = false;
			}
		}


		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				change(i, j);
			}
		}
		System.out.println(ans);
	}// main

	private static void change(int a, int b) {
		int tmp = 0;
		
		boolean flag = box[a][b];
		
		for (int i = a; i < a + 8; i++) {
			for (int j = b; j < b + 8; j++) {
				if(box[i][j] != flag) {
					tmp++;
				}
				
				flag = (!flag);
			}//for
			
			flag = !flag;
		}//for
		
		tmp = Math.min(tmp, 64-tmp);
		
		ans = Math.min(ans,tmp);
	}
}
