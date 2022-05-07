package problem.백준.class2;

import java.util.Scanner;

public class 소수구하기_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = M; i<=N; i++) {
			if(isPrime(i)) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}//main
	
	static boolean isPrime(int num) {
		if(num == 1) return false;
		else {
			for(int i = 2; i<=Math.sqrt(num); i++)	{			
				if(num % i == 0)return false;
			}
		}
		return true;
	}
}
