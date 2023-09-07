package problem.백준.실버;

import java.util.*;

public class 주식_11501 {
	/* 1. 뒤부터 주식의 값이 제일 비싼 값을 저장 
	 * 2. 돌다가 더 적은 값이면 주식매도 아니면 비싼값 갱신 
	 * 3. 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t<T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			int h = 0;
			long ans = 0;
			
			for(int i = 0; i<n; i++) {
				arr[i] = sc.nextInt();			
			}
			
			for(int i = n-1; i>= 0; i--) {
				if(arr[i] > h) {
					h = arr[i];
				}else
					ans += (h - arr[i]);
			}
			System.out.println(ans);
			
		}
	}
}
