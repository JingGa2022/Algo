package problem.백준.브론즈;

import java.util.Scanner;

public class 별찍기5_2442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			for(int j = i; j<n-1; j++) {
				System.out.print(" ");
			}
			for(int j = -1; j<2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
