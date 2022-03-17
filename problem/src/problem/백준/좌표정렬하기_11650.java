package problem.백준;

import java.util.Scanner;

public class 좌표정렬하기_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] spot = new int[N][2];//
		int[][] idx = new int[200001][2];//인덱스
		int[][] spot2 = new int[N][2];//1차 정렬후
		int[][] spot3 = new int[N][2];//2차 정렬후
		for(int i =0; i<N; i++) {
			spot[i][0] = sc.nextInt();
			spot[i][1] = sc.nextInt();
		}
		//카운팅정렬
		//먼저 1차를 정렬하고 2차를 정렬할것
		for(int i =0; i<N; i++) {
			if(spot[i][0] >= 0)
				idx[spot[i][0]+100000][0] ++;
			else
			idx[spot[i][0]][0] ++;
		}
		//누적합
		for(int i =1; i<200001; i++) {
			idx[i][0] += idx[i-1][0];
		}
		for(int i = N-1; i > 0; i--) {
			if(spot[i][0] >= 0) {
				spot2[idx[spot[i][0]+100000][0]][0] = spot[i][0];
				spot2[idx[spot[i][0]+100000][0]][1] = spot[i][1];//두번째도 따라가야하니까
			idx[spot[i][0]+100000][0] --;
			}
			else {
				spot2[idx[spot[i][0]][0]][0] = spot[i][0];
				spot2[idx[spot[i][0]][0]][1] = spot[i][1];
				idx[spot[i][0]][0] --;
			}
		}
		//그리고 0번재 것이 같다면 1번쨰를 카운팅 정렬하게 하면 됨
		for(int i = N-1; i>0; i++) {
			System.out.println(spot2[N][i]);
			
		}
	}//main
}
