package problem.백준;

import java.util.Scanner;

public class ACM호텔_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int H = sc.nextInt();// 호텔의 층수
			int W = sc.nextInt();// 각층의 방수
			int N = sc.nextInt();// 몇 번째 손님인지
			int[][] hotel = new int[H][W];
			
			int x=0;//호텔 층
			int y=0;//호텔 객실
			for(int i = 0; i < N; i++) {
				if(x==H) {
					x=0;
					y++;
				}
				hotel[x++][y] = 1;//고객 채우기
			}
			if(y<9)
				System.out.printf("%d0%d\n",x,y+1);
			else
				System.out.printf("%d%d\n",x,y+1);
			
		}// test case
	}//main
}
