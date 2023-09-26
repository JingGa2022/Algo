package problem.백준.골드;

import java.util.*;

public class 계란으로계란치기_16987 {
	/* 1. 맨 왼쪽 계란 넣기 -> 한 계란을 들고 (pick) 남은 것들 중 찾아보기
	 * 2. 찾아본것 부수기
	 * 3. 원래 자리에 내려놓고 마지막 픽한것 옆에것 픽하고 계속진행
	 */
	static class Egg{
		int s;
		int w;
		
		Egg(int s, int w){
			this.s = s;
			this.w = w;
		}
	}
	static int n;
	static int max= Integer.MIN_VALUE;
	static Egg pick;
	static Egg[] egg;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		egg = new Egg[n];
		for(int i = 0; i<n; i++) egg[i] = new Egg(sc.nextInt(), sc.nextInt());
		
		pick = new Egg(egg[0].s, egg[0].w);
		
		solve(0, 0);
		
		System.out.println(max);
	}
	static void solve(int idx, int cnt) {
		if(idx == n) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(egg[idx].s <= 0 || cnt == n-1) {
			solve(idx+1, cnt);
			return;
		}
		
		int nCnt = cnt;
		for(int i =0 ; i<n; i++) {
			if(i == idx) continue;
			if(egg[i].s <= 0) continue;
			hitEgg(idx, i);
			
			if(egg[idx].s <= 0) cnt++;
			if(egg[i].s <= 0) cnt++;
			
			solve(idx + 1, cnt);
			recoverEgg(idx, i);
			cnt = nCnt;
		}
	}
	private static void hitEgg(int hEgg, int tEgg) {
		// TODO Auto-generated method stub
		egg[tEgg].s -= egg[hEgg].w;
		egg[hEgg].s -= egg[tEgg].w;
	}
	
	static void recoverEgg(int hEgg, int tEgg) {
		egg[tEgg].s += egg[hEgg].w;
		egg[hEgg].s += egg[tEgg].w;
	}
}
