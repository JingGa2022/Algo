package problem.백준;

import java.util.Scanner;

public class 치킨쿠폰_1673 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		int n = sc.nextInt();//시킬수 있는 칰니의 수
		int k = sc.nextInt();//쿠폰 교환 수
		if(n==0&&k==0) {
			break;
		}
		
		int ans = n;
		
		while(n>=k) {
			ans += n/k;
			n = n/k;
		}
		System.out.println(ans);
		}
	}
}	
