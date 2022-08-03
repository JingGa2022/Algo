package problem.백준;

import java.util.Scanner;

public class 이상한기호_15964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		System.out.println((A+B)*(A-B));
	}
}
