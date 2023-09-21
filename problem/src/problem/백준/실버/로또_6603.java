package problem.백준.실버;

import java.util.*;

public class 로또_6603 {
	static int n;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			n = sc.nextInt();
			if(n==0) break;
			
			arr = new int[n];
			for(int i = 0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			visit = new boolean[n];
			back(0,0);
			
			System.out.println();
		}
	}
	static void back(int start, int dept) {
		if(dept == 6) {
			for(int i = 0; i<n; i++) {
				if(visit[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		for(int i = start; i<n; i++) {			
				visit[i] = true;
				back(i+1, dept + 1);
				visit[i] = false;
		}
	}
	
}	
