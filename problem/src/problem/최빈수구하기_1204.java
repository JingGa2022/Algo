package problem;

import java.util.Scanner;

public class 최빈수구하기_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스입력 숫자 넣을 배열
		int T = sc.nextInt();
		int[] score = new int[1000];

		for (int k = 1; k <= T; k++) {
			// 테스트 케이스 입력
			int TC = sc.nextInt();
			// 점수 빈도배열
			int[] fre_score = new int[101];
			// nBox에 점수 넣기
			for (int i = 0; i < 1000; i++)
				score[i] = sc.nextInt();
			// 0~100까지 각 점수가 몇개있는지 세기
			for (int i = 0; i <= 100; i++) {
				// 점수의 빈도 세기
				for (int j = 0; j < 1000; j++) {
					frequency(score, i, j, fre_score);
				}
			}
			// 최대값의 인덱스
			int maxV = 0;
			// 점수 중 최대값 구하기
			for (int i = 0; i <= 100; i++) {
				if (max(fre_score[i], fre_score[maxV]))
					maxV = i;
			}
			System.out.printf("#%d %d\n", TC, maxV);
		}

	}

	// 빈도구하는 메서드 정의
	static void frequency(int[] score, int i, int j, int[] fre_score) {
		if (score[j] == i)
			fre_score[i]++;
	}

	// 최대값 메서드 정의
	static boolean max(int a, int b) {
		if (a >= b)
			return true;
		else
			return false;
	}
}
