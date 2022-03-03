package problem;

import java.util.Scanner;

public class 연속된_1의_개수_중_최대값_구하기_13636 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 개수
		int T = sc.nextInt();
		//
		for (int tc = 1; tc <= T; tc++) {
			// 수열을 넣는 배열
			int N = sc.nextInt();
			// 숫자를 문자로 읽는
			String num = sc.next();
			// 한개씩 잘라서 넣어줌
			char[] box = num.toCharArray();
			int cnt = 0;
			int max = 0;
			// 연속된 1의 개수 구하기
			for (int i = 0; i < box.length; i++) {
				if (Character.toString(box[i]).equals("1")) {
					cnt++;
					if (cnt > max)
						max = cnt;
				} else
					cnt = 0;
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
