package problem.백준.class3;

import java.util.Scanner;

public class 팩토리얼0의개수_1676 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int ans = 0;
		
//		for(int i = 1; i<=N; i++) {
//			int tmp = i;
//			if(i % 5 == 0) {
//				while(tmp >= 5) {
//					if(tmp % 5 == 0)
//						ans++;
//					tmp /= 5;
//				}
//			}
//		}
		
		while(N >= 5) {
			ans += N / 5;
			N /= 5;
		}
			
		System.out.println(ans);
	}
}
