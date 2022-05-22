package problem.백준;

import java.util.Scanner;

public class 손익분기점_1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int cnt = 1;
		
		int sum = a+b;
		
		if(b>=c) {
			System.out.println(-1);
		}else {
			System.out.println((a/(c-b))+1);
		}
		
	}
}
