package problem.백준.실버;

import java.util.*;

public class 로마숫자만들기_16922 {
	static int[] list= {1,5,10,50};
	static boolean[] visit = new boolean[1001];
	static int ans,n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		solve(0, 0, 0);
		
		System.out.println(ans);
	}
	static void solve(int dept, int start, int sum) {
		if(dept == n) {
			if(!visit[sum]) {
				ans++;
				visit[sum] = true;
			}
			return;
		}
		
		for(int i = start; i<4; i++) {
			solve(dept+1, i, sum + list[i]);
		}
	}
}
