package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();//엄선된 손님의 수
			int M = sc.nextInt();//만드는데 걸리는 시간
			int K = sc.nextInt();//한번에 만들 수 있는 뿡어의 수
			int[] arrive = new int[N];//손님 도착시간
			int ans = 1;
			int[] sell = new int[11112]; //인덱스가 그 사람이 도착한 시간
			//해당 시간에 온 사람들 첵
			for(int i =0; i<N; i++) {
				int time = sc.nextInt();
				sell[time]++;
			}
			int bread = 0;
			for(int i =0; i<sell.length; i++) {
				if(i>0 && i%M==0)//빵만들기
					bread += K;
				bread -= sell[i]; //1초에 온 사람수 만큼 빵을 팔겠다.
				if(bread<0) {
					ans = 0;
					break;
				}
			}
			//1번풀이
//			//헤당손님이 올때 붕어빵이 있ㄴ느지
//			for(int i = 0; i<N; i++) arrive[i]=sc.nextInt();
//			Arrays.sort(arrive);//정렬
//			for(int i =0; i<N; i++) {
//				int bread = (arrive[i]/M) *K;//해당시간에 만들수있는 빵의 총량이 도착한 손님 수보다 적다면 안됨
//				if(bread < i+1) {
//					ans = 0;
//					break;
//				}
//			}
			
			if(ans == 1)
				System.out.printf("#%d %s\n",tc, "Possible");
			else
				System.out.printf("#%d %s\n",tc, "Impossible");
		}
	}
}
//
//for(int i = 0; i<N; i++) arrive[i]=sc.nextInt();
//Arrays.sort(arrive);//정렬
//if(arrive[0]>M) ans = 0;//
//for(int i =1; i<N; i++) {
//	int gap = Math.abs(arrive[i] - arrive[i-1]);//손님간 시간차
//	int overlap = 0;
//	for(int j : arrive) {//손님의 시간이 겹칠떄
//		if(arrive[0] == arrive[i]) overlap++;
//		if(j == arrive[i]) overlap++;
//	}
//	if(M/K > gap) ans = 0; //시간차가 1개 생산속도보다 작을때	
//	if(overlap > 0 && overlap/arrive[i] > M/K) ans = 0; //초당 손님이 초당 생산량보다 클경우
//}