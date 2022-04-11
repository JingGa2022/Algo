package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 서로소집합_3289 {
	static int N, M;
	static int[] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+" ");
			
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1];
			ans = 0;
			
			//대표값 초기화하기
			for(int i = 1; i<= N; i++) arr[i] = i;
			
			//들어오는 친구들 확인하기
			for(int i = 0; i<M; i++) {
				int order = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(order == 1)
					{
					int na = find(a);
					int nb = find(b);
					if(na == nb)
						sb.append(1);
					else
						sb.append(0);
				}
				else union(a,b);
			}
			
			System.out.println(sb);
		}
	}//main
	static int find(int x) {
		if(x == arr[x]) return x;
		else return arr[x] = find(arr[x]);
	}
	
	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return;
		
		arr[find(y)] = find(x);
	}
}
