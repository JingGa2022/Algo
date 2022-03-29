package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	static int[] heap;// 힙 구조를 저장할 배열
	static int idx;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 연산의 수
			heap = new int[100001];
			idx = 0;// 마지막 노드가 있는 곳
			sb.append("#" + tc + " ");
			for (int i = 1; i <= N; i++) {
				int order = sc.nextInt();// 명령
				// 삽입
				if (order == 1) {
					heap[++idx] = sc.nextInt();//
					int heapIdx = idx;
					while (heapIdx > 1) {
						if (heap[heapIdx] > heap[heapIdx / 2]) {
							int tmp = heap[heapIdx];
							heap[heapIdx] = heap[heapIdx / 2];
							heap[heapIdx / 2] = tmp;
							heapIdx /= 2;
						}
					}
				} // 삭제
				else if (order == 2) {
					//루트원소삭제
					sb.append(heap[1]).append(" ");
					heap[1] = heap[idx];
					heap[idx--] = 0;
					/////////
					int heapIdx = 1;
					while (heapIdx * 2<= idx || heapIdx * 2+1<= idx || idx<=0) {
						if(idx <= 0) {
							sb.append("-1").append(" ");
							idx = 0;
							heapIdx = idx;
							break;
						}
						if (heapIdx * 2<= idx && heap[heapIdx] < heap[heapIdx * 2]) {
							int tmp = heap[heapIdx];
							heap[heapIdx] = heap[heapIdx * 2];
							heap[heapIdx * 2] = tmp;
							heapIdx *= 2;
						} else if (heapIdx * 2 +1<= idx && heap[heapIdx] < heap[heapIdx * 2 +1]) {
							int tmp = heap[heapIdx];
							heap[heapIdx] = heap[heapIdx * 2 +1];
							heap[heapIdx * 2 +1] = tmp;
							heapIdx = heapIdx*2 +1;
						}
					}
				}
			}
			sb.append("\n");
		} // for
		System.out.println(sb);
	}// main
}