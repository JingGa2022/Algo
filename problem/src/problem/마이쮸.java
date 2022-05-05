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
		//����� ��������
		//�ش����� ������ŭ �����鸦 ��������
		//�ٽ� ���� ���� ��������, ���ο� ����� �ͼ� ��������.
		
		int N = 20;
		int pNum = 1; //����� ��ȣ
		
		Queue<Person> queue = new LinkedList<>();
		
		queue.offer(new Person(pNum++));
		while(N>0) {
			if(!queue.isEmpty()) {
				Person p = queue.poll();
				N -= p.cnt; //�̹����ʿ� p��� ������� �����鸦 �ش�.
				if(N <= 0) {
					System.out.println(p.num + "�� ����� ������ �����鸦 ��");
				}else {
					System.out.println(p.num+"�� ����� "+p.cnt+"��ŭ ������");
					System.out.println("���� �������"+N);
					p.cnt++;
					queue.offer(p);//���� �ٽ� �ټ���
					queue.offer(new Person(pNum++));
				}
				
				
			}
		}
	}
}
