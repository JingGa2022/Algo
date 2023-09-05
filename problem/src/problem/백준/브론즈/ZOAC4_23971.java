package problem.백준.브론즈;

import java.util.Scanner;

public class ZOAC4_23971 {
	/* 1. 들어 갈 수 있는 수는 길이 / (거리+1)의 올림이다. 
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int ans = ((h-1) / (n+1) +1) * ((w-1) / (m+1) + 1);
		System.out.println(ans);
	}
}
