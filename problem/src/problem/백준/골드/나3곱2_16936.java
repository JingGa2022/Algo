package problem.백준.골드;

import java.util.*;

public class 나3곱2_16936 {
	/*
	 * 
	 */
	static int size;
	static ArrayList<Long> list = new ArrayList<>();
	static LinkedList<Long> result = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<long[]> answer = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		
		for(int i = 0; i<size; i++) {
			list.add(sc.nextLong());
		}
		
		Collections.sort(list);
		
		result.add(list.get(0));
		list.remove(0);
		
		frontAdd();
		backAdd();
		
		for(long num : result) {
			sb.append(num + " ");
		}
		System.out.println(sb);
	}
	static void frontAdd() {
		OUTER: while(true) {
			long target = result.get(0);
			
			for(int i = 0; i<list.size(); i++) {
				if(target % 2 == 0) {
					if(list.get(i) == target >> 1) {
						result.addFirst(list.get(i));
						list.remove(i);
						continue OUTER;
					}
				}
				if(target * 3 == list.get(i)) {
					result.addFirst(list.get(i));
					list.remove(i);
					continue OUTER;
				}
			}
			break;
		}
	}
	static void backAdd() {
		OUTER: while(true) {
			long target = result.get(result.size() - 1);
			
			for(int i = 0; i<list.size(); i++) {
				if(list.get(i) % 2 == 0) {
					if(list.get(i) >> 1== target) {
						result.addLast(list.get(i));
						list.remove(i);
						continue OUTER;
					}
				}
				if(target == list.get(i) * 3) {
					result.addLast(list.get(i));
					list.remove(i);
					continue OUTER;
				}
			}
			break;
		}
	}
}
