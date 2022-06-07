package problem.정올.Beginner;

import java.util.Scanner;

public class 별삼각형2_1719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n>100 || n<1 || n % 2==0 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
		}else {
			switch (m) {
			case 1:
				for(int i = 0 ;i<n; i++) {
					if(i < n/2) {
						for(int j = 0; j<=i; j++) {
							System.out.print("*");
						}
					}else {
						for(int j = 0; j<n-i; j++) {
							System.out.print("*");
						}						
					}
					System.out.println();
				}
				break;

			case 2:
				for(int i = 0 ;i<n; i++) {
					if(i <= n/2) {
						for(int j = i; j<n/2; j++) {
							System.out.print(" ");
						}
						for(int j = 0; j<=i; j++) {
							System.out.print("*");
						}
					}else {
						for(int j = n/2; j<i; j++) {
							System.out.print(" ");
						}
						for(int j = i; j<n; j++) {
							System.out.print("*");
						}						
					}
					System.out.println();
				}
				
				break;
				
			case 3:
				for(int i = 0 ;i<n; i++) {
					if(i <= n/2) {
						for(int j = 0; j<i; j++) {
							System.out.print(" ");
						}
						for(int j = 0; j<n-2*i; j++) {
							System.out.print("*");
						}
						for(int j = 0; j<i; j++) {
							System.out.print(" ");
						}
					}else {
						for(int j = i; j<n-1; j++) {
							System.out.print(" ");
						}
						for(int j = 0; j<=n - 2*(n-i) + 1; j++) {
							System.out.print("*");
						}						
						for(int j = i; j<n-1; j++) {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				
				break;
			case 4:
				for(int i = 0 ;i<n; i++) {
					if(i <= n/2) {
						for(int j = 0; j<i; j++) {
							System.out.print(" ");
						}
						for(int j = 0; j<=n/2 - i; j++) {
							System.out.print("*");
						}
					}else {
						for(int j = 0; j<n/2; j++) {
							System.out.print(" ");
						}
						for(int j = 0; j<=n/2 - (n-i-1); j++) {
							System.out.print("*");
						}						
					}
					System.out.println();
				}
				
				break;
			}
		}
	}
}
