package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트_18111_2 {
	static int n, m, b;
	static Integer[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = 652156345;

		arr = new Integer[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > max)
					max = arr[i][j];
				if (arr[i][j] <= min)
					min = arr[i][j];
			}
		}

		int answerT = Integer.MAX_VALUE;
		int answerH = -1;

		for (int i = min; i <= max; i++) {
			int time = 0;
			int inventory = b;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					int diff = arr[j][k] - i;

					if (diff > 0) {
						time += 2 * diff;
						inventory += diff;
					} else if (diff < 0) {
						time -= diff;
						inventory += diff;
					}
				}
			}
			
			if (inventory >= 0) {
				if (answerT >= time) {
					answerT = time;
						answerH = i;
					
				}
			}
		} // for
		System.out.println(answerT +" "+ answerH);
	}// main
}
