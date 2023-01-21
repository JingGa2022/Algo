package problem.백준.골드;

import java.util.Scanner;

public class 공통부분문자열_5582 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String s2 = sc.next();
		int len = s.length();
		int len2 = s2.length();
		int max = 0;
		int[][] map = new int[len+1][len2+1];
		
		for(int i = 1; i<= len; i++) {
			for(int j = 1; j<= len2; j++) {
				if(s.charAt(i-1) == s2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1] + 1;
					max = Math.max(max, map[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}
