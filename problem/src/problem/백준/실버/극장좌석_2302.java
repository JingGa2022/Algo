package problem.백준.실버;

import java.util.Scanner;

public class 극장좌석_2302 {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int[] dp = new int[41];

	        dp[0] = 1;
	        dp[1] = 1;
	        dp[2] = 2;

	        for(int i = 3; i<=n; i++){
	            dp[i] = dp[i-2] + dp[i-1];
	        }

	        int ans = 1;
	        int prev = 0;
	        for(int i = 0; i<m; i++){
	            int tmp = sc.nextInt();
	            ans *= dp[tmp - prev - 1];
	            prev = tmp;
	        }
	        ans *= dp[n - prev];

	        System.out.println(ans);
	    }
}
