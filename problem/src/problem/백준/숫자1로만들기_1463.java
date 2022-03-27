package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자1로만들기_1463 {
	static Integer[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int N = Integer.parseInt(br.readLine());

		dp = new Integer[N+1];
		dp[0] = dp[1] = 0;
		
		System.out.println(small(N));
	}
	
	static int small(int N) {
		if(dp[N] == null) {
			//6으로 나눠지는 경우
			if(N % 6 ==0) {
				dp[N] = Math.min(small(N - 1), Math.min(small(N / 3), small(N/2)))+1;
			}
			// 3으로만 나눠지는 경우
			else if(N % 3 ==0) {
				dp[N] = Math.min(small(N - 1), small(N / 3))+1;
			}
			// 2로만 나눠지는 경우
			else if(N % 2 ==0) {
				dp[N] = Math.min(small(N - 1), small(N/2))+1;
			}
			// 2 3 둘다 안되는 경우
			else{
				dp[N] = small(N - 1)+1;
			}
		}
		return dp[N];
	}
}
