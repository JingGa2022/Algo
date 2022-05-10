package problem.백준.class2;

import java.util.*;

public class 스택_10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();


		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i<N; i++) {
			String order = sc.next(); // 명령
			
			if(order.equals("push")) {
				stack.add(sc.nextInt());
			}
			else if(order.equals("pop")) {
				if(stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.pop()).append("\n");
			}
			else if(order.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if(order.equals("empty")) {
				if(stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else {
				if(stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}
		}//for
		System.out.println(sb);
	}//main
}
