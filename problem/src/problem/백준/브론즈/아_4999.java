package problem.백준.브론즈;

import java.util.Scanner;

public class 아_4999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String h = sc.next();
		
		if(a.length()>= h.length()) {
			System.out.println("go");
		}else
			System.out.println("no");
	}
}
