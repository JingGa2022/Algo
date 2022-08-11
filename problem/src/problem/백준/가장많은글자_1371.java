package problem.백준;

import java.util.Scanner;

public class 가장많은글자_1371 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[26];
		int max = 0;
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			for(int i =0 ; i<s.length(); i++) {
				if(s.charAt(i)>'a' && s.charAt(i) < 'z') arr[s.charAt(i) - 'a']++;
			}

		}
		
		for(int i = 0; i<26; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		for(int i = 0; i<26; i++) {
			if(arr[i] == max) System.out.print((char)(i+'a'));
		}
	}
}
