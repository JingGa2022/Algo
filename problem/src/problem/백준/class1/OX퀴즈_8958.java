package problem.백준.class1;

import java.util.Scanner;

public class OX퀴즈_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			int score = 1;
			
			String s = sc.next();
			
			int sum = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'O') {
					sum += score++;
				}
				else
					score = 1;
			}
			
			System.out.println(sum);
		}
	}
}
