package problem.백준.골드;

import java.util.*;

public class 소수의연속합_1644 {
	/*
	 * 1. 에라토스테네스의 채로 소수들을 구하고 2. 투포인터로 잡아가면서 개수를 구해나간다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		boolean prime[] = new boolean[n + 1];
		prime[0] = prime[1] = true;
		int ans = 0;

		for (int i = 2; i * i <= n; i++) {
			if (!prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = true;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1; i<=n ;i++) {
			if(!prime[i]) list.add(i);
		}
		list.add(0);//인덱스 끝까지 탐색용
		
		int s = 0;
		int e = 0;
		int sum = 0;

		while (s <= e && e < list.size()) {
			if(sum < n) sum += list.get(e++);
			else {
				if(sum == n) ans++;
				sum -= list.get(s++);
			}
		}

		System.out.println(ans);
	}
}
