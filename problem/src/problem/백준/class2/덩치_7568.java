package problem.백준.class2;

import java.util.Scanner;

public class 덩치_7568 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][3];
		
		for(int i =0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		
		for(int i = 0; i<N; i++) {
			int rank = 1;
			
			for(int j =0; j<N; j++) {
				if(i == j) continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					rank++;
				
			}
			System.out.print(rank + " ");
		}
		
	}//main
}
