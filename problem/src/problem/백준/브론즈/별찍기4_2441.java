package problem.백준.브론즈;

import java.util.Scanner;

public class 별찍기4_2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i< n; i++) {
			for(int j = n-i; j< n ;j++) {
				System.out.print(" ");
			}
			for(int j = i; j< n ;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
