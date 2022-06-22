package problem.백준.class3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 듣보잡_1764 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int num = 0;
		List ans = new ArrayList<>();
		
		HashSet<String> map1 = new HashSet<>();
		
		for(int i = 0; i<n ;i++) map1.add(sc.next());
		for(int i = 0; i<m ;i++) {
			String s = sc.next();
			if(map1.contains(s)) {
				num++;
				ans.add(s);
			}
		}
		Collections.sort(ans);
		
		System.out.println(num);
		for(int i = 0; i<ans.size(); i++) System.out.println(ans.get(i));
	}
}
