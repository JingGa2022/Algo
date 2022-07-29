package problem.백준.class4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class N과M9_15663 {
	static int N,M;
	static int[] arr, sel, check;
	static boolean[] visit;
	static LinkedHashSet<String> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		visit = new boolean[10001];
		sel = new int[M];
		ans = new LinkedHashSet<>();
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		com(0);
		ans.forEach(System.out :: println);
	}
	private static void com(int m) {
		// TODO Auto-generated method stub
		
		if(M == m) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			ans.add(sb.toString());
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visit[i]) continue;
				visit[i]= true;
				sel[m] = arr[i];
				com(m+1);
				visit[i]= false;
			
		}

	}
}
