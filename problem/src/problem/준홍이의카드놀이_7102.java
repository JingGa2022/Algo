package problem;

import java.util.Scanner;

public class 준홍이의카드놀이_7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			
			int[]sum = new int[N+M+1];
			int maxValue = 0;
			
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					//해당 합을 카운팅 누적시킨다.
					sum[i+j]++;
					//
					if(maxValue < sum[i+j]) maxValue = sum[i+j];
				}
			}
			
			System.out.print("#"+tc);
			for(int i = 2; i<sum.length; i++) {
				if(sum[i] == maxValue) {
					System.out.println(" " +i);
				}
			}
			System.out.println();
		}
	}
}
