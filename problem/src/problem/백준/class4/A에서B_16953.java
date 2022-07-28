package problem.백준.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A에서B_16953 {
	static long A, B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLong();
		B = sc.nextLong();
		
		System.out.println(bfs());
	}//main
	private static int bfs() {
		int ans = 0;
		
		Queue<Long> q = new LinkedList<>();
		
		q.add(A);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i<size; i++) {
				long tmp = q.poll();
				
				long cal1 = tmp * 2;
				long cal2 = tmp * 10 + 1;
				
				if(tmp == B) {
					return ++ans;
				}
				
				if(cal2 <= B)
					q.add(cal2);
				if(cal1 <= B) {
					q.add(cal1);
				}
			}
			
			ans ++;
			
		}
		return -1;
	}
}
