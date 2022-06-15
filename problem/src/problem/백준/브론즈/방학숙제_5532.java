package problem.백준.브론즈;

import java.util.Scanner;

public class 방학숙제_5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int ans = L;
		
		int a = 0;
		int b = 0;
		
		if(A % C == 0) a = A/C;
		else a = A/C +1;
		if(B % D == 0) b = B/D;
		else b = B/D +1;
		
		ans -= Math.max(a, b);
		
		System.out.println(ans);
	}
}
