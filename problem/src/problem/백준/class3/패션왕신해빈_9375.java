package problem.백준.class3;

import java.util.HashMap;
import java.util.Scanner;

public class 패션왕신해빈_9375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			int n = sc.nextInt();
			int ans = 1;
			HashMap<String, Integer> wear = new HashMap<>();
			
			for(int i = 0; i<n; i++) {
				sc.next();
				
				String s = sc.next();
				
				if(wear.containsKey(s))
					wear.put(s, wear.get(s)+1);
				else
					wear.put(s, 1);
			}
			for(int val : wear.values())
				ans *= (val + 1);
			
			System.out.println(ans-1);
		}
		
	}
}
