package problem.백준.브론즈;

import java.util.Scanner;

public class 점수계산_2506 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int[]arr = new int[n];
		int sum = 0;
		
		for(int i = 0; i<n ;i++) arr[i] = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i<n ;i++) {
			if(arr[i] == 1) {
				cnt++;
			}else {
				cnt = 0;
			}
			sum += cnt;
		}
		System.out.println(sum);
	}
}
