package problem.APS심화;

import java.util.Scanner;

public class 장훈이의높은선반_1486 {
	static int N,B;
	static boolean[] sel;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();//
			B = sc.nextInt();//책장높이
			min = Integer.MAX_VALUE;
			
			int[] box = new int[N];
			sel = new boolean[N];
			for(int i = 0; i < N; i++) box[i] = sc.nextInt();
			
			pow(box, 0);
			System.out.println("#"+tc+ " " +min);
		}
	}//main
	
	private static void pow(int[] box, int i) {
		if(N == i) {
			int sum = 0;
			for(int a =0; a<N; a++) {
				if(sel[a] == false) continue;
			sum	+= box[a];
				
			}
			
			if(sum>=B) {
				if(min > (sum-B)) min = sum-B; 
			}
			return;
		}
				
		sel[i] = false;
		pow(box, i+1);
		sel[i] = true;
		pow(box, i+1);		
	}

	private static void swap(int[] box, int i, int j) {
		int tmp = box[i];
		box[i] = box[j];
		box[j] = tmp;
	}
	
}//class
