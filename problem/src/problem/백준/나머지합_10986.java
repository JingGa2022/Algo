package problem.백준;

import java.util.Scanner;

public class 나머지합_10986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] cnt = new int[m];
		int sum = 0;
		for(int i =0; i<n; i++) {
			sum = (sum + sc.nextInt()) % m;
			cnt[sum]++;
		}
		
		long ans = cnt[0];
		
		for(int i =0; i<m; i++) {
			ans += (long) cnt[i] * (cnt[i] - 1) / 2;
		}
		System.out.println(ans);
	}
}
