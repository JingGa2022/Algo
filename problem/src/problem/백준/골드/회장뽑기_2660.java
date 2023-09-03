package problem.백준.골드;

import java.util.Scanner;

public class 회장뽑기_2660 {
	/* 1. 플로이드 위셜 알고리즘 이용
	 * 2. 최소 길이를 찾아내고 각 행렬의 점수를 정렬 돌때 결국 모든걸 다 돌아봤을때 최소값을 구하기 때문
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int inf = 123456789;
		int[][] arr = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<= n; j++) arr[i][j] = inf;
		}
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a == -1) break;
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int k = 1 ; k<=n; k++) {
			for(int i = 1 ; i<=n; i++) {
				if(k == i) continue;
				for(int j = 1; j<=n; j++) {
					if(j == i || j == k) continue;
					
					if(arr[i][j] >= arr[i][k] + arr[k][j]) 
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		int ans = inf;
		int[] score = new int[n+1];

		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(arr[i][j] == inf) continue;
				score[i] = Math.max(score[i], arr[i][j]);
			}
			ans = Math.min(ans, score[i]);
		}
		
		sb.append(ans + " ");
		
		StringBuilder tmp = new StringBuilder();
		int cnt = 0;
		for(int i = 1 ; i<=n; i++) {
			if(score[i] == ans) {
				cnt++;
				tmp.append(i + " ");
			}
		}
		sb.append(cnt + "\n");
		sb.append(tmp);
		
		System.out.println(sb);
	}
}
