package problem.APS심화;

import java.util.Scanner;

public class 이진수표현_10726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int check = (int) (Math.pow(2, N) -1);
			
			if((M & check) == check )
			System.out.println("#"+tc+" "+"ON");
			else
			System.out.println("#"+tc+" "+"OFF");
		}
	}
}
