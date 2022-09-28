package problem.삼성sw역량테스트;

import java.util.Scanner;

public class Easy2048_12100 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) arr[i][j] = sc.nextInt();
		}
		
	}
	//이동(방향, 횟수)
	//0이 아닌곳 움직인 방향 역으로 올라가면서 검사 같다면 합치기 2배
	//할떄마다 다 돌려서 남은 수로 최대값넘는지 확인 못넘으면 가지 자르기
	//
}
