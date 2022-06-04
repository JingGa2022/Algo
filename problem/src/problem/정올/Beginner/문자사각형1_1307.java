package problem.정올.Beginner;

import java.util.Scanner;

public class 문자사각형1_1307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		char[] alpha = new char[26];
		
		for(int i = 0; i<26; i++) {
			alpha[i] = (char) (65+i);
		}
		
		char[][] box = new char[n][n];
		
		int idx = 0;
		for(int i = n-1; i>=0; i--) {
			for(int j = n-1; j>=0; j--) {
				if(idx==26) idx=0;
				box[j][i] = alpha[idx];
				idx++;
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(j!= n)
					System.out.printf("%c ", box[i][j]);
				else
					System.out.printf("%c",box[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
