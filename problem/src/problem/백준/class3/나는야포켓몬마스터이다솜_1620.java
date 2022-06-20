package problem.백준.class3;

import java.util.HashMap;
import java.util.Scanner;

public class 나는야포켓몬마스터이다솜_1620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<Integer, String> hash1 = new HashMap<>();
		HashMap<String, Integer> hash2 = new HashMap<>();
		
		for(int i = 1; i<=n; i++) {
			String s = sc.next();
			hash1.put(i, s);
			hash2.put(s, i);
		}
		
		for(int i =0; i<m; i++) {
			String tmp = sc.next();
			if(49 <= tmp.charAt(0) && tmp.charAt(0) <= 57) {
				System.out.println(hash1.get(Integer.parseInt(tmp)));
			}
			else {
				System.out.println(hash2.get(tmp));
			}
		}
	}
}
