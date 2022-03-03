package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 정곤이의단조증가하는수_6190 {
	static boolean flag;// 곱이 단조인지 확인

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 정수의 개수
			int[] A = new int[N];
			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			int times = 0;// 곱
			String num = new String();// 곱을 넣을 문자열 만들기
			int max = 0;
			if (N > 1) {
				for (int i = 0; i < N; i++) {
					for (int j = i + 1; j < N; j++) {
						times = A[i] * A[j];
						if (times > 10) {
							num = Integer.toString(times);
							char[] mono = num.toCharArray(); // 곱을자른것
							flag = true;
							for (int k = 0; k < mono.length - 1; k++) {// 단조증가인지 검사
								if (mono[k] > mono[k + 1])
									flag = false;
							}
						}
						if (flag) {
							if (times > max)
								max = times;// 가장큰 단조증가곱 찾기
						}
					}
				}
			} // N이 1보다 클때
			else {
				times = A[0];
				if (times > 10) {
					num = Integer.toString(times);
					char[] mono = num.toCharArray(); // 곱을자른것
					flag = true;
					for (int k = 0; k < mono.length - 1; k++) {// 단조증가인지 검사
						if (mono[k] > mono[k + 1])
							flag = false;
					}
				}
				if (flag) {
					if (times > max)
						max = times;// 가장큰 단조증가곱 찾기
				}
			} // N이 1일때
			if(max==0) max = -1;//
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
