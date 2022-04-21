package problem.백준.class2;

import java.util.Scanner;

public class 분해합_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int ans = Integer.parseInt(N)/2;
		
		while(true) {
		String tmp = Integer.toString(ans);
		
		int sum = Integer.parseInt(tmp);
		
		for(int i = 0; i<N.length(); i++) sum += (tmp.charAt(i) - '0');
		if(sum == Integer.parseInt(N)) break;
		
		ans++;
		}
		System.out.println(ans);
	}
}
