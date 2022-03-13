package problem.백준;

import java.util.Scanner;

public class 부녀회장이될테양_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =0; tc<T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int sum = 0;
			int[] home = new int[k*(n+1)];
			for(int i = 1; i<=n; i++) sum += i;
			home[0] = sum;
			for(int i = 1; i<k*n;i++) {home[i] += home[i-1];
			System.out.println(home[i]);
			}
			
			System.out.println(home[k*n-1]);
		}
	}
}
