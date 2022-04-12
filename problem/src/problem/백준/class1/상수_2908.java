package problem.백준.class1;

import java.util.Scanner;

public class 상수_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A =sc.nextInt();
		int B = sc.nextInt();
		
		A = Integer.parseInt(new StringBuffer().append(A).reverse().toString())	;
		B = Integer.parseInt(new StringBuffer().append(B).reverse().toString())	;
		
		System.out.println(A > B ? A : B);
	}
}
