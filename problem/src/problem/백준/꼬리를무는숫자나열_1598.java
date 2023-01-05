package problem.백준;

import java.util.Scanner;

public class 꼬리를무는숫자나열_1598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a= sc.nextInt();
		int b = sc.nextInt();
		
		int ans = Math.abs(a%4 - b%4) + Math.abs(b/4 - a/4);
		System.out.println(ans);
	}
}
