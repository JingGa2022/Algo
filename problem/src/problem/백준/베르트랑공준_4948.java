package problem.백준;

import java.util.Scanner;

public class 베르트랑공준_4948 {
	static int ans;
	static boolean[] prime = new boolean[300000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			ans = 0;
			
			isPrime(2*n);
			
			for(int i = n+1; i<=2*n; i++) {
				if(!prime[i]) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	private static void isPrime(int num) {
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i<=Math.sqrt(num); i++) {
			if(prime[i]) continue;
			
			for(int j = i * i; j <= num; j = j+i) {
				prime[j] = true;
			}
		}
	}
}
