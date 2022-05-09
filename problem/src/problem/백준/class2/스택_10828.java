package problem.백준.class2;

import java.util.*;

public class 스택_10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i<N; i++) {
			String order = sc.next(); // 명령
			
			if(order.equals("push")) {
				stack.add(sc.nextInt());
			}
			else if(order.equals("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			}
			else if(order.equals("size")) {
				System.out.println(stack.size());
			}
			else if(order.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}
		}//for
	}//main
}
