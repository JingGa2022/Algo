package problem.백준.실버;

import java.util.*;

public class 과자나눠주기_16401 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		long ans = 0;
		
		for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		long s = 1;
		long e = arr[n-1];
		
		while(s <= e) {
			int cnt = 0;
			long mid = (s + e)/2;
			
			for(int i = 0 ; i<n; i++) cnt += arr[i]/mid;
			
			if(cnt >= m) {
				if(ans < mid) ans = mid;
				s = mid + 1;
			}else {
				e = mid -1;
			}
		}
		
		System.out.println(ans);
	}
}
