package problem.백준.골드;

import java.util.*;

public class 수묶기_1744 {
	/* 1. 수를 정렬한다.
	 * 2. 음수는 음수끼리 작은순으로 곱하고 양수는 양수끼리 큰수로 곱할때 가장 커진다.
	 * 3. 1과 0의 경우는 무조건 더해야 한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int ans = 0;
		
		int mIdx = 0;
		while(mIdx < n && arr[mIdx] < 1) {
			if(mIdx + 1 < n && arr[mIdx + 1] < 1) {
				ans += arr[mIdx] * arr[mIdx+1];
				mIdx += 2;
			}else {
				ans += arr[mIdx++];
			}
		}
		
		int pIdx = n-1;
		while(pIdx >= mIdx && arr[pIdx] > 0) {
			if(pIdx - 1 >= mIdx && arr[pIdx -1] > 1) {
				ans += arr[pIdx] * arr[pIdx-1];
				pIdx -= 2;
			}else
				ans += arr[pIdx--];
		}
		
		System.out.println(ans);
	}
}
