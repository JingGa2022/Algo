package problem;

import java.util.Scanner;

public class View_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//  
		int max = 0;
		int sum = 0;
		int T = 1;
		//10번 반복
		while(T <= 10) {
			//가로 길이입력 건물배열 입력
			int row = sc.nextInt();
			int[] build = new int[row];
		//건물 길이 입력
		for(int i = 0; i < row; i++) build[i] = sc.nextInt();
		// 본인 주변 좌우2개씩 4개 중 가장 큰 수를 뽑고
		for(int n = 2; n < row - 2; n++) {
			int lmax = 0;
			int rmax = 0;
			if(build[n-2] > build[n-1]) lmax = build[n-2];
			else lmax = build[n-1];
			if(build[n+2] > build[n+1]) rmax = build[n+2];
			else rmax = build[n+1];
			if(lmax > rmax) max = lmax;
			else max = rmax;
			// 본인과 가장 큰수의 차가 0이상이면 더하고 아니면 계속진행
			if(build[n] - max > 0) sum += (build[n] - max);
			else continue;
		} 
		System.out.printf("#%d " + sum + "\n", T);
		sum = 0;
		T++;
		}
		
	}
}
