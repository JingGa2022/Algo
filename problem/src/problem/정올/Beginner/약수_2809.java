package problem.정올.Beginner;

import java.util.Arrays;
import java.util.Scanner;

public class 약수_2809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sq = (int) Math.sqrt(n);
		
		int[] arr = new int[10000];
		
		int cnt = 0;
		
		for(int i = 1; i<= sq; i++) {
			if(n % i == 0) {
				arr[cnt++]=i;
				if(n/i != i) arr[cnt++] = n/i;
			}
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i<10000; i++) {
			if(arr[i] != 0)
				System.out.print(arr[i] + " ");			
		}
	}
}
