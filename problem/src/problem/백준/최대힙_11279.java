package problem.백준;

import java.util.Scanner;

public class 최대힙_11279 {
	static int[] heap;// 힙 구조를 저장할 배열
	static int idx;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();// 연산의 수
		heap = new int[N + 1];
		idx = 0;// 마지막 노드가 있는 곳
		for (int i = 1; i <= N; i++) {
			int order = sc.nextInt();// 명령
			// 삽입
			if (order != 0) {
				heap[++idx] = order;
				int hidx = idx;
				while (hidx > 1) {
					if (heap[hidx] > heap[hidx / 2]) {
						int tmp = heap[hidx];
						heap[hidx] = heap[hidx / 2];
						heap[hidx / 2] = tmp;
						hidx /= 2;
					} else
						break;
				}
			} // 삭제
			else if (order == 0) {
				if (idx <= 0) {
					sb.append("0").append("\n");
					idx = 0;
				} else {
					sb.append(heap[1]).append("\n");
					heap[1] = heap[idx];
					heap[idx--] = 0;
				}
			}
			int hidx = 1;
			while (hidx * 2 <= idx) {
				// 왼쪽 자식 비교
				if (heap[hidx * 2] >= heap[hidx * 2 + 1] && heap[hidx] <= heap[hidx * 2]) {
					int tmp = heap[hidx];
					heap[hidx] = heap[hidx * 2];
					heap[hidx * 2] = tmp;
					hidx = hidx * 2;

				} // 오른쪽 자식 비교
				else if (heap[hidx * 2] <= heap[hidx * 2 + 1] && heap[hidx] <= heap[hidx * 2 + 1]) {
					int tmp = heap[hidx];
					heap[hidx] = heap[hidx * 2 + 1];
					heap[hidx * 2 + 1] = tmp;
					hidx = hidx * 2 + 1;

				} else
					break;

			}
		} // for
		System.out.println(sb);
	}// main
}
