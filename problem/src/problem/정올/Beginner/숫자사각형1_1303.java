package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자사각형1_1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		for(int i = 0; i<n; i++) {
			int start = 1;
			start += m * i;
			for(int j = 0; j<m; j++) {
				int tmp = start + j;
				if(j != m-1)
					System.out.printf("%d ", tmp);
				else
					System.out.println(tmp);
			}
		}
	}
}
