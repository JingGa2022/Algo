package problem.백준.class1;

import java.util.Scanner;

public class 별찍기2_2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i< N; i++) {
				for (int j2 = i+1; j2 < N; j2++) {
					System.out.print(" ");					
				}
				for(int j3=N-1-i; j3<N; j3++ )
					System.out.print("*");
				System.out.println();
		}
	}
}
