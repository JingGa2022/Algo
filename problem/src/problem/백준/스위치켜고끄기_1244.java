package problem.백준;

import java.util.Arrays;
import java.util.Scanner;

public class 스위치켜고끄기_1244 {
	static int[] status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 스위치 개수
		status = new int[T + 1];// 스위치 상태
		for (int i = 1; i <= T; i++)
			status[i] = sc.nextInt();
		int num = sc.nextInt();// 학생수
		int[][] stu = new int[num][2];// 학생 성별과 누르는 스위치
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 2; j++)
				stu[i][j] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			// 성별을 나누고 그 상황에 맞게 스위치의 변화를고려해보자
			switch (stu[i][0]) {
			case 1:
				int tmp = stu[i][1];
				while (tmp < T) {
					click(tmp);
					tmp += stu[i][1];
				}
				break;

			case 2:
				int dr = 1;
				if (status[stu[i][1] - 1] != status[stu[i][1] + 1]) {
					click(stu[i][1]);
					break;
				} else {
					while (stu[i][1] - dr >= 1 && stu[i][1] + dr <= T) {
						if (status[stu[i][1] - dr] == status[stu[i][1] + dr]) {
							dr++;
						}

					}
					dr -= 1;
					for (int j = stu[i][1] - dr; j <= stu[i][1] + dr; j++) {
						click(j);
					}
				}
				break;
			}// 성별에따라
		} // for문
		for (int i = 1; i <= T; i++) {
			System.out.print(status[i]);
		}
	}// main

	// 전원을 깜빡깜빡
	public static int click(int idx) {
		return status[idx] = 1 - status[idx];
	}
}
