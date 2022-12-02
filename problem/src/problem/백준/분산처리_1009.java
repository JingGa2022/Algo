package problem.백준;

import java.util.Scanner;

public class 분산처리_1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = 1;
			
			for(int i = 0; i<b; i++) {
				c *= a;
				c %= 10;
			}
			if(c == 0) c = 10;
			sb.append(c + "\n");
		}
		System.out.println(sb);
	}
}
