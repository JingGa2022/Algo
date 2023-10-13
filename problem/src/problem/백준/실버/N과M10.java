package problem.백준.실버;

import java.util.*;

public class N과M10 {
	/* 1.정렬한 다음 뽑기
	 *  2.전에 뽑은것보다 무조건 큰것만
	 */
	static int n, m;
	static int[] arr, print;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		print = new int[n];
		visit = new boolean[n];
		
		for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		solve(0, 0);
		
		System.out.println(sb);
	}
	static void solve(int start, int dept) {
		if(dept == m) {
			for(int i = 0; i<m; i++)
				sb.append(print[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		int before = -1;
		for(int i = start; i<n; i++) {
			int now = arr[i];
			if(before == now || visit[i]) continue;
			else {
				before = now;
				visit[i] = true;
				print[dept] = arr[i];
				solve(i+1, dept + 1);
				visit[i] = false;
			}
		}
		
		
	}
}
