package problem.APS심화;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact_SW문제해결기본 {
	static int N, start, ans;
	static int[][] phone;
	static boolean[] visited;//0번 인덱스에서 0은 미방문 1은 방문, 1번인덱스는 걸린시간
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			ans = 0;
			phone = new int[101][101];
			visited = new boolean[101];
			
			for(int i = 0; i<N/2; i++) {		
					phone[sc.nextInt()][sc.nextInt()] = 1;
			}
			call();
			
			
			System.out.println("#"+tc+" "+ans);
		}//tc
	}//main
	
	static void call() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			ans = 0;
			for(int i = 0; i<size; i++) {
				int tmp = q.poll();
				if(tmp > ans) ans = tmp;
				
				for(int j = 0; j<101; j++) {
					if(!visited[j] && phone[tmp][j]==1) {
						q.add(j);
						visited[j] = true;
						//bfs의 마술사 얍얍
						//이렇게도 쓸 수 가 있네용..
					}
				}
			}
		}
	}
	
}
