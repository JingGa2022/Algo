package problem.APS심화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 보호필름_2112_2 {
	static int D, W, K;
	static int[][] pf;
	static boolean check;
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
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					pf[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dispenser(0, 0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		//결과출력
	}// main

	private static void dispenser(int a, int cnt) {
		if (test()) {
			
			if(ans > cnt) ans = cnt;
			
			return;
		}
		
		if(cnt > ans) return;
		
		if(a == D) return;
		
		int[] tmp = new int [W];
		
		for(int i =0; i<W; i++) tmp[i] = pf[a][i];
		
		//진행
		dispenser(a+1, cnt);
		
		//현재행에 A 넣기
		for(int i =0; i<W; i++)
			pf[a][i] = 0;
		dispenser(a + 1, cnt+1);
		
		//현재행에 B넣기
		for(int i =0; i<W; i++)
			pf[a][i] = 1;
		dispenser(a + 1, cnt+1);
		
		//원복
		pf[a] = Arrays.copyOf(tmp, W);
	}// dispenser


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
