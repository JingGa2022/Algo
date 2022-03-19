package problem.백준;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		Stack<Integer> stack = new Stack<>();
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		//수열 찾기
		int idx =0;
		int seq = 2;
		int check = 0; //pop의 개수 세기 숫자수만큼 pop이 되어야 되겠죵?
		stack.push(1);
		list.add('+');
		for(int i = 1; i < N*2; i++) {
			if(stack.size() == 0) {
				stack.push(seq);
				seq++;
				list.add('+');
			}
			if(stack.peek() == num[idx]) {
				stack.pop();
				if(idx < N-1) {
					idx++;
					
				}else if(idx >= N) idx = N-1;
				list.add('-');
				check++;
			}else if(stack.peek() != num[idx]) {
				stack.push(seq);
				seq++;
				list.add('+');
			}
		}
		for(int i = 0; i < list.size(); i++) {
			if(check==N)
			System.out.println(list.get(i));
			else {
				System.out.println("NO");
				break;
			}
		}
	}//main
}
