package problem.백준.class5;

import java.util.Arrays;
import java.util.Scanner;

public class DanceDanceRevolution_2342 {
	 static int dp[][][];
	    static int move[];
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String[] tmp = sc.nextLine().split(" ");
	        move = new int[tmp.length - 1];
	        for(int i = 0; i< move.length; i++) move[i] = Integer.parseInt(tmp[i]);

	        dp = new int[5][5][tmp.length];

	        for(int i = 0; i<5; i ++){
	            for(int j =0; j<5; j++) Arrays.fill(dp[i][j], -1);
	        }

	        System.out.println(ddr(0, 0, 0));
	    }

	    private static int ddr(int left, int right, int cnt) {
	        if(cnt == move.length) return 0;

	        if(dp[left][right][cnt] != -1) return dp[left][right][cnt];

	        dp[left][right][cnt] = Math.min(cost(left, move[cnt]) + ddr(move[cnt], right, cnt + 1),
	                cost(right, move[cnt]) + ddr(left, move[cnt], cnt + 1));

	        return dp[left][right][cnt];
	    }
	    private static int cost(int prev, int next){
	        int num = Math.abs(prev - next);
	        if(prev == 0) return 2;
	        if(num == 0) return 1;
	        else if (num == 1 || num == 3) return 3;
	        return 4;
	    }
	}
