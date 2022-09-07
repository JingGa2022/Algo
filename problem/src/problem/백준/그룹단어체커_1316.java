package problem.백준;

import java.util.Scanner;

public class 그룹단어체커_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] arr = new String[n];
		int ans = 0;
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.next();
		}
		
		for(int i = 0; i<n; i++) {
			boolean[] done = new boolean[26];
			String s = arr[i];
			char check = s.charAt(0);
			boolean flag = false;
			for(int j = 0; j < arr[i].length(); j++) {
				if(check != s.charAt(j) && done[s.charAt(j)-'a']) {
					flag = true;
				}
				check = s.charAt(j);
				done[s.charAt(j)-'a'] = true;
			}
			if(!flag) ans++;
		}
		System.out.println(ans);
		
	}
}
