package problem.백준;

import java.util.Scanner;

public class 하노이의탑이동순서_11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int tmp = (int) (Math.pow(2, n) - 1);
		sb.append(tmp + "\n");
		
		move(n, 1, 2, 3);
		
		System.out.println(sb);
	}
	private static void move(int num, int start, int mid, int to) {
		
		if(num == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		move(num-1, start, to, mid);
		
		sb.append(start + " " + to + "\n");
		
		move(num-1, mid, start, to);
	}
}
