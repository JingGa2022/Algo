package problem.백준.class3;

import java.util.Scanner;

public class 집합_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int m = sc.nextInt();
		int bit = 0;
		int[] S = new int[m];
		
		for(int i = 0; i<m; i++) {
			String tmp = sc.next();
			int num;
			if(tmp.equals("add")) {
				num = sc.nextInt();
				bit |= (1 << (num-1));
			}else if(tmp.equals("remove")) {
				num = sc.nextInt();
				bit = bit &  ~(1 << (num-1));
			}else if(tmp.equals("check")) {
				num = sc.nextInt();
				sb.append((bit & (1 << (num - 1))) != 0 ? "1\n": "0\n");
			}else if(tmp.equals("toggle")) {
				num = sc.nextInt();
				bit ^= (1 << (num - 1));
			}else if(tmp.equals("all")) {
				bit |= (~0);
			}else if(tmp.equals("empty")) {
				bit &= 0;
			}
		}
		System.out.println(sb);
	}
}
