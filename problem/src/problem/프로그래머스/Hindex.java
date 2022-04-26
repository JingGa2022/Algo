package problem.프로그래머스;

import java.util.Arrays;

public class Hindex {
	public static void main(String[] args) {
		int[] arr = { 3, 0, 6, 1, 5 };

		System.out.println(solution(arr));
	}

	static public int solution(int[] citations) {
		int answer = 0;
		int max = 0;
		int len = citations.length - 1;

		Arrays.sort(citations);

		for (int j = 0; j <= citations[len - 1]; j++) {
			int cntU = 0;
			int cntD = 0;
			boolean flag = false;
			for (int i = len; i >= 0; i--) {
				if (citations[i] >= j) {
					cntU++;
				}
				if (citations[i] <= j) {
					cntD++;
				}
			}
			if (cntU >= j && cntD <= j) flag = true;
			
			if(j > max && flag) max = j;
		}
		answer = max;
		return answer;
	}
}
