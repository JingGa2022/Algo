package problem.백준.골드;

import java.util.*;

public class 수나누기게임_27172 {
	/* 1. 에라토스테네스의 체를 거르듯 배수인지를 구해본다.
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int INF = 0;
		int[] arr = new int[n]; // 카드 넣는곳
		for(int i = 0; i<n; i++) INF = Math.max(INF, arr[i] = sc.nextInt());
		
		int[] ans = new int[n+1];
		int[] filter = new int[INF+1];
		for(int i = 0; i<n; i++) filter[arr[i]] = i+1;
		for(int m : arr) for(int i = m * 2; i<=INF; i+=m) {
			if(filter[i] != 0) {
				ans[filter[i]] --;
				ans[filter[m]] ++;
			}
		}
		
		for(int i = 1; i<n+1; i++) sb.append(ans[i] + " ");
		System.out.println(sb);
	}
}
