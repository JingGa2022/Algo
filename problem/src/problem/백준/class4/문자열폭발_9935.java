package problem.백준.class4;

import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발_9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String s = sc.next();
		String bomb = sc.next();

		int sLen = s.length();
		int bombLen = bomb.length();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < sLen; i++) {
			char tmp = s.charAt(i);
			stack.add(tmp);

			if (stack.size() >= bombLen) {
				boolean flag = true;
				for (int j = 0; j < bombLen; j++) {
					char c1 = stack.get(stack.size() - bombLen + j);
					char c2 = bomb.charAt(j);
					
					if(c1 != c2) {
						flag = false;
						break;
					}					
				}
				if(flag) {
					for(int j = 0; j<bombLen; j++) {
						stack.pop();
					}
				}
			}	
		}
		
		if(stack.size() == 0) {
			System.out.println("FRULA");
		}else {
			for(char c : stack) {
				sb.append(c);
			}
		}
		System.out.println(sb);

	}
}
