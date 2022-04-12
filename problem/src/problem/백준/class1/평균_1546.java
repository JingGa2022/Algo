package problem.백준.class1;

import java.util.Scanner;

public class 평균_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		double M = 0;
		
		double sum = 0;
		double[] box = new double[N];
		for(int i = 0; i<N; i++) {
			double tmp = sc.nextDouble();
			if(tmp > M) M = tmp;
			box[i] = tmp;
		}
		
		for(int i = 0; i<N; i++) {
			box[i] = box[i]/M * 100;
			sum += box[i];
		}
		
		double mean = sum / N;
		
		System.out.println(mean);
	}
}
