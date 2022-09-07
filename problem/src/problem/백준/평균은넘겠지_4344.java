package problem.백준;

import java.util.Scanner;

public class 평균은넘겠지_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			
			int n = sc.nextInt();
		double[] arr = new double[n];
		double mean = 0;
		double cnt = 0;
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			mean += arr[i];
		}
		mean = mean/n;
		for(int i = 0; i<n; i++) {
			if(arr[i] > mean) cnt++;
		}
		System.out.println(String.format("%.3f",cnt/n*100) + "%");
		}
		
	}
}
