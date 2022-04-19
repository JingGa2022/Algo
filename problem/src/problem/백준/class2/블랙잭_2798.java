package problem.백준.class2;

import java.util.Scanner;

public class 블랙잭_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		
		int[] cards = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i<N; i++) cards[i] = sc.nextInt();
		
		//순서가 상관없는 조합이기 때문에
		outer : for(int i = 0; i<N-2; i++) {
			//가지치기 card가 M보다 크다면 할 필요 없음
			if(cards[i] > M) continue;
			
			for(int j = i+1; j<N-1; j++) {
				
				//가지치기 i j 합이 M보다 크다면 할 필요 없음
				if(cards[j] + cards[i] > M) continue;
				
				for(int k = j+1; k<N; k++) {
					
					int tmp = cards[k] + cards[j] + cards[i];
					
					//M과 같은것이 있다면 더 구할 필요가 없음
					if(M == tmp) {
						ans = tmp; break outer;
					}
					
					//뽑은 친구가 M보다 작고 내가 이전에 가진 친구보단 클때만 보자
					if(tmp < M && ans < tmp) ans = tmp;
				}
			}
		}
		System.out.println(ans);
	}//main
}
