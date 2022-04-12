package problem.APS심화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 보호필름_2112 {
	static int D, W, K;
	static int[][] pf;
	static int[][] origin;
	static boolean[] sel;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ans = D;
			sel = new boolean[D];

			pf = new int[D][W];
			origin = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					pf[i][j] = Integer.parseInt(st.nextToken());
					origin[i][j] = pf[i][j];
				}
			}

			dispenser(0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		//결과출력
		System.out.println(sb);
	}// main

	private static void dispenser(int a) {
		if (a == D || test()) {
			
			shot(0);
			
			return;
		}

		if (!test()) {
			sel[a] = false;// 비었을때
			dispenser(a + 1);
			sel[a] = true; // 0주사
			dispenser(a + 1);
		}
	}// dispenser

	// 0 1주사를 쏴주는
	static void shot(int i) {
		if (i == D) {
			int tmp = 0;// 샷 횟수 저장용
			for(int a = 0; a < D; a++) {
				if(sel[a]) tmp++;
			}
			test();
						
			if (test()) {
				if (tmp < ans)
					ans = tmp;
			}
			return;
		}
		
		if (sel[i]) {
		change(i, 0);
		shot(i + 1);
		change(i, 1);
		shot(i + 1);
		for(int h = 0; h < D; h++)
			pf[h] = Arrays.copyOf(origin[h], W);
		return;
		}
		
		shot(i + 1);
//		for(int h = 0; h < D; h++)
//			pf[h] = Arrays.copyOf(origin[h], W);
	}

	private static void change(int a, int medi) {
		for (int i = 0; i < W; i++) {
			pf[a][i] = medi; // 0이면 1로 1이면 0으로
		}
	}

	private static boolean test() {
		for (int i = 0; i < W; i++) {
			boolean flag = false;
			int cnt = 1;
			for (int j = 1; j < D; j++) {
				if (pf[j][i] == pf[j - 1][i])
					cnt++;
				else cnt = 1;
					
				if (cnt == K) {
					flag = true;// 합격기준보다 연속성이 같으면  테스트 성공 나가기
					break;
				}
			}
			if (!flag)
				return false;// 합격기준보다 연속성이 작으면 테스트 실패
		}
		return true;
	}// test
}// class
