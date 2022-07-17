package problem.백준.class4;

import java.util.Arrays;
import java.util.Scanner;

public class N과M5_15654 {
	static int n,m;
	static int[] arr;
	static int[] sel;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		sel = new int[m];
		visit = new boolean[n];
		
		for(int i = 0; i<n ;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		pro(0);
	}
	private static void pro(int a) {
		// TODO Auto-generated method stub
		
		if(a == m) {
			for(int val: sel) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i< n ;i++) {
			if(!visit[i]) {
				visit[i] = true;
				sel[a] = arr[i];
				pro(a+1);
				visit[i] = false;
			}
		}
	}
}
