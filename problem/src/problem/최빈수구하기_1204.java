package problem;

import java.util.Scanner;

public class 최빈수구하기_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �׽�Ʈ���̽��Է� ���� ���� �迭
		int T = sc.nextInt();
		int[] score = new int[1000];

		for (int k = 1; k <= T; k++) {
			// �׽�Ʈ ���̽� �Է�
			int TC = sc.nextInt();
			// ���� �󵵹迭
			int[] fre_score = new int[101];
			// nBox�� ���� �ֱ�
			for (int i = 0; i < 1000; i++)
				score[i] = sc.nextInt();
			// 0~100���� �� ������ ��ִ��� ����
			for (int i = 0; i <= 100; i++) {
				// ������ �� ����
				for (int j = 0; j < 1000; j++) {
					frequency(score, i, j, fre_score);
				}
			}
			// �ִ밪�� �ε���
			int maxV = 0;
			// ���� �� �ִ밪 ���ϱ�
			for (int i = 0; i <= 100; i++) {
				if (max(fre_score[i], fre_score[maxV]))
					maxV = i;
			}
			System.out.printf("#%d %d\n", TC, maxV);
		}

	}

	// �󵵱��ϴ� �޼��� ����
	static void frequency(int[] score, int i, int j, int[] fre_score) {
		if (score[j] == i)
			fre_score[i]++;
	}

	// �ִ밪 �޼��� ����
	static boolean max(int a, int b) {
		if (a >= b)
			return true;
		else
			return false;
	}
}
