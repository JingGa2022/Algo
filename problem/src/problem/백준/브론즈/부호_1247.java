package problem.백준.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 부호_1247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc<3; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			BigInteger sum = new BigInteger("0");
			
			
			for(int i = 0; i<N; i++) {
				BigInteger tmp = new BigInteger(br.readLine());
				sum = sum.add(tmp);
			}
			
			if(sum.compareTo(BigInteger.ZERO) == -1) {
				System.out.println("-");
			}else if(sum.compareTo(BigInteger.ZERO) == 1) {
				System.out.println("+");
			}else
				System.out.println(0);
			
		}
	}
}
