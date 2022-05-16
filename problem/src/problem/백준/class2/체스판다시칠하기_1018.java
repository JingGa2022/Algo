package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018 {
	static String[][] box;
	static int ans = 0;
	static int N; // 행
	static int M; // 열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		//개행제거
		br.read();
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		box = new String[N][M];
		
		
		for(int i = 0; i<N; i++) {
				box[i] = br.readLine().split("");
		}
		
		for(int i =0; i<= N-7; i++) {
			
		}
	}
}
