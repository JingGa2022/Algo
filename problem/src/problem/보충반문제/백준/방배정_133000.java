package problem.보충반문제.백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 방배정_133000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 학생수
		int K = sc.nextInt();// 방당 최대인원
		int[][] stu = new int[N][2];// 학생의 정보
		int[][] cnt = new int[7][2];//학생수 카운팅
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++)
				stu[i][j] = sc.nextInt();
		}

		//학년별학생수세기
			for(int j = 0; j<N ; j++) {
				if(stu[j][0]==0) 
					cnt[stu[j][1]][0]++;
			else if(stu[j][0]==1)
				cnt[stu[j][1]][1]++;
		}
		
			// 학년별 학생수로 방 구하기
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++)
				if(cnt[i][j]<= K && cnt[i][j]>0) { //0보다크고 K아래일떄
					ans++;
				}else if(cnt[i][j]>K) { //k명보다 학년수가 많은때
					while(cnt[i][j]>0) {
						cnt[i][j] -=K;
						ans++;
					}
				}
		}
		System.out.println(ans);
		
	}// main
}
