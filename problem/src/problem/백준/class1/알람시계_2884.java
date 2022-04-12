package problem.백준.class1;

import java.util.Scanner;

public class 알람시계_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		
		
		if(M-45 < 0) {
			if(H != 0) {H-=1;
			M = 60 + M - 45;
			}else {
				H = 23;
				M = 60 + M - 45;			
			}
				
		}else {
			M = M - 45;
		}
		
		System.out.println(H +" " + M);
	}
}
