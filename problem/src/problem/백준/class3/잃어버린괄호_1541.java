package problem.백준.class3;

import java.util.Scanner;

public class 잃어버린괄호_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String formula = sc.next();
		
		String[] minus = formula.split("-");
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i<minus.length; i++) {
			int tmp = 0;
			
			String[] plus = minus[i].split("\\+");
			for(int j = 0; j<plus.length; j++) {
				tmp += Integer.parseInt(plus[j]);
			}
			
			if(ans == Integer.MAX_VALUE) {
				ans = tmp;
			}else {
				ans -= tmp;
			}
		}
		
		System.out.println(ans);
		
	}
}
