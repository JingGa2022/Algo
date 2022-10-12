package problem.백준;

import java.util.Scanner;

public class 골드바흐의추측_9020 {
	static boolean arr[] = new boolean[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		primeNet();
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			int n = sc.nextInt();
			int ans = Integer.MAX_VALUE;
			int a = 0;
			int b = 0;
			
			for(int j = n; j>1; j--) {
				if(!arr[j] && !arr[n-j] && ans > (int) Math.abs(n-2*j)) {
					ans = (int) Math.abs(n-2*j);
					a = Math.min(j, n-j);
					b = Math.max(j, n-j);
					
				}
			}
			System.out.printf("%d %d\n", a, b);
		}
	}

	private static void primeNet() {
		// TODO Auto-generated method stub
		arr[0] = arr[1] = true;

		for (int i = 2; i <= 100; i++) {
			if (!arr[i]) {

				for (int j = i * i; j <= 10000; j += i) {
					arr[j] =true;
				}
			}
		}
	}
}
