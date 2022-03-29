package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 힙_2931_4 {
	static int[] heap;// 힙 구조를 저장할 배열
	static int idx;
	static int N;
	static int pick; //
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 연산의 수
			idx = 0;
			
			heap = new int[N + 1];

			sb.append("#" + tc + " ");
			for (int i = 1; i <= N; i++) {
				if (sc.nextInt() == 1) {
					insert(sc.nextInt());
					change(idx);
				} else {
					sb.append(delete()).append(" ");
					idx--;
					changeTop(1);
				}
				System.out.println(Arrays.toString(heap));
			}
			sb.append("\n");
		} // 테스트케이스
		System.out.println(sb);
	}// main

	public static void insert(int num) {
		heap[++idx] = num;
	}

	public static int delete() {
		if (idx <= 0) {
			idx = 0;
			return -1;
		}
		int a = heap[1];
		heap[1] = heap[idx];
		heap[idx] = 0;
		return a;
	}

	public static void change(int idx) {
		if (idx <= 1) {
			return;
		}
		if (heap[idx] > heap[idx / 2]) {
			int tmp = heap[idx];
			heap[idx] = heap[idx / 2];
			heap[idx / 2] = tmp;
		}
		change(idx / 2);
	}

	public static void changeTop(int index) {
		if (index > idx) {
			return;
		}
		if(index <=idx) {
		//왼쪽 자식 비교
		if (heap[index * 2] >= heap[index*2 + 1] && heap[index] < heap[index * 2]) {
			int tmp = heap[index];
			heap[index] = heap[index * 2];
			heap[index * 2] = tmp;
			change(index * 2);
		} //오른쪽 자식 비교
		else if ( heap[index * 2] <= heap[index*2 + 1] && heap[index] < heap[index*2 + 1]) {
			int tmp = heap[index];
			heap[index] = heap[index *2 +1];
			heap[index *2 +1] = tmp;
			change(index*2 + 1);
		}
		}else return;
	}
}
