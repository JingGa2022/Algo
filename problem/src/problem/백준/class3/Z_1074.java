package problem.백준.class3;

import java.util.Scanner;

public class Z_1074 {
	static int N,R,C , size, cnt = 0;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		size = (int) Math.pow(2, N);
		
		circle(0,0, size);
		
	}
	private static void circle(int r, int c, int len) {
		if(len == 1) {
			System.out.println(cnt);
			return;
		}
		int newLen = len/2;
		if(R < r+ newLen && C < c + newLen) {
			circle(r, c, newLen);
		}
		else if(R < r+ newLen && c + newLen <= C) {
			cnt += (len*len) / 4;
			circle(r, c + newLen, newLen);
		}
		else if(r+ newLen <= R && C < c + newLen) {
			cnt += ((len*len) / 4) * 2;
			circle(r + newLen, c, newLen);
		}
		else  {
			cnt += ((len*len) / 4) * 3;
			circle(r + newLen, c + newLen, newLen);
		}
		
	}
}
