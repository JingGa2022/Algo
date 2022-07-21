package problem.백준.class3;

import java.util.Scanner;

public class 색종이만들기_2630 {
	static int n, white, blue;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i = 0; i< n;i++) {
			for(int j = 0; j<n ;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		paper(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	private static void paper(int a, int b, int lenth) {
		// TODO Auto-generated method stub
		
		if(check(a, b, lenth)) {
			if(arr[a][b] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		int len = lenth / 2;
		
		paper(a, b, len);
		paper(a, b + len, len);
		paper(a + len, b, len);
		paper(a + len, b + len, len);
		
	}
	private static boolean check(int a, int b, int lenth) {
		// TODO Auto-generated method stub
		int tmp = arr[a][b];
		for(int i = a; i< a+lenth; i++) {
			for(int j = b; j<b+lenth; j++) {
				if(tmp != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	
}
