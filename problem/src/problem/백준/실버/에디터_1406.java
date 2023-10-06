package problem.백준.실버;

import java.io.*;
import java.util.*;

public class 에디터_1406 {
	/*
	 * 1. 커서 위치, 문자열, 커서위치 끝인지 확인 함수
	 * 2. 시간복잡도에 대한 고려 필요
	 */
	static int n, m, idx;
	static String edit;
	static StringBuilder sb = new StringBuilder();
	static LinkedList<Character> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		edit = br.readLine();
		n = edit.length();
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			list.add(edit.charAt(i));
		}
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) iter.next();

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			char tmp = s.charAt(0);
			switch (tmp) {
			case 'P':
				iter.add(s.charAt(2));
				break;
			case 'L':
				if (iter.hasPrevious())
					iter.previous();
				break;
			case 'D':
				if (iter.hasNext())
					iter.next();
				break;
			case 'B':
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			}

		}

		for (char c : list)
			sb.append(c);

		System.out.println(sb);
	}
}
