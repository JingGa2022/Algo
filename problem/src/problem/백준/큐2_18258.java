package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2_18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			if(tmp.equals("push")) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			else if(tmp.equals("pop")) {
				if(!deque.isEmpty())
					sb.append(deque.pollFirst()+"\n");
				else
					sb.append(-1+"\n");
			}
			else if(tmp.equals("size")) {
				sb.append(deque.size()+"\n");
			}
			else if(tmp.equals("empty")) {
				if(deque.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else if(tmp.equals("front")) {
				if(!deque.isEmpty())
					sb.append(deque.peekFirst()+"\n");
				else
					sb.append(-1+"\n");
				
			}
			else if(tmp.equals("back")) {
				if(!deque.isEmpty())
					sb.append(deque.peekLast()+"\n");
				else
					sb.append(-1+"\n");
				
			}
		}
		System.out.println(sb);
	}
}
