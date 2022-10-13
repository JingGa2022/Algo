package problem.백준;

import java.util.Scanner;

public class 소트인사이드_1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s = sc.next();
		
		int[] arr = new int[10];
		
		for(int i = 0; i<s.length(); i++) {
			int tmp = Integer.parseInt(s.substring(i, i+1));
			arr[tmp]++;
		}
		for(int i = 9; i>=0; i--) {
			for(int j = 0; j<arr[i]; j++) sb.append(i);
		}
		System.out.println(sb);
	}
}
