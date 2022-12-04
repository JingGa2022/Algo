package problem.백준.class5;

import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기2_12852 {
	static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        dp = new int[n+1];
        int path[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i = 2; i<=n; i++){
            if(i % 3 == 0){
                if(dp[i/3] + 1 < dp[i]){
                    dp[i] = dp[i/3] + 1;
                    path[i] = i/3;
                }
            }
            if(i % 2 == 0){
                if(dp[i/2] + 1 < dp[i]){
                    dp[i] = dp[i/2] + 1;
                    path[i] = i/2;
                }
            }
            if(dp[i-1] + 1 < dp[i]){
                dp[i] = dp[i-1] + 1;
                path[i] = i-1;
            }
        }
        sb.append(dp[n] + "\n");

        while(n > 0){
            sb.append(n + " ");
            n = path[n];
        }
        System.out.println(sb);
    }
}
