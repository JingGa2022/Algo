package problem.백준;

import java.util.Scanner;

public class 오븐시계_2525 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int A = sc.nextInt(); // 시
	int B = sc.nextInt(); // 분
	int C = sc.nextInt(); // 추가 시간
	int minute = (C%60 + B) % 60;
	int hour = C/60 + A + (C%60 + B)/60;
	
	if(hour >= 24) {
		hour -= 24;
	}
	System.out.printf("%d %d", hour, minute);
	}
}
