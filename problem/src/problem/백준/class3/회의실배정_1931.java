package problem.백준.class3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정_1931 {
	static int n; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<2 ;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
			
			
		});
		int cnt = 0;
		int prev = 0;
		
		for(int i = 0; i<n; i++) {
			if(prev <= arr[i][0]) {
				prev = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
