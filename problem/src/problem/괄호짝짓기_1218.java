package problem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10번 돌기
		for(int tc = 1; tc <= 10; tc++) {
			//케이스의 길이
			int tlen = sc.nextInt();
			//물자열 박스
			char[] box = sc.next().toCharArray();
			Stack<Character> st = new Stack<>();
			//유효성값
			int ok = 1;
			//스텍에 문자 넣기
			for(int i = 0; i<tlen; i++) 
				if(box[i] == '(' || box[i] == '[' || box[i] == '{' || box[i] == '<')
					st.push(box[i]);
				else if(box[i] == ')')
					if(st.peek() == '(')
					st.pop();
					else {
						ok = 0;
						break;
					}
				else if(box[i] == ']')
					if(st.peek() == '[')
						st.pop();
					else {
						ok = 0;
						break;
					}
				else if(box[i] == '}')
					if(st.peek() == '{')  
						st.pop();
					else {
						ok = 0;
						break;
					}
				else if(box[i] == '>')
					if(st.peek() == '<')
						st.pop();
					else {
						ok = 0;
						break;
					}
			
			//출력
			System.out.printf("#%d %d\n",tc, ok);
		}
	}
	
}
