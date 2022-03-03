package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_1861_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();//엄선된 손님의 수
			int M = sc.nextInt();//만드는데 걸리는 시간
			int K = sc.nextInt();//한번에 만들 수 있는 뿡어의 수
			int[] arrive = new int[N];//손님 도착시간
			int ans = 1;
			for(int i =0; i<N; i++) arrive[i] = sc.nextInt();
			Arrays.sort(arrive);
			for(int i =0; i<N; i++) {
				int bread = (arrive[i]/M) * K;
				if(bread < i+1) {
					ans = 0;
				break;
				}
			}
			if(ans == 1)
				System.out.printf("#%d %s\n",tc, "Possible");
			else
				System.out.printf("#%d %s\n",tc, "Impossible");
		}
	}
}