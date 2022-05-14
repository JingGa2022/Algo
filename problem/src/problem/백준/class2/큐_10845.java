package problem.백준.class2;

import java.util.*;

public class 큐_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Deque<Integer> que = new LinkedList<>();
		
		for(int i = 0; i<N; i++) {
			String order = sc.next(); // 명령
			
			if(order.equals("push")) {
				que.add(sc.nextInt());
			}
			else if(order.equals("pop")) {
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.poll()).append("\n");
			}
			else if(order.equals("size")) {
				sb.append(que.size()).append("\n");
			}
			else if(order.equals("empty")) {
				if(que.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(order.equals("front")){
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.peekFirst()).append("\n");
			}
			else {
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.peekLast()).append("\n");
			}
		}//for
		System.out.println(sb);
	}//main
}
