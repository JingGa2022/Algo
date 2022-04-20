package problem.백준.class2;

import java.util.Scanner;

public class 설탕배달_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int tmp = 0;
		int ans = 0;
		
		if(N == 4 || N == 7) {
			System.out.println(-1);
		}
		else if(N%5 == 0) {
			System.out.println(N / 5);
		}
		else if(N % 5 == 1 || N % 5 == 3) {
			System.out.println(N / 5 +1);
		}
		else if(N % 5 == 2 || N % 5 == 4) {
			System.out.println(N / 5 +2);
		}
		
		System.out.println(ans);
	}
}
