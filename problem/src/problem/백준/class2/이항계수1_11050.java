package problem.백준.class2;

import java.util.Scanner;

public class 이항계수1_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int top = 1;
		int bottom = 1;

		for(int N = sc.nextInt(), K = sc.nextInt() ; K>0; K--, N--) {
			top *= N;
			bottom *= K;
		}
		
		System.out.println(top/bottom);
	}
}
