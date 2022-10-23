package problem.백준;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐_1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = 0;
		
		LinkedList<Integer> dq = new LinkedList<>();
		
		for(int i = 1; i<=n; i++) dq.add(i);
		
		int Hindex = 0;
		
		for(int i = 1; i<=m; i++) {
			int tmp = sc.nextInt();
			int Tindex = dq.indexOf(tmp);
			
			if(dq.size() % 2 == 0) Hindex = dq.size() / 2 -1;
			else Hindex = dq.size() /2;
			
				if(Tindex <= Hindex) {
					for(int j = 0 ; j < Tindex; j++) {
						int temp = dq.pollFirst();
						dq.add(temp);
						ans++;
					}
				}else {
					for(int j = 0 ; j < dq.size() - Tindex; j++) {
						int temp = dq.pollLast();
						dq.addFirst(temp);
						ans++;
					}
					
				}
				dq.pollFirst();
		}
		System.out.println(ans);
	}
}
