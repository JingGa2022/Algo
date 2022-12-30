package problem.백준.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 팰린드롬분할_1509 {
	 static String s;
	    static int ans = 0;
	    static boolean[][] palindrome;
	    static int[] dp;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        s = br.readLine();
	        dp = new int[s.length()+1];
	        palindrome = new boolean[s.length()+1][s.length()+1];

	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = 0;

	        Palindrome();

	        for(int i = 1 ; i<=s.length(); i++){
	            for(int j = 1; j<=i; j++){
	                if(palindrome[j][i])
	                    dp[i] = Math.min(dp[i] , dp[j - 1]+1);
	            }
	        }

	        System.out.println(dp[s.length()]);
	    }

	    private static void Palindrome() {

	        for (int str = 1; str <= s.length(); str++) {
	            for (int e = str; e <= s.length(); e++) {
	                boolean flag = true;

	                int start = str-1;
	                int end = e-1;

	                while(start<=end){
	                    if(s.charAt(start++) != s.charAt(end--)){
	                        flag = false;
	                        break;
	                    }
	                }

	                if (flag) {
	                    palindrome[str][e] = true;
	                }

	            }
	        }
	    }
	}
