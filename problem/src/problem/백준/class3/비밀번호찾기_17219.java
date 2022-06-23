package problem.백준.class3;

import java.util.HashMap;
import java.util.Scanner;

public class 비밀번호찾기_17219 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0; i<n; i++) map.put(sc.next(), sc.next());
		
		for(int i = 0; i<m; i++) sb.append(map.get(sc.next())).append("\n");
		
		System.out.println(sb);
	}
}
