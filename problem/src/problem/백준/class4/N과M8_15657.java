package problem.백준.class4;

import java.util.Arrays;
import java.util.Scanner;

public class N과M8_15657 {
	static int n,m;
	static int[] arr, sel;
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
		
		permu(0);
	}
	private static void permu(int a) {
		// TODO Auto-generated method stub
		if(a == m) {
			boolean flag = false;
			for(int i = 0; i<m-1; i++) {
				if(sel[i] > sel[i+1]) flag = true;
			}
			if(!flag) {
				for(int num: sel) {
					System.out.printf("%d ",num);
				}
				System.out.println();
			}
			return;
		}
		for(int i = 0; i<n; i++) {
			
		if(!visit[i]) visit[i] = true;
		sel[a] = arr[i];
		permu(a+1);
		visit[i] = false;
		}
	}
}
