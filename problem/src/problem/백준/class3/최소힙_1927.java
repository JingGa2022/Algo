package problem.백준.class3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소힙_1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i< x; i++) {
			int tmp = sc.nextInt();
			
			if(tmp == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(tmp);
			}
		}
	}
}
