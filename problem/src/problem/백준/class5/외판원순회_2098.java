package problem.백준.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 외판원순회_2098 {
	static int n;
    static int[][] arr, dp;
    final static int INF = 987562351;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
         arr = new int[n][n];
         dp = new int[n][(1 << n) - 1];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<n ;i++) Arrays.fill(dp[i], -1);

        bw.write(dfs(0, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int city, int visit) {
        if(visit == (1 << n) - 1){
            if(arr[city][0] == 0) return INF;
            return arr[city][0];
        }
        if(dp[city][visit] != -1) return dp[city][visit];

        dp[city][visit] = INF;
        for(int i = 0; i<n; i++){
            if((visit & (1 << i)) == 0 && arr[city][i] != 0) dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1 << i)) + arr[city][i]);
        }

        return dp[city][visit];
    }
}