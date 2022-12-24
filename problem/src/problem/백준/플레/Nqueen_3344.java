package problem.백준.플레;

import java.util.Scanner;

public class Nqueen_3344 {
	static int n, ans;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		nQueen(0);
		
		System.out.println(ans);
	}
	private static void nQueen(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == n) {
			ans++;
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[cnt] = i;
			if(backtrack(cnt)) {
				nQueen(cnt + 1);
			}
		}
	}
	private static boolean backtrack(int idx) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<idx; i++) {
			if(arr[idx] == arr[i] || idx - i == Math.abs(arr[idx] - arr[i])) 
				return false;
		}
		
		return true;
	}
}
