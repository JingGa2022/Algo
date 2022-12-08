package problem.백준.class5;

import java.util.Scanner;

public class 계단수_1562 {
	static int n;
    static int MOD = 1_000_000_000;
    static long dp[][][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new long[n+1][10][1<<10];
        for(int i = 1; i<=9; i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i = 2; i<=n; i++){
            for(int j = 0; j<=9; j++){
                for(int k = 0; k< 1 << 10; k++){
                    int visit = k | 1<<j;
                    if(j == 0){
                        dp[i][j][visit] += dp[i-1][j+1][k] % MOD;
                    }else if(j == 9){
                        dp[i][j][visit] += dp[i-1][j-1][k] %MOD;
                    }else{
                        dp[i][j][visit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
                    }
                    dp[i][j][visit] %= MOD;
                }
            }
        }
        long sum = 0;
        for(int i = 0; i<=9; i++){
            sum += dp[n][i][(1<<10) - 1];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}