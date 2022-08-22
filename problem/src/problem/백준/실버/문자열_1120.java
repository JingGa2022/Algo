package problem.백준.실버;

import java.util.Scanner;

public class 문자열_1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		int min = Integer.MAX_VALUE;
		
		for(int i =0; i<=B.length() - A.length() ; i++) {
			int cnt = 0;
			for(int j = 0; j<A.length(); j++) {
				if(A.charAt(j)!=B.charAt(j+i)) {
					cnt++;
				}
			}
			if(cnt < min) min = cnt;
		}
		System.out.println(min);
	}
}
