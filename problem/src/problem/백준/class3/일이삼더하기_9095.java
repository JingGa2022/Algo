package problem.백준.class3;

import java.util.Scanner;

public class 일이삼더하기_9095 {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[15];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i<n; i++) {
			ans = 0;
			int m = sc.nextInt();
			//dp(m);
			//System.out.println(ans);
			for(int j = 4; j<=m; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[m]);
		}
	}

	private static void dp(int m) {
		// TODO Auto-generated method stub
		if(m == 0) {
			ans++;
			//System.out.println("0임");
		}
		
		if(m - 1 >= 0) {
			dp(m-1);
			//System.out.println("1빼기");
		}
		if(m - 2 >= 0) {
			dp(m-2);
			//System.out.println("2빼기");
		}
		if(m - 3 >= 0) {
			dp(m-3);
			//System.out.println("3빼기");
		}
		
		return ;
	}

}
