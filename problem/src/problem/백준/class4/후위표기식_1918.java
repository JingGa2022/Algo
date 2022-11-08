package problem.백준.class4;

import java.util.*;

public class 후위표기식_1918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s = sc.next();
		Stack<Character> stack = new Stack<>();
	
		
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c <= 'Z' && c >= 'A') {
				sb.append(c);
			}else {
				if(c == '(') {
					stack.add(c);
				}
				else if(c == ')') {
					while(!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					if(!stack.isEmpty()) stack.pop();
				}else {
					while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
						sb.append(stack.pop());
					}
					stack.add(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
	static public int priority(char c) {
		
		if(c == '*' || c =='/')
			return 2;
		else if(c == '+' || c == '-')
			return 1;
		return -1;
	}
}
