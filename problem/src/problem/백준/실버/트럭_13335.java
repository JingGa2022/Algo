package problem.백준.실버;

import java.util.*;

public class 트럭_13335 {
	/* 최대 하중까지 트럭넣고 돌리기
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();
		int ans = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) q.add(sc.nextInt());
		int sum = 0;
		Queue<Integer> bridge = new LinkedList<>();
		for(int i = 0; i<w; i++) bridge.add(0);
		
		while(!bridge.isEmpty()) {
			ans++;
			sum -= bridge.poll();
			if(!q.isEmpty()) {
				if(q.peek() + sum <= l) {
					sum += q.peek();
					bridge.add(q.poll());
				}else {
					bridge.offer(0);
				}
			}
		}
		
		System.out.println(ans);
	}
}
