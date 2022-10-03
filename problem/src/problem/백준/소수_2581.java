package problem.백준;

import java.util.Scanner;

public class 소수_2581 {
	static boolean prime[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		prime = new boolean[n+1];
		
		isPrime();
		
//		for(int i = m; i<=n; i++) {
//			int cnt = 1;
//			for(int j = 2; j<= Math.sqrt(i); j++) {
//				if(i % j == 0) cnt ++;
//				if(cnt >= 2) {
//					break;
//				}
//			}
//			if(cnt == 1) {
//				sum += i;
//				min = Math.min(min, i);
//			}
//		}
		
		for(int i = m; i<=n; i++) {
			if(prime[i] == false) {
				sum+=i;
				if(min == Integer.MAX_VALUE) min = i;
			}
		}
		
		if(sum!=0) {
			System.out.println(sum);
			System.out.println(min);
			
		}else if(sum == 0){
			System.out.println(-1);
		}
	}
	private static void isPrime() {
		// TODO Auto-generated method stub
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i<= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
	}
}
