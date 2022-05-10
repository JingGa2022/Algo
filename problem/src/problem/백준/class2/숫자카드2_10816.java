package problem.백준.class2;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드2_10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] card1 = new int[N];
		int L = 0;//중복중 낮은것
		int H = 0; //중복중 높은것
		
		for(int i = 0; i<N; i++) {
			card1[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[] card2 = new int[M];
		
		for(int i = 0; i<M; i++) {
			card2[i] = sc.nextInt();
		}
		
		Arrays.sort(card1);
		
		
		for (int i =0; i<M; i++){
			int mid = N/2;
			int high = N;
			int low = 0;
			
		while(low < high) {
			mid = (high + low)/2;
			
			if(card2[i] <= card1[mid]) {
				high = mid;
			}
			else
				low = mid + 1;
			}
		
		L = low;
		high = N;
		low = 0;
		
		while(low < high) {
			mid = (high + low)/2;
			
			if(card2[i] < card1[mid]) {
				high = mid;
			}
			else
				low = mid + 1;
			}
		H = low;

		sb.append(H-L).append(' ');
		}//for
		
		System.out.println(sb);
	}//main
}
