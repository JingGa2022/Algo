package problem.백준;

import java.util.Scanner;

public class 부녀회장이될테양_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =0; tc<T; tc++) {
			int k = sc.nextInt(); //층 수
			int n = sc.nextInt(); //호 수
			int sum = 0;
			int[][] home = new int[k+1][n+1];
			//0층 집어넣기
			for(int i = 1; i<=n; i++) {
				home[0][i] += i;
			}
			
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=n; j++) {	
						for(int b=1; b<=j; b++) {
							home[i][j] += home[i-1][b];
					}
				}
			}
			
			System.out.println(home[k][n]);
		}
	}
}
