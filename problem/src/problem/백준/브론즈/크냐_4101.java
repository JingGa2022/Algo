package problem.백준.브론즈;

import java.util.Scanner;

public class 크냐_4101 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		while(n!=0 && m != 0) {
			if(n > m) System.out.println("Yes");
			else System.out.println("No");
			n = sc.nextInt();
			m = sc.nextInt();
		}
	}
}
