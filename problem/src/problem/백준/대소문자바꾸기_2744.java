package problem.백준;

import java.util.Scanner;

public class 대소문자바꾸기_2744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s = sc.next();
		
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(s.charAt(i)>= 65 && s.charAt(i) <= 90) {
				sb.append((char)(c + 32));
			}
			else if(s.charAt(i)>= 97 && s.charAt(i) <= 122) {
				sb.append((char)(c - 32));
				
			}
		}
		System.out.println(sb);
	}
}
