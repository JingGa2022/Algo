package problem.백준;

import java.util.Scanner;

public class 영수증_25304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int num = sc.nextInt();
		
		for(int i = 0; i<num; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			
			n -= a*b;
		}
		
		if(n == 0) System.out.println("Yes");
		else System.out.println("No");
	}
}
