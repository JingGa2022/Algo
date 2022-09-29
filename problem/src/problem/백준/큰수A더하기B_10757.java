package problem.백준;

import java.math.BigInteger;
import java.util.Scanner;

public class 큰수A더하기B_10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		System.out.println(A.add(B));
	}
}
