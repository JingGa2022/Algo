package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 창용마을무리의개수_7465 {
	static int N, M;
	static int[] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1];
			ans = 0;
			
			for(int i = 1; i<= N; i++) arr[i] = i;
			
			for(int i = 0; i<M; i++) {
				union(sc.nextInt(), sc.nextInt());
			}
			
			for(int i = 1; i<=N; i++) {
				if(i == arr[i]) ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}//main
	static int find(int x) {
		if(x == arr[x]) return x;
		else return find(arr[x]);
	}
	
	static void union(int x, int y) {
		arr[find(y)] = find(x);
	}
}
