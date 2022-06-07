package problem.정올.Beginner;

import java.util.Arrays;
import java.util.Scanner;

public class 최대공약수_최소공배수_1002 {
	static int[] arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int gcd = arr[0];
		int lcm = arr[0];
		
		for(int i = 0; i<n; i++) {
			gcd = gcd_get(gcd, arr[i]);
			lcm = lcm/gcd_get(lcm, arr[i]) * arr[i];
		}
		
		System.out.printf("%d %d",gcd, lcm);
	}//main
	
	static private int gcd_get(int a, int b) {
		int tmp = 0;
		for(int i =1; i<=arr[n-1]; i++) {
			if(a % i == 0 && b % i ==0) {
				tmp = i;
			}
		}
		return tmp;
	}
	
}
