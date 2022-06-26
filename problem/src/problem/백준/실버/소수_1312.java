package problem.백준.실버;

import java.util.Scanner;

public class 소수_1312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int n = sc.nextInt();
		
		int ans = a%b;
		
		for(int i = 0; i<n-1; i++) {
			ans *= 10;
			ans %= b;
		}
		
		ans *= 10;
		System.out.println(ans/b);
	}
}
