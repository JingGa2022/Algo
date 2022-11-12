package problem.백준;

import java.util.Scanner;

public class 수열_2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		
		int[] arr = new int[n];
		
		int start = 0;
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(i<k) {
				cnt += arr[i];
				ans = cnt;
			}
			else {
				cnt += arr[i] - arr[start];
				start++;
				if(cnt > ans) {
					ans = cnt;
				}
			}
		}
		System.out.println(ans);
	}
}
