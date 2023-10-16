package problem.백준.실버;

import java.math.*;
import java.util.*;

public class 카드_11652 {
	/* 1.수의 크기가 매우 크기때문에 BigInteger 활용해서 사용
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int max = 0;
		BigInteger ans = null;
		HashMap<BigInteger, Integer> map = new HashMap<>(); 
		
		for(int i = 0; i<n; i++) {
			BigInteger tmp = sc.nextBigInteger();
			if(map.get(tmp) != null)
				map.put(tmp, map.get(tmp)+1);
			else
				map.put(tmp, 1);
			
			if(max < map.get(tmp)) {
				ans = tmp;
				max = map.get(tmp);
			}else if(max == map.get(tmp)) {
				ans = ans.min(tmp);
			}
		}
		
		System.out.println(ans);
	}
}
