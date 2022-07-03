package problem.백준;

import java.util.Scanner;

public class 합_8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ans = 0;
		
		for(int i = 1; i<=n; i++) ans+=i;
		
		System.out.println(ans);
	}
}
