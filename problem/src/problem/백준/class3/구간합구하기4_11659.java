package problem.백준.class3;

import java.util.Scanner;

public class 구간합구하기4_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		int[] sarr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(i == 0) sarr[i] = arr[i];
			else sarr[i] = arr[i] + sarr[i-1];
		}
		
		for(int i = 0; i<m; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int sum = 0;
			
			if(from == 0) sum = sarr[to];
			else sum = sarr[to] - sarr[from-1];
			System.out.println(sum);
		}
	}
}
