package problem.정올.Beginner;

import java.util.Scanner;

public class 별삼각형1_1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n>100 || n<1 || m <1 || m >3) {
			System.out.println("INPUT ERROR!");
		}else {
			switch (m) {
			case 1:
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<=i; j++) {
						System.out.print('*');
					}
					System.out.println();
				}
				break;

			case 2:
				for(int i = 0; i<n; i++) {
					for(int j = n; j>i; j--) {
						System.out.print('*');
					}
					System.out.println();
				}
				break;
			case 3:
				for(int i = 0; i<n; i++) {
					for(int j = n-i; j>1; j--) {
						System.out.print(' ');
					}
					for(int j = 0; j<i*2 +1; j++) {
						System.out.print('*');
					}
					for(int j = n-i; j>1; j--) {
						System.out.print(' ');
					}
					System.out.println();
				}
				break;
			}
		}
	}//main
}
