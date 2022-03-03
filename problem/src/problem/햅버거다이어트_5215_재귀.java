package problem;

import java.util.Scanner;

public class 햅버거다이어트_5215_재귀 {
	public static int N, L;
	public static int[] score, calorie;
	public static int ans;
	public static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			ans=0;
			score = new int[N];
			calorie = new int[N];
			
			for(int i  =0; i<N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			
			//비트연산 이용 
			for(int i =0; i<(1<<N); i++) {
				int sumScore = 0;
				int sumCal = 0;
				//i번쨰 햄버거 조사
				for(int j =0; j<N; j++) {
					if((i & (1 << j)) > 0) {
						sumScore += score[j];
						sumCal += calorie[i];
					}
				}
				if(sumCal <= L) {
					ans = Math.max(ans, sumScore);
				}
			}
			cook(0, sumScore, sumCal);
			System.out.println("#"+tc+""+ans);
		}
	}//main함수
	//매개변수 몇개를 중간값으로 더 넣어줄 경우
	//단 재료를 알수가 없다.
	public static void cook(int idx, int sumScore, int sumCal) {
		//기본
		//일단 햄버거 모든재료 고려
		if(sumCal > L) return; //백트래킹 :필요없는것 처내기
		if(idx>=N) {
			//어떤판단이 필요한가?
			if(sumCal<=L)
				ans = Math.max(ans, sumScore);
			return;
		}
		
		//재귀
		//뽑고가고
		cook(idx+1, sumScore+score[idx], sumCal+calorie[idx]);
		//안뽑고가고
		cook(idx+1, sumScore, sumCal);
	}
	
	
	
//	public static void cook(int idx) {
//		//기본
//		//햄버거 모든 재료 ㄷ ㅏ고려하고 판단만 남음
//		if(idx >= N) {
//			int sumScore = 0;
//			int sumCal = 0;
//			//재료 검사
//			for(int i =0; i<N; i++) {
//				if(sel[i]) {
//					sumScore += score[i];
//					sumCal += calorie[i];
//				}
//			}
//			if(sumCal <= L) {
//				ans = Math.max(ans,  sumScore);
//			}
//			return;
//		}
//		
//		//재귀
//		//해당 idx번쨰 재료 사용
//		sel[idx] = true;
//		cook(idx+1);
//		sel[idx] = false;
//		cook(idx +1);
//	}
}