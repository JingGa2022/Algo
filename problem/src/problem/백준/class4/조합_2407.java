package problem.백준.class4;

import java.math.BigInteger;
import java.util.Scanner;

public class 조합_2407 {
	static BigInteger n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextBigInteger();
		m = sc.nextBigInteger();
		
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for(int i = 0; i< m.intValue(); i++) {
			BigInteger tmp = BigInteger.valueOf(i);
			up = up.multiply(n.subtract(tmp));
			down = down.multiply(m.subtract(tmp));
		}
		BigInteger ans = up.divide(down);
		
		System.out.println(ans);
	}
}
