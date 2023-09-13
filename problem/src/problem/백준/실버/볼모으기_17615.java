package problem.백준.실버;

import java.util.*;

public class 볼모으기_17615 {
	/*
	 * 1. r b 왼 오른쪽으로 갯수를 다 셈 2.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String colors = sc.next();
		int ans = n;
		int rCnt = 0;
		int bCnt = 0;

		for (int i = 0; i < n; i++) {
			if (colors.charAt(i) == 'R') {
				rCnt++;
			} else
				bCnt++;
		}

		int cnt = 0;
		
		//왼쪽으로 R을 옮길때 맨 앞쪽에 있는 R의 개수 세기
		for (int i = 0; i < n; i++) {
			if(colors.charAt(i) == 'R')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, rCnt - cnt);
		
		cnt = 0;
		for (int i = n-1; i >= 0; i--) {
			if(colors.charAt(i) == 'R')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, rCnt - cnt);
		
		cnt = 0;
		for (int i = 0; i < n; i++) {
			if(colors.charAt(i) == 'B')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, bCnt - cnt);
		
		cnt = 0;
		for (int i = n-1; i >= 0; i--) {
			if(colors.charAt(i) == 'B')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, bCnt - cnt);
		
		System.out.println(ans);
	}

}
