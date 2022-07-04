package problem.백준.class3;

import java.util.Scanner;

public class 일로만들기_1463 {
	static Integer[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new Integer[n+1];
		
		dp[0] = dp[1] = 0;
		
		System.out.println(make(n));
	}
	private static int make(int n) {
		
		if(dp[n] == null) {
			if(n % 6 == 0) {
				dp[n] = Math.min(make(n-1 ), Math.min(make(n / 3 ), make(n /2 ))) +1 ;
			}else if(n % 3 == 0){
				dp[n] = Math.min(make(n / 3 ), make(n - 1 ))+1;
				
			}else if(n % 2 == 0){
				dp[n] = Math.min(make(n -1 ), make(n /2 ))+1;
				
			}
			else {
				dp[n] = make(n-1 )+1;
			}
			
		}
		return dp[n];
	}
}
