package problem.백준.브론즈;

import java.util.Scanner;

public class 피시방알바_1453 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[101];
		
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			int idx = sc.nextInt();
			if(arr[idx] == 0) {
				arr[idx]++;
			}else
				ans++;
		}
		System.out.println(ans);
	}
}
