package problem.백준.class1;

import java.util.Scanner;

public class 문자열반복_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			int R = sc.nextInt();
			
			String s = sc.next();
			
			for(int i = 0; i<s.length(); i++) {
				for(int j = 0; j < R; j++)
					System.out.print(s.charAt(i));
			}
			System.out.println();
		}
	}
}
