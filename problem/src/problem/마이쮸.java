package problem;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {
	static class Person{
		int num;
		int cnt;
		
		public Person(int num) {
			this.num = num;
			this.cnt = 1;
		}
	}
	public static void main(String[] args) {
		//사람이 줄을선다
		//해당사람이 개수만큼 마이쮸를 가져가면
		//다시 줄을 서서 개수증가, 새로운 사람이 와서 줄을선다.
		
		int N = 20;
		int pNum = 1; //사람의 번호
		
		Queue<Person> queue = new LinkedList<>();
		
		queue.offer(new Person(pNum++));
		while(N>0) {
			if(!queue.isEmpty()) {
				Person p = queue.poll();
				N -= p.cnt; //이번차례에 p라는 사람에게 마이쮸를 준다.
				if(N <= 0) {
					System.out.println(p.num + "번 사람이 마지막 마이쮸를 겟");
				}else {
					System.out.println(p.num+"번 사람이 "+p.cnt+"만큼 가져감");
					System.out.println("남은 마이쮸는"+N);
					p.cnt++;
					queue.offer(p);//가서 다시 줄서기
					queue.offer(new Person(pNum++));
				}
				
				
			}
		}
	}
}
