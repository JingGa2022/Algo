package problem.백준.class5;

import java.util.Scanner;

public class 행렬곱셈순서_11049 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mat[] = new int[n+1];
        int dp[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            mat[i] = a;
            mat[i + 1] = b;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j < n - i; j++){
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k = j; k < j+i; k++){
                    dp[j][j+i] = Math.min(dp[j][j+i] ,(dp[j][k] + dp[k+1][j+i] + mat[j]*mat[k+1]*mat[j+i+1]));
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}