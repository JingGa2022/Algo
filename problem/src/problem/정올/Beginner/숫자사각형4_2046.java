package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자사각형4_2046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		switch (m) {
		case 1:
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(j != n)
						System.out.printf("%d ",i);
					else
						System.out.printf("%d\n",i);
				}
			}
			break;
			
		case 2:
			for(int i = 1; i<=n; i++) {
				if(i % 2 != 0) {
					for(int j = 1; j<=n; j++) {
						if(j != n)
							System.out.printf("%d ",j);
						else
							System.out.printf("%d\n",j);
					}
				}
				else {
					for(int j = n; j>0; j--) {
						if(j != 1)
							System.out.printf("%d ",j);
						else
							System.out.printf("%d\n",j);
					}
				}
			}
			break;
			
		case 3:
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(j != n)
						System.out.printf("%d ",i*j);
					else
						System.out.printf("%d\n",i*j);
				}
			}
			break;
		}
	}
}
