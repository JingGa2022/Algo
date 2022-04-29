package problem.백준.class2;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 수정렬하기2_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//힙 사용
		
		int N = sc.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int[] arr = new int[N];
		
		//배열의 힙으로 만든다.
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			heap.add(arr[i]);
		}
		
		for(int i =0; i<N; i++) sb.append(heap.poll()).append("\n");
		
		System.out.println(sb);
		
	}// main
}
