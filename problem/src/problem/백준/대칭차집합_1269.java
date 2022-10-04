package problem.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 대칭차집합_1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		int ans = 0;
		
		Map<Integer, Boolean> A = new HashMap<>();
		Map<Integer, Boolean> B = new HashMap<>();
		
		for(int i = 0; i<a; i++) A.put(sc.nextInt(), true);

		for(int i = 0; i<b; i++) B.put(sc.nextInt(), true);
		
		for(int tmp : A.keySet()) {
			if(B.containsKey(tmp)) sum ++;
		}
		ans += b - sum;
		
		sum = 0;
		for(int tmp : B.keySet()) {
			if(A.containsKey(tmp)) sum ++;
		}
		ans += a - sum;
		
		System.out.println(ans);
	}
}
