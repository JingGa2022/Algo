package problem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 계산기3_1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 0;
			int len = sc.nextInt(); // 문자열 길이
			String exp = sc.next();
			Stack<String> tmp = new Stack<>();
			String num = new String();// 후위표기법 표기

			for (int i = 0; i < len; i++) {
				switch(exp.charAt(i) + "") {
				case "+":
				case "-":
					if(tmp.empty() || tmp.peek().equals("(")) {
						tmp.push(exp.charAt(i) + "");
					}else {
						num += tmp.pop();
						tmp.push(exp.charAt(i) + "");
					} break;
				case "*":
				case "/":
					if(tmp.empty()) tmp.push(exp.charAt(i) + "");
					else if( tmp.peek().equals("+") || tmp.peek().equals("-") || tmp.peek().equals("(")) {
						tmp.push(exp.charAt(i) + "");
					}else {
						num += tmp.pop();
						tmp.push(exp.charAt(i) + "");
					} break;
				case "(":
					tmp.push(exp.charAt(i) + "");
					break;
				case ")":
					String str;
					while(!(str=tmp.pop()).equals("(")) 
						num += str;
				break;
				default:
					num += exp.charAt(i) + "";
					break;
				}
			}
			while(!tmp.empty())
				num += tmp.pop();
			//계산기
			Stack<Integer> cal = new Stack<>();
			for (int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
			if(c >= 48 && c <= 57) {
				cal.push(c - 48);
			}else {
				int b = cal.pop();
				int a = cal.pop();
				switch(c) {
				case '+':
				{
					cal.push(a + b);
					break;
				}
				case '-':
				{
					cal.push(a - b);
					break;
				}
				case '*':
				{
					cal.push(a * b);
					break;
				}
				case '/':
					cal.push(a / b);
					break;
				}
			}
			}
			ans = cal.pop();
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}

