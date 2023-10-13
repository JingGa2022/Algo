package problem.백준.골드;

import java.util.*;

public class 다각형의면적_2166 {
	/* 1. 신발끈의 공식을 활용해 다각형 면적 구하기
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] x = new long[n+1];
		long[] y = new long[n+1];
		long sum_a = 0, sum_b = 0;
		
		for(int i = 0; i<n; i++) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		
		x[n] = x[0];
		y[n] = y[0];
		
		for(int i =0; i<n; i++) {
			sum_a += x[i] * y[i+1];
			sum_b += x[i+1] * y[i];
		}
		
		String ans = String.format("%.1f", (Math.abs(sum_a - sum_b)) / 2.0);
		
		System.out.println(ans);
	}
}
