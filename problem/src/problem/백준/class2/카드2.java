package problem.백준.class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//
		
		Queue<Integer> card = new LinkedList<>();
		
		for(int i = 1; i<=N; i++) card.add(i);
		
		while(card.size() != 1) {
			card.poll();
			int tmp = card.poll();
			card.add(tmp);
		}
		
		System.out.println(card.poll());
	}//main
}
