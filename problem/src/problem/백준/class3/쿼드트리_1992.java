package problem.백준.class3;

import java.util.Scanner;

public class 쿼드트리_1992 {
	static int n;
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		n = sc.nextInt();
		
		arr = new int[n][n];
		
		for(int i = 0; i<n ;i++) {
			String s = sc.next();
			for(int j = 0; j<n; j++) {
				arr[i][j] = s.charAt(j) - '0'; 
				
			}
		}
		
		square(n, 0, 0);
		
		System.out.println(sb);
	}//main
	
	private static void square(int num, int x, int y) {
		sb.append("(");
		
		if(num == 1) {
			sb.append(arr[x][y]);
		}
		else {
		int len = num/2;
		int tmp;
		//System.out.println(len);
		
		for(int h = 0; h<4; h++) {
			boolean check = false;
			int[] row = {x, x + len};
			int[] col = {y, y + len};
			if(h == 1 || h == 3) {
				col[0] += len;
				col[1] += len;
			}
			if(h == 2 || h == 3) {
				row[0] += len;
				row[1] += len;
			}
			//System.out.printf("(%d, %d) (%d, %d)\n",row[0], col[0], row[1], col[1]);
			tmp = arr[row[0]][col[0]]; //첫번째친구
			outer: for(int i = row[0]; i<row[1] ;i++) {
				for(int j = col[0]; j<col[1]; j++) {
					if(tmp != arr[i][j]) {
						check = true;
						break outer;
					}
				}			
			}
			
			if(check) {
				square(len, row[0], col[0]);
			}else {
				sb.append(tmp);
			}
			//System.out.printf("%b %d 도는중", check, tmp);
		}//
		}
		//System.out.println("끝");
		sb.append(")");
	}
}
