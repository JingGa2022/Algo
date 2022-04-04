package problem.APS심화;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 규영이와인영이의카드게임_6808 {
	static List<Integer> card;//규영이
	static int[] card2;//인영이
	static boolean[] visited;
	static int[] result;
	static int N;
	static int ans = 0;
	static int kwin;//규영이 이긴횟수
	static int iwin;//인영이 이긴횟수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++) {
			
			N = 9;
			
			card = new LinkedList<>();//규영이카드
			//구영이 카드 입력
			for(int i = 0; i < 9; i++)
				card.add(sc.nextInt());
			//인영이 카드 입력
			card2 = new int[N];
			int idx = 0;
			for(int i =1; i <= 18; i++) {
				if(!card.contains(i)) {
					card2[idx++] = i;
				}
			}
			kwin = 0;
			iwin = 0;
			
			perm(0);
			
			System.out.printf("#%d %d %d\n",tc, kwin, iwin );
		}
	}// main

	private static void perm(int idx) {
		if(idx == N) {
			int ksum=0;
			int isum=0;
			
			for(int i =0; i<N; i++) {
				if(card.get(i)>card2[i])
					ksum += card.get(i) + card2[i];
				else 
					isum += card.get(i) + card2[i];	
			}
			
			if(ksum > isum)
				kwin++;
			else
				iwin++;
			return;
		}
		for(int i = idx; i < N; i++) {
			swap(idx, i);
			perm(idx+1);
			swap(idx, i);
		}
	}//perm

	private static void swap(int idx, int i) {
		int tmp = card2[idx];
		card2[idx] = card2[i];
		card2[i] = tmp;
		
	}

}
