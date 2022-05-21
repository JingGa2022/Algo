package problem.백준;

import java.util.Arrays;
import java.util.Scanner;

public class 스위치켜고끄기_1244 {
	static int[] status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// ����ġ ����
		status = new int[T + 1];// ����ġ ����
		for (int i = 1; i <= T; i++)
			status[i] = sc.nextInt();
		int num = sc.nextInt();// �л���
		int[][] stu = new int[num][2];// �л� ������ ������ ����ġ
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 2; j++)
				stu[i][j] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			// ������ ������ �� ��Ȳ�� �°� ����ġ�� ��ȭ������غ���
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
			}// ����������
		} // for��
		for (int i = 1; i <= T; i++) {
			System.out.print(status[i]);
		}
	}// main

	// ������ ��������
	public static int click(int idx) {
		return status[idx] = 1 - status[idx];
	}
}
