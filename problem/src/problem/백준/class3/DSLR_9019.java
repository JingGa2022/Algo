package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR_9019 {
	static int A,B;
	static boolean[] visit = new boolean[10001];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0 ; tc<T; tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			ans = 0;
			
			dfs();
			System.out.println(ans);
		}
	}
	private static void dfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		
		q.add(A);
		visit[A] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i = 1; i<=4; i++) {
						
				order(i, "");
				if(visit[A]) continue;
				
				visit[A] = true;
				q.add(A);
			}
			ans += 1;
		}
	}
	
	private static void order(int num, String sb) {
		switch(num) {
		case 1:
			if(A*2 > 9999) A %= 10000;
			else A *= 2;
			sb += "D";
			break;
		case 2:
			if(A-1 == 0) A = 9999;
			else A -= 1;
			sb += "S";
			break;
		case 3:
			String s = Integer.toString(A).substring(1, Integer.toString(A).length()) + Integer.toString(A).substring(0,1);
			A = Integer.parseInt(s);
			sb += "L";
			break;
		case 4:
			s = Integer.toString(A).substring(Integer.toString(A).length()-1,Integer.toString(A).length()) + Integer.toString(A).substring(0, Integer.toString(A).length()-1);
			A = Integer.parseInt(s);
			sb += "R";
			break;
		}
	}
}
