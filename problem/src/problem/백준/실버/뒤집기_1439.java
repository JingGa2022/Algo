package problem.백준.실버;

import java.util.Arrays;
import java.util.Scanner;

public class 뒤집기_1439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int check = s.charAt(0) - '0';
		int[] arr = new int[2];
		arr[check]++;
		
		for(int i = 1; i<s.length(); i++) {
			int comp = s.charAt(i) - '0';
			if(check != comp) {
				check = comp;
				arr[check]++;
			}
		}
		Arrays.sort(arr);
		
		System.out.println(arr[0]);
	}
}
