package problem.백준.class2;

import java.util.Scanner;

public class 최대공양수와최소공배수_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min = Math.min(a, b);
		int commonD = 0;//공약수
		int commonM = 0;//공배수
		
		//최대공약수
		for(int i = min; i>0; i--) {
			if(a % i == 0 && b % i ==0) {
				commonD = i;
				sb.append(i).append("\n");
				break;
			}
		}
			
		//최소공배수
		commonM = a/commonD*b;
		sb.append(commonM);
		
		System.out.println(sb);
		
	}
}
