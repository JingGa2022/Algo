package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱_7579 {
	static class App{
        int a; int cost;

        public App(int a, int cost){
            this.a = a;
            this.cost = cost;
        }
    }
    static int n, m, ans;
    static int dp[][];
    static App arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = 987654321;
        arr = new App[n];
        dp = new int[n][10001];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            int aa = Integer.parseInt(st.nextToken());
            int bb = Integer.parseInt(st2.nextToken());
            arr[i] = new App(aa, bb);
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<= 10000; j++){
                if(i == 0) {
                    if(j >= arr[i].cost) dp[i][j] = arr[i].a;
                }
                else{
                    if(j >= arr[i].cost){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].cost] + arr[i].a);
                    }else dp[i][j] = dp[i-1][j];
                }
             if(dp[i][j] >= m) {
                 ans = Math.min(ans, j);
             }
            }
        }
        System.out.println(ans);
    }

}
