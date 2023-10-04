package problem.백준.실버;

import java.util.*;

public class 수들의합2_2003 {
	/* 1. 기본적인 투포인터로 값을 더하다가 m보다 크면 시작점 옮기고 작으면 끝점 옮기기 반복
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m =sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
		
		int s=0, e=0, sum =0, cnt=0;
		
		while(true) {
			if(sum>=m) {
				sum -= arr[s++];
			}else if(e==n) break;
			else sum += arr[e++];
			
			if(sum==m) cnt++;
		}
		System.out.println(cnt);
		
	}
}
