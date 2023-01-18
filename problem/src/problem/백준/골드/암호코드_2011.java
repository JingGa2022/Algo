package problem.백준.골드;

import java.util.Scanner;

public class 암호코드_2011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int MOD = 1000000;
		int dp[] = new int[s.length()+1];
				
		dp[0] = dp[1] = 1;
		
		for(int i = 2 ; i<=s.length(); i++) {
			int one = s.charAt(i-1) - '0';
			
			if(one >=1 && one <= 9) {
				dp[i] = dp[i-1] % MOD;
			}
			
			int two = s.charAt(i-2) - '0';
			
			if(two == 0) continue;
			
			int tmp = two * 10 + one;
			
			if(tmp >= 10 && tmp <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= MOD;
			}
		}
		
		System.out.println(dp[s.length()]%MOD);
	}
}
