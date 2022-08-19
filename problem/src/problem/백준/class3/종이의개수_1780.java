package problem.백준.class3;

import java.util.Scanner;

public class 종이의개수_1780 {
	static int n, ans_1, ans0, ans1;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][n];
		ans_1= 0;//-1
		ans0= 0;//0
		ans1 = 0;//1
		
		for(int i =0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		square(0, 0, n);
		
		System.out.println(ans_1);
		System.out.println(ans0);
		System.out.println(ans1);
	}
	private static void square(int x, int y, int len) {
		if(check(x,y, len)) {
			switch (arr[x][y]) {
			case 1:
				ans1++;
				break;
			case 0:
				ans0++;
				break;
			case -1:
				ans_1++;
				break;
			}
		}else {
			int newLen = len/3;
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					square(x+ newLen*i, y + newLen*j, newLen);
				}
			}
		}
	}
	private static boolean check(int x, int y, int len) {
		int tmp = arr[x][y];
		for(int i = x; i<x+len; i++) {
			for(int j =y; j<y+len; j++) {
				if(tmp != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	
//	private static void square(int x, int y, int len) {
//		int newLen = len/3;
//		
//		for(int i = 0; i<9 ;i++) {
//			int newX = x + (newLen * i/3);
//			int newY = y + (newLen * i%3);
//			//System.out.printf("횟수: %d %d %d\n", i, newX, newY);
//			int check = paperCheck(newX, newY, newLen);
//			if(check == 2) {
//				square(newX, newY, newLen);
//			}else {
//				switch (check) {
//				case 1:
//					ans1++;
//					break;
//				case 0:
//					ans0++;
//					break;
//				case -1:
//					ans_1++;
//					break;
//				}
//			}
//		}
//		
//	}
//	private static int paperCheck(int x, int y, int len) {
//		int tmp = arr[x][y];
//		
//		for(int i = x ;i<x+len; i++) {
//			for(int j = y; j<y+len; j++) {
//				if(tmp != arr[i][j]) return 2;
//			}
//		}
//		return tmp;
//	}
}
