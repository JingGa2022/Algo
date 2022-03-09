package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피보나치함수_1003 {
	public static int cnt0 = 0;
	public static int cnt1 = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] ans = new int [T][2];
		for(int tc = 0; tc < T; tc++) {
			cnt0 = 0;
			cnt1 = 0;
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			ans[tc][0] = cnt0;
			ans[tc][1] = cnt1;
		}
		for(int tc = 0; tc < T; tc++) {
			for(int i =0; i<2; i++) {
				System.out.print(ans[tc][i] + " ");
			}
			System.out.println();
		}
	}
	
	//fibo재귀
	public static int fibo(int n) {
		if(n == 0) {
			cnt0++;
			return 0;
		} else if(n == 1) {
			cnt1++;
			return 1;
		}else
		return fibo(n-1) + fibo(n-2);
	}
}
