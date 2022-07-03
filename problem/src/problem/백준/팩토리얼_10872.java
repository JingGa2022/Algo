package problem.백준;

import java.util.Scanner;

public class 팩토리얼_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(facto(n));
	}

	private static int facto(int n) {
		// TODO Auto-generated method stub
		if(n == 0 || n == 1) return 1;
		
		return n * facto(n-1);
	}
}