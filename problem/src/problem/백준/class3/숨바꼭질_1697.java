package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
	static int n,k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n>=k) {
			System.out.println(n-k);
		}else {
			System.out.println(bfs());
		}
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		//시간 저장
		int[] arr = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		arr[n] = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i = 0; i<3; i++) {
				int nx;
				if(i == 0) {
					nx = x -1;
				}else if(i == 1) {
					nx = x + 1;
				}else {
					nx = x * 2;
				}
				if(nx == k) return arr[x];
				if(nx >= 0 && nx < 100001 && arr[nx] == 0) {
					arr[nx] = arr[x] +1;
					q.add(nx);
				}
			}
		}
		return 0;
	}
}
