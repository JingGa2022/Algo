package problem.백준.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀과사다리게임_16928 {
	static int N, M, ans;
	static int[] arr;
	static int[] count = new int[101];
	static boolean[] visit = new boolean[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		ans = 0;

		arr = new int[101];

		for (int i = 0; i < N + M; i++) {
			arr[sc.nextInt()] = sc.nextInt();
		}
		dice();
	}

	private static void dice() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		count[1] = 0;
		visit[1] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == 100) {
				System.out.println(count[tmp]);
				return;
			}
			for(int i = 1; i<=6; i++) {
				int x = tmp + i;
				if(100 < x) continue;
				if(visit[x]) continue;
				visit[x] = true;
				
				if(arr[x] == 0) {
					q.add(x);
					count[x] = count[tmp] + 1;
				}else {
					if(visit[arr[x]]) continue;
					q.add(arr[x]);
					visit[arr[x]] = true;
					count[arr[x]]= count[tmp] +1;
				}
			}
		}
	}
}
