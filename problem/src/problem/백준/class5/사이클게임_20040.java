package problem.백준.class5;

import java.util.Scanner;

public class 사이클게임_20040 {
	static int x, y, tmp, parents[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		parents = new int[x];
		
		for(int i = 0; i< x; i++) parents[i] = i;
		
		for(int i = 1; i <= y; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(!union(a, b)) {
				tmp = i;
				break;
			}
		}
		
		System.out.println(tmp);
		
	}
	static boolean union(int x, int y) {
		int a = find_root(x);
		int b = find_root(y);
		
		if(a == b) return false;
		parents[b] = a;
		return true;
	}
	
	static int find_root(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find_root(parents[x]);
	}
}
