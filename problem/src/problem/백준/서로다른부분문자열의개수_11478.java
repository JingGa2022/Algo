package problem.백준;

import java.util.HashSet;
import java.util.Scanner;

public class 서로다른부분문자열의개수_11478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i+1; j <= s.length(); j++) {
				if(!set.contains(s.substring(i, j))) {
					set.add(s.substring(i,j));
				}
			}
		}
		System.out.println(set.size());
	}
}
