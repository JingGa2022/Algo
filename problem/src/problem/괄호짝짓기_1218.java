package problem;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10�� ����
		for(int tc = 1; tc <= 10; tc++) {
			//���̽��� ����
			int tlen = sc.nextInt();
			//���ڿ� �ڽ�
			char[] box = sc.next().toCharArray();
			Stack<Character> st = new Stack<>();
			//��ȿ����
			int ok = 1;
			//���ؿ� ���� �ֱ�
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
			
			//���
			System.out.printf("#%d %d\n",tc, ok);
		}
	}
	
}
