package problem;

import java.util.Scanner;

public class 평균값구하기_2071 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트횟수
		int T = sc.nextInt();
		// 입력넘버
		double[] sum = new double[T];

		// sum값에 다 넣어서 총합을 만들어 버리기
		for (int i = 0; i < T; i++) {
			for(int j = 0; j < 10; j++) {
				sum[i] += sc.nextInt();
			}
		}
		for(int i = 1; i <= T; i++)
			System.out.printf("#%d %d\n",i,Math.round(sum[i-1]/10));
	}
}
