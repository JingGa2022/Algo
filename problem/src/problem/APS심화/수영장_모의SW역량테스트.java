package problem.APS심화;

import java.nio.channels.SelectableChannel;
import java.util.Arrays;
import java.util.Scanner;

public class 수영장_모의SW역량테스트 {
	static class Price {
		int pd, pm, p3m, py;

		public Price(int pd, int pm, int p3m, int py) {
			super();
			this.pd = pd;
			this.pm = pm;
			this.p3m = p3m;
			this.py = py;
		}
	}

	static int[] plan;
	static int maxD;
	static int ans;
	static int[] ticket = { 1, 2, 3 };// 1은 1일권, 2는 한달권, 3은 3개월권
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			Price price = new Price(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			ans = price.py;
			plan = new int[13];// 달별 이용 횟수 저장
			maxD = 0;// 전체 일수
			sel = new int[13];

			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
				maxD += plan[i];
			}
			// 월마다 계산해보기
			cal(price, 1);
			
			System.out.println("#"+tc+" "+ans);
		}
	}// main

	static void cal(Price p, int m) {
		if (m > 12) {
			int tmp = 0;
			for (int i = 1; i <= 12; i++) {
				switch (sel[i]) {
				case 1:
					tmp += plan[i] * p.pd;
					break;
				case 2:
					tmp += p.pm;
					break;
				case 3:
					i += 2;
					tmp += p.p3m;
					break;
				}
				
			}
			
			if(tmp < ans) ans = tmp;
			return;
		}
		if (plan[m] != 0) {
			for (int i = 0; i < 3; i++) {
				sel[m] = ticket[i];
				// 그 달에 일일권을 선택했을때
				if (sel[m] == 1) {
					cal(p, m + 1);
				} // 그 달에 한달권을 선택했을때
				else if (sel[m] == 2) {
					cal(p, m + 1);
				} // 그 달에 3개월권을 택했을때
				else {
					
					cal(p, m + 3);
				}
			}
		}
		cal(p, m + 1);
	}
}// class
