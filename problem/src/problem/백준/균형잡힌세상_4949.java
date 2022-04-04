package problem.백준;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌세상_4949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp;//잠시 담아두기
		Stack<String> check = new Stack<>();//진또배기
		int idx = 0;//check의 idx
		
		while(true) {
			tmp = sc.nextLine();
			
			if(tmp.equals("."))
				break;
			System.out.println(solve(tmp));
		}
		
	}//main
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			else if(c == ')') {
				if(stack.empty() || stack.peek() !='('){
					return "no";
				}
				else
					stack.pop();
			}
			else if(c == ']') {
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else
					stack.pop();
			}
			
		}//for
		
		if(stack.empty()) {
			return "yes";
		}
		else
			return "no";
	}
}
