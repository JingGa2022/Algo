package problem;

import java.util.Scanner;

public class Ladder1_1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10개의 테스트케이스
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] testbox = new int[102][102];
			for(int i = 1; i < 101; i ++) {
				for(int j =1; j<101; j++) testbox[i][j] = sc.nextInt();
			}
			int dir = 0; //0:위 1:좌 2:우
			int goalr = 100;
			int goalc = -1;
			for(int i = 1; i < 101; i ++) {
				if (testbox[100][i] == 2) goalc = i;
			}
			while(goalr != 1) {
			if(testbox[goalr][goalc - 1] == 1 && dir == 1 || testbox[goalr][goalc - 1] == 1 && dir == 0) {
				goalc--;
				dir = 1;
			}else if(testbox[goalr][goalc + 1] == 1 && dir == 2 || testbox[goalr][goalc + 1] == 1 && dir==0) {
				goalc++;
				dir = 2;
			}else if(testbox[goalr - 1][goalc] == 1) {
				goalr--;
				 dir = 0;
			}
			}//while
			System.out.printf("#%d %d\n",T, goalc-1);
		}//for
	}//main
}
