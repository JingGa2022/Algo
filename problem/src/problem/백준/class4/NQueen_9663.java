package problem.백준.class4;

import java.util.Scanner;

public class NQueen_9663 {
	static int[] arr;
	static int n;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		nQueen(0);
		
		System.out.println(count);
	}
	private static void nQueen(int dep) {
		// TODO Auto-generated method stub
		if(dep == n) {
			count++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[dep] = i;
			if(possibility(dep)) nQueen(dep+1);
		}
		
	}
	private static boolean possibility(int col) {
		for(int i = 0; i<col; i++) {
			if(arr[col] == arr[i]){
				return false;
			}else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
