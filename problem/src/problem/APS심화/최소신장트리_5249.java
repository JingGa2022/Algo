package problem.APS심화;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소신장트리_5249 {
	static int[] arr;
	static int[][] edge;
	static int V, E, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			arr = new int[V+1];
			edge = new int[E][3];
			ans = 0;
			
			//make set
			for(int i = 0; i<=V; i++) arr[i] = i;
			
			//edge info
			for(int i =0; i<E; i++) {
				for(int j =0; j<3; j++) edge[i][j] = sc.nextInt();
			}
			
			Arrays.sort(edge, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			
//			int pick = 0;
			for(int i = 0; i<E; i++) {
				int nx = find(edge[i][0]);
				int ny = find(edge[i][1]);
//				System.out.println(nx+" "+ny);
				if(nx != ny) {
					ans += edge[i][2];
					union(edge[i][0], edge[i][1]);
//					pick++;
				}
//				if(pick == V-1) break;
			}
			
			System.out.println("#"+tc+" "+ans);
		}//tc
	}//main
	
	static int find(int x) {
		if(x != arr[x]) return arr[x] = find(arr[x]);
		return x;
	}
	
	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return;
		
		arr[ny] = nx;
		
	}
}
