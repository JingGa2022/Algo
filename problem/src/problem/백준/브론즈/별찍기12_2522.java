package problem.백준.브론즈;

import java.util.Scanner;

public class 별찍기12_2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1 ; i<2*n; i++) {
			if(n>=i) {
				
			for(int j = i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j =0; j<i; j++)
				System.out.print("*");
			}
			else {
				
				for(int j = n; j<i; j++) {
					System.out.print(" ");
				}
				for(int j =0; j<n*2 - i; j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
