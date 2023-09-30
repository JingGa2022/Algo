package problem.백준.실버;

import java.util.*;

public class N과M7_15656 {
	/* 1. 같은 수 여러번 골라도 되는 모든 수열
	 */
	static int n,m;
	static int[] arr, pick;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		pick = new int[m];
		for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		solve(0);
		
		System.out.println(sb);
	}
	static void solve(int dept) {
		if(dept == m) {
			for(int a : pick)
				sb.append(a + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<n; i++) {
			pick[dept] = arr[i];
			solve(dept+1);
		}
	}
}
