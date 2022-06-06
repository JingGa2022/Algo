package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자의개수_1430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] arr = new int[10];
		
		String num = Integer.toString(a*b*c);
		
		for(int i = 0; i<num.length(); i++) {
			int tmp = num.charAt(i) - '0';
			arr[tmp] ++;
		}
		
		for(int i = 0; i<10; i++) {
			System.out.println(arr[i]);
		}
	} 
}
