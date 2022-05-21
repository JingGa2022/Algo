package problem.백준.class3;

import java.util.Scanner;

public class 피보나치함수_1003 {
	static int[][] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int max = 0;
		int[] nums = new int[tc];
		
		for(int i = 0; i<tc; i++) {
			nums[i] = sc.nextInt();
			max = Math.max(max, nums[i]);
		}
		int[] arr = new int[2];
		
		list = new int[max + 1][2];
		list[0][0]++;
		list[1][1]++;
		
		fibo(max, arr);
		
		for (int t = 0; t < tc; t++) {
			int idx = nums[t];

			arr[0] = list[idx][0];
			arr[1] = list[idx][1];

			System.out.printf("%d %d\n", arr[0], arr[1]);
		} // for
	}// main

	public static void fibo(int num, int[] arr) {
		if(num == 0 && num == 1) return;
		else {
			for(int i = 2; i<=num; i++) {
				list[i][0] = list[i-1][0] + list[i-2][0];
				list[i][1] = list[i-1][1] + list[i-2][1];
			}
		}
	}
}
