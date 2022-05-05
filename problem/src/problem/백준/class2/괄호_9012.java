package problem.백준.class2;

import java.util.Scanner;
import java.util.Stack;

public class 괄호_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			Stack<Character> stack = new Stack<>();
			
			String tmp = sc.next();
			
			for(int i= 0; i<tmp.length(); i++) {
				//거름망
				if(tmp.charAt(0)==')') {
					stack.add(tmp.charAt(i));
					break;
				}
				
				if(tmp.charAt(i)=='(')stack.add(tmp.charAt(i));
							
				if(!stack.isEmpty() && stack.peek() == '(' && tmp.charAt(i)==')') stack.pop();
				
				else if(stack.isEmpty() && tmp.charAt(i)==')') stack.add(tmp.charAt(i));
			}
			if(stack.isEmpty()) sb.append("YES\n");
			else sb.append("NO\n");
			
		}
		System.out.println(sb);
	}//main
}
