package problem.백준;

import java.util.Scanner;
import java.util.Stack;

public class 제로_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> zero = new Stack<>(); //스텍구조 이용
		int tmp = 0;//일시적으로 쓸것
		int sum = 0; //합의값
		for(int i =0; i<K; i++) {
			tmp = sc.nextInt();
			if(tmp == 0) {
				zero.pop();
			}else {
				zero.push(tmp);
			}
		}
		//사이즈 저장
		int size = zero.size();
		for(int i =0; i<size; i++) {
			sum += zero.pop();
		}
		
		System.out.println(sum);

	}
}
