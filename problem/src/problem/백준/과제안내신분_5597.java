package problem.백준;

import java.util.Arrays;
import java.util.Scanner;

public class 과제안내신분_5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] arr1 = new boolean[31];
		int[] arr = new int[2];
		
		for(int i = 1 ; i<=28; i++) {
			int a = sc.nextInt();
			arr1[a] = true;
		}
		int idx = 0;
		for(int i = 1 ; i<=30; i++) {
			if(!arr1[i]) {
				arr[idx++] = i;
			}
		}
		
		
		Arrays.sort(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
