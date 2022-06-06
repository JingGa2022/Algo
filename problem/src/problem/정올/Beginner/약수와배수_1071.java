package problem.정올.Beginner;

import java.util.Scanner;

public class 약수와배수_1071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i<n ;i ++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		
		int sum1 = 0;
		
		int sum2 = 0;
		
		for(int i =0; i<2; i++) {
			for(int j = 0; j<n; j++) {
				if(i == 0 && m % arr[j] == 0) sum1 += arr[j];
				else if(i == 1 && arr[j] % m == 0) sum2 += arr[j];
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
}
