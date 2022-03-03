package problem;

import java.util.Scanner;

public class 부분수열의합_2817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
		//수열의 크기 
		int N = sc.nextInt();
		//합 사이즈
		int A = sc.nextInt();
		//테스트 케이스만큼 돌리기
		int[] box = new int[N];
		//A의 조합개수
		int[] cnt = new int[1];
		//수열크기만큼의 boolean 배열과 숫자가 들어간  box 배열
		boolean[] sel = new boolean[N];
		//box에 숫자넣기
		for(int i = 0; i < N; i++) box[i] = sc.nextInt();
		powerset(0, sel, box, A, cnt);
		System.out.printf("#%d %d\n",tc, cnt[0]);
		}
	}
	
	public static void powerset(int idx, boolean[] sel, int[] box, int A, int[] cnt) {
		//합 
		int sum = 0;
		if(idx == sel.length) {
			for(int i = 0; i < sel.length; i++) {
				if(sel[i])
				sum += box[i];
			}
			//A와 부분집합의 합이 같을때
			if(sum == A)
			cnt[0]++;
			return;
		}
		
		sel[idx] = true;
		powerset(idx + 1, sel, box, A, cnt);
		sel[idx] = false;
		powerset(idx + 1, sel, box, A, cnt);
		if(idx == 0) return;
	}
}
