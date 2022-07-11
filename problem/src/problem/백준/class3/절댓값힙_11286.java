package problem.백준.class3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙_11286 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1== abs2) return o1>o2 ? 1: -1;
			return abs1 - abs2;
		});
		
		for(int i = 0; i<n ;i++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}else pq.add(tmp);
				
			}
	}
}
