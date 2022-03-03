package problem;

import java.util.Scanner;

public class 회문2_1217_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] box = new char[100][100];
		// 테스트케이스만큼 돌기
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			// 100칸에 숫자 집어넣기
			for (int i = 0; i < 100; i++) {
				// 숫자열 넣어주기
				box[i] = sc.next().toCharArray();
			}

		}
	}
}