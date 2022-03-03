package problem;

import java.util.Scanner;

public class 회문1_1215 {
	static int len;
	static char[][] pal;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			len = sc.nextInt();// 찾아야하는 길이
			pal = new char[8][8];
			int ans = 0;
			int far = 0;
			for (int i = 0; i < 8; i++) {
				pal[i] = sc.next().toCharArray();
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					ans += isPal(i,j);
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	} // main

	static int isPal(int y, int x) {
		int cnt = 0;
		if (y <= 8 - len) {
			boolean flag = true;
			int term1 = y;
			int term2 = y + len - 1;
			while (term1 < term2) {
				if (pal[term1][x] != pal[term2][x]) {
					flag = false;
					break;
				}
				++term1;
				--term2;
			}
			if(flag) ++cnt;
		}
		if (x <= 8 - len) {
			boolean flag = true;
			int term1 = x;
			int term2 = x + len - 1;
			while (term1 < term2) {
				if (pal[y][term1] != pal[y][term2]) {
					flag = false;
					break;
				}
				++term1;
				--term2;
			}
			if(flag) ++cnt;
		}
		return cnt;
	}
}
