package problem.백준.브론즈;

import java.util.Scanner;

public class 나누기_1075 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		int ans = 0;
		
			int tmp = N % 100;
			
			N -= tmp;

		
		for(int i = 0; i< 99; i++) {
			if(N % F==0) 
				break;
			ans++;
			N++;
		}
		
		if(ans < 10) System.out.printf("0%d", ans);
		else System.out.println(ans);
	}
}
