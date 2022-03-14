package problem.백준;

import java.util.Arrays;
import java.util.Scanner;

public class 통계학_2108 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[]num = new int[N];
		int[]num_minus = new int[N];
		int[] cnt = new int[4001]; //빈도수 세기
		int[] cnt_minus = new int[4001]; //음수 빈도수 인덱스
		int[] cnt_idx = new int[4001]; //빈도수 인덱스
		int[] cnt_minus_idx = new int[4001]; //음수 빈도수 인덱스
		int[] hap = new int[10000];// 최빈값들 넣는 통
		double sum = 0; //합
		int maxV=-10000; //최대값
		int minV=10000; //최소값
		int flag = 0;//음수양수 양수 0 음수 1
		for(int i =0; i<N; i++) {
			num[i] = sc.nextInt();
			sum += num[i];
			if(num[i]>maxV) maxV=num[i];
			if(num[i]<minV) minV=num[i];
			//마이너스일경우
			if(num[i] < 0) {
				num_minus[i] = num[i];
			}
		}
		//빈도 구하기
		for(int i =0; i<N; i++) {
			if(num[i]>=0) {
				cnt[num[i]] ++;			
			}else
				cnt_minus[Math.abs(num[i])]++;
		}
		//최빈값 구하기
		int maxIdx=0;
		for(int i =0; i<N; i++) {
			if(maxIdx < cnt[i]) {maxIdx = cnt[i];
			flag = 0;
			}
			if(maxIdx < cnt_minus[i]) {
				maxIdx = cnt_minus[i];
				flag = 1;
			}
		}
		//최빈값만 들어있는 배열 만들기
		for(int i =0; i<4001; i++) {
			if(flag == 0) {
				if(maxIdx == cnt[i]) cnt_idx[i] = i;
			}else {
				if(maxIdx == cnt_minus[i]) cnt_minus_idx[i] = -i;
			}
			
			
		}
		//양수 음수 최빈값 합하기
		for(int i = 0; i<4001; i++) {
			hap[i] -= cnt_minus_idx[i];
			hap[i+4001] = cnt_idx[i];
		}
		//정리할떄 편하게 0없애주기
		for(int i = 0; i<10000; i++) {
			if(hap[i]==0)
				hap[i]=4444;
		}
		double mean = sum/N;
		//정렬해서 2번쨰 작은 친구 구하기
		Arrays.sort(hap);
		Arrays.sort(num);
		
		//산술평균
		System.out.println(Math.round(mean));
		//중앙값
		System.out.println(num[N/2]);
		//최빈값
			if(hap[1] != 0) {
				System.out.println(hap[1]);
			}else {
				System.out.println(hap[0]);
			}
		//범위
		System.out.println(maxV-minV);
	}
}
