package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] idx = new int[1000001]; // N에 가능한 수의 범위

		for (int tc = 0; tc < N; tc++) {
			idx[Integer.parseInt(br.readLine())]++;
		}

		br.close();

		// 0은 없으므로 1부터 시작한다
		for (int i = 1; i < 1000001; i++) {
			while (idx[i] > 0) {
				sb.append(i).append("\n");
				idx[i]--;
			}
		}
		
		System.out.println(sb);
	}// main
}
