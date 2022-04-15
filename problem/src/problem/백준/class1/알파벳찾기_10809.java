package problem.백준.class1;

import java.util.Arrays;
import java.util.Scanner;

public class 알파벳찾기_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int arr[] = new int [26];
		
		Arrays.fill(arr, -1);
		
		for(int i = 0; i<s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			if(arr[idx] == -1)
				arr[idx] = i;
		}
		
		for(int a : arr) System.out.printf("%d ",a);
	}
}
