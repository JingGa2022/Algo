package problem.정올.Beginner;

import java.util.Scanner;

public class 최대공약수_최소공배수_1002 {
	static int[] arr;
	static int n, gcd, lcm;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		gcd = arr[0];
		lcm = arr[0];
		
		for(int i = 0; i<n; i++) {
			gcd_get(gcd, arr[i]);
			lcm = lcm/
		}
		
		
	}//main
	
	static private int gcd_get(int a, int b) {
		int tmp = 0;
		for(int i =1; i<=arr[n-1]; i++) {
			if(a % i == 0 && b % i ==0) {
				gcd = i;
				tmp = i;
			}
		}
		return ;
	}
	
}
