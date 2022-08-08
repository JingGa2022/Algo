package problem.백준;

import java.util.Scanner;

public class 그대로출력하기_11718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNext()) {
			sb.append(sc.nextLine()).append("\n");
		}
		System.out.println(sb);
	}
}
