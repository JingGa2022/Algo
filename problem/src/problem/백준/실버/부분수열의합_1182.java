package problem.백준.실버;

import java.util.*;

public class 부분수열의합_1182 {
	
	/* 1. 1개 뽑기부터 n개 까지 뽑아볼꽈 
	 * 2. 뽑을 수 있는 경우의 수는 2^n개 뽑거나 안뽑거나의 방식으로 트리를 분화하여 n깊이 까지 가면됨
	 * 3. 다 더하믄 됨
	 */
	static int n, s, ans;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
		
		
			solve(0, 0);
		
		System.out.println(s == 0 ? ans-1 : ans);
		
	}
	static void solve(int dept, int sum) {
		if(dept == n) {
			if(sum == s) ans++;
			return;
		}		
		solve(dept+1, sum + arr[dept]);
		solve(dept+1, sum);
	}
}
