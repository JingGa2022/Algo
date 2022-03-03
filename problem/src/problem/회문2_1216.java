package problem;

import java.util.Scanner;

public class 회문2_1216 {
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
			int maxL = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (100 - Math.min(i, j) <= maxL)
						continue;
					maxL = Math.max(maxL, maxPal(box, i, j));
				}
			}
			System.out.printf("#%d %d\n", t, maxL);
		}
	}

	// 회문의 최고길이를 확인하는 메서드
	public static int maxPal(char[][] box, int y, int x) {
		int max = 0;
		int p1 = x;
		int p2 = 99;
		while (p1 <= p2) {
			if (box[y][p1] != box[y][p2]) {
				p2--;
				continue;
			}
			int tmp = p2;
			boolean flag = true;
			while (p1 <= p2) {
				if (box[y][p1] != box[y][p2]) {
					flag = false;
					break;
				}
				p1++;
				p2--;
			}
			p1 = x;
			p2 = tmp - 1;
		}
		p1 = y;
		p2 = 99;
		while (p1 <= p2) {
			if (box[p1][x] != box[p2][x]) {
				p2--;
				continue;
			}
			int tmp = p2;
			boolean flag = true;
			while (p1 <= p2) {
				if (box[p1][x] != box[p2][x]) {
					flag = false;
					break;
				}
				p1++;
				p2--;
			}
			if (flag) {
				max = Math.max(max, tmp - y + 1);
				break;
			}
			p1 = y;
			p2 = tmp - 1;
		}
		return max;

	}

}