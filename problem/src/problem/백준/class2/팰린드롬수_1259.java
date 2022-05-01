package problem.백준.class2;

import java.util.Scanner;

public class 팰린드롬수_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String N = sc.next();
		while(!N.equals("0")) {
			String check = N;
			int len = N.length();
			//체크용
			boolean flag = false;
			
			for(int i = 0; i<len/2; i++) {
				if(N.charAt(i) != check.charAt(len -1 -i)) {
					sb.append("no").append("\n");
					flag = true;
					break;
				}					
			}
			if(!flag) sb.append("yes").append("\n");
			N = sc.next();
		}
		System.out.println(sb);
	}
}
