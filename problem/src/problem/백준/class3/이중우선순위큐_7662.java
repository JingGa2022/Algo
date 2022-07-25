package problem.백준.class3;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 이중우선순위큐_7662 {
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		for(int t = 0; t<T; t++) {
			int Q = sc.nextInt();
			
			map = new HashMap<>();
			PriorityQueue<Integer> minque = new PriorityQueue<>();
			PriorityQueue<Integer> maxque = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int q = 0; q<Q; q++) {
				char cal = sc.next().charAt(0); //연산의 종류
				int n = sc.nextInt();// 연산할 숫자
				
				if(cal == 'I') {
					map.put(n, map.getOrDefault(n, 0)+1);
					maxque.add(n);
					minque.add(n);
				}else {
					if(map.size() == 0) continue;
					
					PriorityQueue<Integer> que = n == 1 ? maxque : minque;
					removeMap(que);
				}
			}
			if(map.size() == 0) System.out.println("EMPTY");
			else {
				int n = removeMap(maxque);
				System.out.println(n + " " + (map.size()>0 ? removeMap(minque) : n));
			}
		}
	}//main
	private static int removeMap(PriorityQueue<Integer> que) {
		// TODO Auto-generated method stub
		int num;
		while(true) {
			num = que.poll();
			int cnt = map.getOrDefault(num, 0);
			
			if(cnt == 0) continue;
			
			if(cnt == 1) map.remove(num);
			else map.put(num, cnt - 1);
			
			break;
		}
		return num;
	}
}
