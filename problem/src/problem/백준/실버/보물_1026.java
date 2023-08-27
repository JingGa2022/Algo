package problem.백준.실버;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 보물_1026 {
	/* 1.A는 오름차순 B는 내림차순으로 배열
	 * 2.A B를 순서대로 곱한 후 더함 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] A = new int[n];
		Integer[] B = new Integer[n];
		
		for(int i = 0; i<n; i++) A[i] = sc.nextInt();
		for(int i = 0; i<n; i++) B[i] = sc.nextInt();
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());
		
		int sum = 0;
		
		for(int i = 0; i<n; i++) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
	}
}
