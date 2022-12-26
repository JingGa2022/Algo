package problem.백준;

import java.util.Scanner;

public class 주사위_1233 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] arr = new int[100];
		int max = 0;
		int ans = 0;
		
		for(int k = 1; k <=a; k++) {
			for(int i = 1; i <= b; i++) {
				for(int j = 1; j <= c; j++) {
					int sum = k + i + j;
					arr[sum]++;
					if(arr[sum] > max) max = arr[sum];
				}
			}
		}
		for(int i = 1; i<100; i++) {
			if(arr[i] == max) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
