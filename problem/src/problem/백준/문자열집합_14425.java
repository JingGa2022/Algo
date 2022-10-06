package problem.백준;

import java.util.Scanner;

public class 문자열집합_14425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = 0;
		
		String s[] = new String[n];
		
		for(int i = 0; i<n; i++) {
			s[i] = sc.next();
		}
		
		for(int i = 0 ;i<m; i++) {
			String tmp = sc.next();
			
			for(int j = 0; j<n; j++) {
				if(s[j].equals(tmp)) ans++;
			}
		}
		System.out.println(ans);
	}
}
