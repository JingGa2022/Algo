package problem.백준;

import java.util.Scanner;

public class 한수_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(arithmetic_sequence(n));
		
	}
	public static int arithmetic_sequence(int num) {
		int cnt = 0;
		
		if(num < 100) return num;
		
		else {
			cnt = 99;
			for(int i = 100; i<= num; i++) {
				int h = i / 100;
				int t = (i / 10) % 10;
				int o = i % 10;
				
				if(h - t == t - o) {
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}
}
