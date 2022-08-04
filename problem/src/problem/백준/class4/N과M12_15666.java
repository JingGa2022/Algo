package problem.백준.class4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class N과M12_15666 {
	static LinkedHashSet<String> ans;
	static int N, M;
	static int[] arr, sel;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		sel = new int[M];
		
		for(int i = 1; i<=N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		com(1, 0);
		System.out.println(sb);
	}
	private static void com(int start, int m) {
		// TODO Auto-generated method stub
		if(M == m) {
			for(int i = 0; i<m; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = start; i<=N; i++) {
			if(arr[i -1]== arr[i]) continue;
				sel[m] = arr[i];
				com(i,m+1);
		}
		
	}
}
