package problem.백준.class3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR_9019 {
	static int A,B;
	static boolean[] visit ;
	static String[] ans;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0 ; tc<T; tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			visit = new boolean[10001];
			ans = new String[10001];
			
			q = new LinkedList<>();
			visit[A] = true;
			q.add(A);
			Arrays.fill(ans, "");
			while(!q.isEmpty() && !visit[B]) {
				int now = q.poll();
				int D = now*2 % 10000;
				int S = (now == 0) ? 9999 : now-1;
				int L = (now % 1000)*10 + now/1000;
				int R = (now % 10) * 1000 + now/10;
				
				if(!visit[D]) {
					
				visit[D] = true;
				ans[D] = ans[now] + "D";
				q.add(D);
				}
				
				if(!visit[S]) {
				visit[S] = true;
				ans[S] = ans[now] + "S";
				q.add(S);
				}

				if(!visit[L]) {
				visit[L] = true;
				ans[L] = ans[now] + "L";
				q.add(L);
				}

				if(!visit[R]) {
				visit[R] = true;
				ans[R] = ans[now] + "R";
				q.add(R);
				}
			}
			
			System.out.println(ans[B]);
		}
	}
}
