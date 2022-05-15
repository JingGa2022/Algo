package problem.백준.class2;

import java.util.Scanner;

public class 랜선자르기_1654 {
	static int K, N;
	static long t, b;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		N = sc.nextInt();
		t = 0;
		b = 0;

		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (t < arr[i])
				t = arr[i];
		}

		t++;
		
		while (b < t) {
			long mid = (t + b) / 2;
			
			int sum = 0;
			
			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}
			if(sum < N ) {
				t = mid;
			}else
				b = mid+1;
		}
		
		System.out.println(b-1);
	}// main

}
