package problem;

import java.util.Scanner;

public class 최대수_구하기_2068 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 횟수를 받는다
		int T = sc.nextInt();
		int[] tc = new int[10];
		// 최대값을 넣을 배열을 만든다.
		int[] max_num = new int[T];

		// 셀렉션 알고리즘을 이용해 최대값을 찾아본다.
		// T번의 테스트를 진행한다.
		for (int i = 0; i < T; i++) {
			// 10개의 숫자가 있기때문에 10번 진행한다.
			for (int j = 0; j < 10; j++)
				// 숫자 10개 받기
				tc[j] = sc.nextInt();
			for (int j = 0; j < 10; j++) {
				// 최대값의 인덱스
				int max = j;
				for (int k = j + 1; k < 10; k++) {
					if (tc[k] >= tc[max])
						max = k;
				}
				int tmp = tc[j];
				tc[j] = tc[max];
				tc[max] = tmp;
			}
			max_num[i] = tc[0];
		}
		for (int i = 0; i < T; i++)
			System.out.printf("#%d %d\n", i + 1, max_num[i]);
	}
}
