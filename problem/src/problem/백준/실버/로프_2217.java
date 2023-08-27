package problem.백준.실버;

import java.util.Arrays;
import java.util.Scanner;

public class 로프_2217 {
	static int n;
	static long max;
	static int[] list; 
	
	/* 1. 숫자를 크기순으로 정렬한다.
	 * 2. 사용한 갯수와 최소치와 로프갯수를 곱한 최대중량을 구한다.
	 * 3. 계속해서 구하면서 최대중량을 업데이트한다.
	 * 4. 답을 출력한다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		list = new int[n];
		
		for(int i = 0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		
		for(int i = n - 1; i >= 0; i--) {
			max = Long.max(max, list[i] * (n-i));
		}
		
		System.out.println(max);
	}
}
