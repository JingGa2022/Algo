package problem.백준.브론즈;

import java.util.Scanner;

public class 주사위세개_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a == b && b == c && a == c)
			System.out.println(10000 + (a * 1000));
		else if(a == b || a == c)
			System.out.println(1000 + (a * 100));
		else if(b == c)
			System.out.println(1000 + (b * 100));
		else
			System.out.println((Math.max(a, Math.max(c, b)) * 100));
	}
}
