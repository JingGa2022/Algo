package problem.백준;

import java.util.Scanner;

public class 분수찾기_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int sum = 0;
		int plus = 0;
		
		while(sum < x) {
			plus ++;
			
			sum += plus;
		}
	
		sum -= plus;

		
		if(plus % 2 == 0) {
			System.out.printf("%d/%d\n", x - sum, plus + sum - x + 1);
		}else {
			System.out.printf("%d/%d\n", plus + sum - x + 1, x - sum);
		}
	}
}
