package problem.백준.브론즈;

import java.util.Scanner;

public class 시험점수_5596 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = 0;
		int t = 0;
		
		for(int i =0; i<4; i++) s += sc.nextInt();
		
		for(int i =0; i<4; i++) t += sc.nextInt();
		
		if(s == t) System.out.println(s);
		else System.out.println(Math.max(s, t));
	}
}
