package problem.백준.class4;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의부모찾기_11725 {
	static int n ;
	static int[] sel;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) arr[i] = new ArrayList<Integer>();
		
		sel = new int[n+1];
		
		for(int i = 0 ;i<n-1; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
			dfs(1,0);
			for(int i = 2; i<=n; i++)
				System.out.println(sel[i]);
	}
	private static void dfs(int start, int parent) {
		sel[start] = parent;
		for(int item: arr[start]) {
			if(item != parent) dfs(item, start);
		}
	}
}
