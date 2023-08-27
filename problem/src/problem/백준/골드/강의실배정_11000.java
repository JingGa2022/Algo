package problem.백준.골드;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lec {
	int s;
	int e;
	
	Lec(int s, int e){
		this.s = s;
		this.e = e;
	}
}
public class 강의실배정_11000 {
	/* 1. 어떤 강의의 끝나는 시간이 시작시간보다 같거나 늦어야함
	 * 2. 정렬을 하고 순서대로 차곡차곡 정리하기
	 * 3. 횟수 저장하고 정답출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Lec[] lec = new Lec[n];
		
		for(int i = 0; i<n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			lec[i] = new Lec(s,e);
		}
		
		Arrays.sort(lec, (l1, l2) -> l1.s == l2.s ? l1.e - l2.e : l1.s - l2.s);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lec[0].e);
		
		for(int i = 1; i<n; i++) {
			if(pq.peek() <= lec[i].s) pq.poll();
			pq.offer(lec[i].e);
		}
		
		System.out.println(pq.size());
	}
}
