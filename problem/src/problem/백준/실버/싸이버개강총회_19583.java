package problem.백준.실버;

import java.util.*;
import java.io.*;

public class 싸이버개강총회_19583 {
	/* 1. HashSet을 사용해 정리하고
	 * 2. compareTo로 String간 비교
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		String s = st.nextToken();
		String e = st.nextToken();
		String f = st.nextToken();
		
		String value = null;
		
		HashSet<String> before = new HashSet<>();
		HashSet<String> after = new HashSet<>();
		HashSet<String> user = new HashSet<>();
		
		while((value = br.readLine()) != null) {
			st = new StringTokenizer(value, " ");
			String timeValue = st.nextToken();
			String userName = st.nextToken();
			
			user.add(userName);
			if(s.compareTo(timeValue) >= 0) before.add(userName);
			else if(e.compareTo(timeValue) <= 0 && f.compareTo(timeValue) >= 0) after.add(userName);
		}
		
		for(String u : user) {
			if(before.contains(u) && after.contains(u)) ans++;
		}
		
		System.out.println(ans);
	}
}
