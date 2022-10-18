package problem.백준;

import java.util.Scanner;

public class 재귀의귀재_25501 {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			String tmp = sc.next();
			ans = 0;
			System.out.printf("%d %d\n",isPalindrome(tmp), ans);
		}
	}

	private static int isPalindrome(String tmp) {
		// TODO Auto-generated method stub
		return recursion(tmp, 0, tmp.length() - 1);
	}

	private static int recursion(String tmp, int i, int r) {
		// TODO Auto-generated method stub
		ans++;
		if(i >= r) {
			return 1;
		}
		else if(tmp.charAt(i) != tmp.charAt(r)) {
			return 0;
		}
		else return recursion(tmp, i+1, r-1);
	}
	
}
