package problem.백준;

import java.util.Scanner;

public class K세준수_1418 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;

		for (int a = 1; a <= n; a++) {
			int max = 0;
			int now = a;

			for (int i = 2; i <= Math.sqrt(a);) {
				if (now % i == 0) {
					now /= i;
					max = i;
				}else {
					i++;
				}
			}
			
			if(now != 1) max = now;
			
			if(max <= k) ans++;
		}
		System.out.println(ans);
	}
}
