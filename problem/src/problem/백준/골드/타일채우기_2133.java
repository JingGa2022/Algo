package problem.백준.골드;

import java.util.*;

public class 타일채우기_2133 {
	/* 1. 3*2와 3*4로만 채울 수 있음
	 * 2. 3*2의 가짓수는 3개, 3*4의 가짓수는 11개
	 * 3. 2의 배수일떄는 n-2번쨰 전에 3곱하고 4의 배수일때는 앞에 것에 n-4번째 전 내용에 2곱한거 더해주기
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[31];
		if(n % 2 != 0) {
			System.out.println(0);
			return;
		}
		
		dp[0] = 3;
		dp[1] = 11;
		
		int tmp = 0;
		for(int i = 2; i<=15; i++) {
				dp[i] = dp[i-1] * 3 + 2 + (tmp+=dp[i-2]*2);
		}
		
		System.out.println(dp[n/2-1]);
	}
}
