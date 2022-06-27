package problem.백준.브론즈;

import java.util.Scanner;

public class 파티가끝나고난뒤_2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[5];
		
		for(int i = 0; i<5; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i<5; i++) {
			System.out.print(arr[i] - n*m + " ");
		}
		
	}
}
