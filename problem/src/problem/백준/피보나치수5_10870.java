package problem.백준;

import java.util.Scanner;

public class 피보나치수5_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(fibo(n));
	}

	private static int fibo(int n) {
		if (n == 1 || n == 2)
			return 1;
		if (n == 0)
			return 0;
		return fibo(n - 1) + fibo(n - 2);
	}

}
