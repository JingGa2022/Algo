package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 힙_2931_3 {
	static int[] heap;// 힙 구조를 저장할 배열
	static int idx;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 연산의 수
			heap = new int[N+1];
			idx = 0;// 마지막 노드가 있는 곳
			sb.append("#" + tc + " ");
			for (int i = 1; i <= N; i++) {
				int order = sc.nextInt();// 명령
				// 삽입
				if (order == 1) {
					heap[++idx] = sc.nextInt();
//					int hIdx = idx; // idx잠시 저장
					int hidx = idx;
					while(hidx>1) {
						if(heap[hidx] > heap[hidx/2]) {
							int tmp = heap[hidx];
							heap[hidx] = heap[hidx/2];
							heap[hidx/2] = tmp;
							hidx /=2;
						}else break;
					}
				} // 삭제
				else if (order == 2) {
//					System.out.println(Arrays.toString(heap));
					if(idx <= 0) {
						sb.append("-1").append(" ");
						idx = 0;
					}else {
					//루트원소삭제
					sb.append(heap[1]).append(" ");
					heap[1] = heap[idx];
					heap[idx--] = 0;
//					System.out.println(idx);
//					System.out.println(Arrays.toString(heap));
					/////////
					}
					int hidx = 1;
					while(hidx*2 <= idx) {
						//왼쪽 자식 비교
						if (heap[hidx * 2] >= heap[hidx*2 + 1] && heap[hidx] <= heap[hidx * 2]) {
							int tmp = heap[hidx];
							heap[hidx] = heap[hidx * 2];
							heap[hidx * 2] = tmp;
							hidx = hidx*2;
//							System.out.println("정렬왼자"+Arrays.toString(heap));
						} //오른쪽 자식 비교
						else if ( heap[hidx * 2] <= heap[hidx*2 + 1] && heap[hidx] <= heap[hidx*2 + 1]) {
							int tmp = heap[hidx];
							heap[hidx] = heap[hidx *2 +1];
							heap[hidx *2 +1] = tmp;
							hidx = hidx*2+1;
//							System.out.println("정렬오자"+Arrays.toString(heap));
					
						}else break;
//			
//						System.out.println("정렬"+Arrays.toString(heap));
					}
				}
			}
			sb.append("\n");
		} // for
		System.out.println(sb);
	}// main
}