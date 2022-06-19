package problem.백준.class3;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int[] sarr = new int[n];
		
		int ans = 0;
		
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				ans += arr[j];
			}
		}
		
		System.out.println(ans);
	}
}
