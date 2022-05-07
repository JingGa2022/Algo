package problem.백준.class2;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		// 체크하기
		int start = 0;
		while (N-- > 0) {

			int value = sc.nextInt();

			if (value > start) {
				// start+1부터 입력받은 값까지 push
				for (int i = start+ 1; i <= value; i++) {
					stack.add(i);
					sb.append("+").append("\n");
				}
				start = value;				
			}
			// top의 원소가 입력값과 다를때
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			//스택의 top과 값이 같다면
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}// main
}
