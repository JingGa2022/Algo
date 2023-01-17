package problem.백준.골드;

import java.util.Arrays;
import java.util.Scanner;

public class 동전2_2294 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        final int INF = 987654;
	        int coin[] = new int[101];
	        int dp[] = new int[100001];
	        Arrays.fill(dp, INF);

	        for(int i = 0; i<n; i++) {
	            coin[i] = sc.nextInt();
	            dp[coin[i]] = 1;
	        }

	        for(int i = 1; i<=k; i++){
	            for(int j = 0; j<n; j++){
	                if(i >= coin[j]){
	                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
	                }
	            }
	        }

	        if(dp[k] == INF) System.out.println(-1);
	        else System.out.println(dp[k]);
	    }
}
