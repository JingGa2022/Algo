package problem.APS심화;

import java.util.Scanner;

public class 공통조상_1248 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();//정점의 수
			int E = sc.nextInt();//간선의 수
			int vNum1 = sc.nextInt();//정점번호1
			int vNum2 = sc.nextInt();//정점번호2
			int[][] num = new int[V+1][3];
			for(int i =1; i<=V; i++) {
				for(int j =1; j <=2 ; i++)
					num[i][j] = sc.nextInt();//숫자를  행으로 삼아 1열은 왼자 2열은 오자
			}
		}
	}
}
