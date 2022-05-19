package problem.백준.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요세푸스문제_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i<=N; i++) list.add(i);
		
		int idx = -1;
		int check = 0;
		while(list.size() > 0) {
			check++;
			idx++;
			if(idx >= list.size()) idx = 0;
			if(check==K) {
				if(list.size() != 1)
					sb.append(list.get(idx)).append(", ");
				else
					sb.append(list.get(idx));
				list.remove(idx);
				check = 0;
				idx--;
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}//main
}
