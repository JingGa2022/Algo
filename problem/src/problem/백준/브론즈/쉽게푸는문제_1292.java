package problem.백준.브론즈;

import java.util.Scanner;

public class 쉽게푸는문제_1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int cnt = 1;
		
		int arr[] = new int[1001];
		
		for(int i = 1; i<=1000; i++) {
			for(int j = 0; j<i; j++) {
				if(cnt == 1001) break;
				arr[cnt] = i;
				cnt ++;
			}
		}
		int ans = 0;
		
		for(int i = A; i<=B; i++) ans += arr[i];
		
		System.out.println(ans);
	}
}
