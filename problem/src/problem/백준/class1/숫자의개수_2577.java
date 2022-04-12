package problem.백준.class1;

import java.util.Scanner;

public class 숫자의개수_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String times = Integer.toString(a*b*c);
		
		int[]arr = new int[10];
		
		for(int i = 0; i<times.length(); i++) {
			arr[times.charAt(i) - '0']++;
		}
		
		for(int i = 0; i<10; i++)
			System.out.println(arr[i]);
	}
}
