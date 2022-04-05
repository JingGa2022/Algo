package problem.백준;

import java.util.Scanner;

public class 도영이가만든맛있는음식_2961 {
	static int[][] ingre; //재료
	static boolean[] sel; //사용했는지 부분부열 저장용
	static int N;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ingre = new int[N+1][2];
		sel = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		for(int i =1; i<=N; i++) {
			for(int j =0; j<2; j++)
				ingre[i][j] = sc.nextInt();
		}
		pow(N+1, 1);
		System.out.println(min);
	}//main
	static void pow(int n, int k) {
		if(n == k) {
			int times = 1;
			int sum = 0;
			int gap = 0;
			for(int i =1; i <=N; i++) {
				//신맛은 곱하고 쓴맛은 더하고
				if(sel[i]) {
					times *= ingre[i][0];
					sum += ingre[i][1];
					sel[0] = true; //공집합을 제외함
				}
			}
			//그 차이의 절댓값의 최소를 구해보자
			gap = Math.abs(sum - times);
			if(gap<min && sel[0] == true) min = gap;
			return;
		}
		sel[k] = false;
		pow(n, k+1);
		sel[k] = true;
		pow(n, k+1);
	}
}
