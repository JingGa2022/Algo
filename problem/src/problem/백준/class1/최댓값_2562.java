package problem.백준.class1;

import java.util.Scanner;

public class 최댓값_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int maxIdx = 0;
		int tmp = 0;
		
		for(int i = 0; i<9; i++) {
			tmp = sc.nextInt();
			if(tmp > max) {
				maxIdx = i+1;
				max = tmp;
			}
		}
		System.out.println(max);
		System.out.println(maxIdx);
	}
}
