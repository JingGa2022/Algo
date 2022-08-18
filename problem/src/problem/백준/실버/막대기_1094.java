package problem.백준.실버;

import java.util.Scanner;

public class 막대기_1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int stick = 64;
		int sum = 0;
		int ans =0;
			
		while(x != sum) {
			while((x-sum) < stick) {
				stick /= 2;
			}
			sum += stick;
			ans++;
		}
		System.out.println(ans);
	}
}
