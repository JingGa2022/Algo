package problem.백준.골드;

import java.util.*;

public class 톱니바퀴_14891 {
	/*
	 * 1. 만나는 지점은 3/ 7 3 /7 3/ 7 번째의 톱니바퀴이다. 2. 만나는 지점이 반대면 지정 방향대로 돌고 1(시계 방향) 아니면
	 * 그대로 3. 마지막으로 최종상태에서 1번 톱니의 극을 통해 점수를 출력하믄 된다.
	 */
	static int[][] cogwheel;
	static int[] d;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cogwheel = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String s = sc.next();

			for (int j = 0; j < s.length(); j++) {
				cogwheel[i][j] = s.charAt(j) - '0';
			}
		}

		int n = sc.nextInt();

		while (n-- > 0) {
			int num = sc.nextInt() - 1;
			int dir = sc.nextInt();

			d = new int[4];

			d[num] = dir;
			check(num);
			Rolling();
		}
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			ans += cogwheel[i][0] * Math.pow(2, i);
		}

		System.out.print(ans);
	}

	private static void Rolling() {
		// TODO Auto-generated method stub
		int tmp = 0;
		for(int i = 0; i<4; i++) {
			
		if(d[i] == 1) {
			tmp = cogwheel[i][7];
			for(int j = 7; j>0; j--) {
				cogwheel[i][j] = cogwheel[i][j-1];
			}
			cogwheel[i][0] = tmp;
		}else if(d[i] == -1) {
			tmp = cogwheel[i][0];
			for(int j = 0; j<7; j++) {
				cogwheel[i][j] = cogwheel[i][j+1];
			}
			cogwheel[i][7] = tmp;
		}
	}
	}

	private static void check(int num) {
		for (int i = num - 1; i >= 0; i--) {
			if(cogwheel[i+1][6] != cogwheel[i][2]) {
				d[i] = -d[i+1];
			}else
				break;
		}
		for (int i = num + 1; i < 4; i++) {
			if(cogwheel[i][6] != cogwheel[i-1][2]) {
				d[i] = -d[i-1];
			}else
				break;
		}
	}

//	static int[][] cogwheel;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		cogwheel = new int[4][8];
//		
//		for(int i = 0; i<4; i++) {
//			String s = sc.next();
//			
//			for(int j = 0; j<s.length(); j++) {
//				cogwheel[i][j] = s.charAt(j) - '0';
//			}
//		}
//		
//		int n = sc.nextInt();
//
//		for(int i = 0; i<n; i++) {
//			int num = sc.nextInt()-1;
//			int dir = sc.nextInt();
//			boolean[] check = new boolean[3];
//			
//			for(int j = 0; j<3; j++) {
//				if(cogwheel[j][2] == cogwheel[j+1][6]) check[j] = true;
//			}
//			Rolling(num, dir);
//			
//			//오른쪽
//			for(int j = 1; j<=3; j++) {
//				if(num + j > 3) break;
//				int tmp = (2 * num + j)/2;
//				if(!check[tmp]) {
//					if(dir == 1)
//						Rolling(num + j, -1);
//					else
//						Rolling(num + j, 1);
//				}
//			}
//			//왼쪽
//			for(int j = 1; j<=3; j++) {
//				if(num - j < 0) break;
//				int tmp = (2 * num - j)/2;
//				if(!check[tmp]) {
//					if(dir == 1)
//						Rolling(num - j, -1);
//					else
//						Rolling(num - j, 1);
//				}
//			}
//		}
//		
//		int ans = 0;
//		for(int i = 0 ; i<4; i++) {
//			ans += cogwheel[i][0] * Math.pow(2, i);
//		}
//		
//		for(int i = 0 ; i<4; i++) {
//			for(int j =0 ;j<8; j++) {
//				System.out.print(cogwheel[i][j]);				
//			}
//			System.out.println();
//		}
//		
//		System.out.print(ans);
//	}
//	private static void Rolling(int num, int dir) {
//		// TODO Auto-generated method stub
//		int tmp = 0;
//		if(dir == 1) {
//			tmp = cogwheel[num][7];
//			for(int i = 7; i>=0; i--) {
//				if(i == 0) {
//					cogwheel[num][i] = tmp;
//					break;
//				}
//				cogwheel[num][i] = cogwheel[num][i-1];
//			}
//		}else {
//			tmp = cogwheel[num][0];
//			for(int i = 0; i<8; i++) {
//				if(i == 7) {
//					cogwheel[num][i] = tmp;
//					break;
//				}
//				cogwheel[num][i] = cogwheel[num][i+1];
//			}
//		}
//	}
}
