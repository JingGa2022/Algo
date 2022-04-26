package problem.백준.class2;

import java.util.Scanner;

public class Hashing_15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문자열 길이
		int L = sc.nextInt();
		//
		String str = sc.next();
		//곱해줄 수
		long pow = 1;
		// 나눠줄 수
		int M = 1234567891;
		
		long sum = 0;
		for(int i = 0; i <L; i++) {
			int tmp= str.charAt(i) - 'a' + 1;
			sum += tmp*pow;
			//모듈러 연산의 분배법칙 활용
			pow = (pow*31)%M;
		}
		
			System.out.println(sum%M);
	}
}
