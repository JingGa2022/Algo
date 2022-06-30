package problem.백준.class3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AC_5430_2 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			String s = sc.next();
			int n = sc.nextInt();
			st = new StringTokenizer(sc.next(), "[],");
			Deque<Integer> deque = new LinkedList<>();
			for(int j = 0; j<n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(s, deque);
		}
		System.out.println(sb);
	}
	private static void AC(String s, Deque<Integer> deque) {
		// TODO Auto-generated method stub
		boolean isRight = true;
		
		for(char cmd : s.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;
				continue;
			}
			
			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		print(deque, isRight);
	}
	private static void print(Deque<Integer> deque, boolean isRight) {
		// TODO Auto-generated method stub
		sb.append('[');
		
		if(deque.size() >0) {
			if(isRight) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
		else {
			sb.append(deque.pollLast());
			
			while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollLast());
			}
		}
		}
		
		sb.append(']').append('\n');
	}
}
