package problem.백준.class4;

import java.util.Scanner;

public class LCS_9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		int[][] LCS = new int[str1.length()+1][str2.length() +1];
		
		for(int i = 0; i<str1.length(); i++) {
			for(int j = 0; j<str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					LCS[i+1][j+1] = LCS[i][j] + 1;
				}else
					LCS[i+1][j+1] = Integer.max(LCS[i][j+1], LCS[i+1][j]);
			}
		}
		System.out.println(LCS[str1.length()][str2.length()]); 
	}
}
