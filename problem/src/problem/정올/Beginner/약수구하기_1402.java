package problem.정올.Beginner;

import java.util.Scanner;

public class 약수구하기_1402 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int idx = 0;
		int ans = 0;
		for(int i = 1; i<= n/2; i++) {
			if(n % i == 0) {
				idx++;
			}
			if(idx == k) {
				ans = i;	
				break;
			}
		}
		
		System.out.println(ans);
	}
}
