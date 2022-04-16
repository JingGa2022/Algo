package problem.백준.class1;

import java.util.Scanner;

public class 단어공부_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next().toUpperCase();
		
		int[] arr = new int[26];
		
		for(int i =0; i<s.length(); i++) arr[s.charAt(i) - 'A']++;
		
		int max = 0;
		char ch = '?';
		for(int a = 0; a<26; a++) {
			if(arr[a] > max) {
				max = arr[a];
				ch = (char)(a + 'A');
			}
			else if(arr[a] == max) ch = '?';
		}
		System.out.println(ch);
	}
}
