package problem.백준.브론즈;

import java.math.BigInteger;
import java.util.Scanner;

public class 긴자리계산_2338 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
	}
}
