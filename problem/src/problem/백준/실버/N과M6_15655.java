package problem.백준.실버;

import java.util.*;

public class N과M6_15655 {
	/* 1. 순서 정렬하고
	 * 2. 앞부터 조합으로 ㄱㄱ
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
		
		solve(0, 0);
		
		System.out.println(sb);
	}
	static void solve(int start, int dept) {
		if(dept == m) {
			for(int i = 0; i<m; i++) sb.append(pick[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<n; i++) {
			pick[dept] = arr[i];
			solve(i+1, dept+1);
		}
	}
}
