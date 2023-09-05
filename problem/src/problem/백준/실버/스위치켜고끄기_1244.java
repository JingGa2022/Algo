package problem.백준.실버;

import java.util.*;

public class 스위치켜고끄기_1244 {
	static int n, sn;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		n = sc.nextInt();
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		sn = sc.nextInt();
		int[][] student = new int[sn][2];

		for (int i = 0; i < sn; i++) {
			student[i][0] = sc.nextInt();// 성별
			student[i][1] = sc.nextInt();// 스위치수
		}

		for (int i = 0; i < sn; i++) {
			int sex = student[i][0];

			if (sex == 1) {
				man(student[i][1]);
			} else {
				woman(student[i][1]);
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i] + " ");
			if(i % 20 == 0) sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void woman(int cnt) {
		// TODO Auto-generated method stub
		int x = 1;

		if (arr[cnt] == 0)
			arr[cnt] = 1;
		else
			arr[cnt] = 0;

		while ((cnt - x) > 0 && (cnt + x) <= n) {
			if (arr[cnt + x] == arr[cnt - x]) {

				if (arr[cnt - x] == 0) {
					arr[cnt + x] = 1;
					arr[cnt - x] = 1;
				} else if (arr[cnt + x] == 1) {
					arr[cnt + x] = 0;
					arr[cnt - x] = 0;
				}

				x++;
			} else
				break;
		}
	}

	private static void man(int cnt) {
		// TODO Auto-generated method stub
		int x = 1;
		while (cnt * x <= n) {
			arr[cnt * x] = Math.abs(arr[cnt * x] - 1);
			x++;
		}
	}
}
