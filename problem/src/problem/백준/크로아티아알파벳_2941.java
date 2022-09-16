package problem.백준;

import java.util.Scanner;

public class 크로아티아알파벳_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String croa = sc.next();
		
		String[] alpha = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
		
		int ans = croa.length();
		
		for(int i = 0 ;i<croa.length()-1; i++) {
			String tmp2 = croa.substring(i, i+2);
			String tmp3 = "";
			
			if(i < croa.length()-2)
				tmp3 = croa.substring(i, i+3);
			
			if(tmp3.equals("dz=")) {
				ans -= 2;
				i++;
				continue;
			}
			
			for(int j = 0; j<alpha.length; j++) {
				if(tmp2.equals(alpha[j])) ans--;
			}
			
			tmp3 = "";
		}
		System.out.println(ans);
	}
}
