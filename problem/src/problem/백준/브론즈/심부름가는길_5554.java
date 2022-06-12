package problem.백준.브론즈;

import java.util.Scanner;

public class 심부름가는길_5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
		
		System.out.println(sum/60);
		System.out.println(sum%60);
	}
}
