package problem.백준.class1;

import java.util.Scanner;

public class X보다작은수_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			int tmp = sc.nextInt();
			if(tmp < X) sb.append(tmp).append(" ");
		}
		System.out.println(sb);
	}
}
