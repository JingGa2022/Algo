package problem.백준.class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 단어정렬_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] arr = new String[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.next();

		//중복제거
		Set<String> tmp = Arrays.stream(arr).collect(Collectors.toSet());
		//
		arr = new String[tmp.size()];
		tmp.toArray(arr);
		
		//분류
		Arrays.sort(arr, new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				else
					return o1.length() - o2.length();
			}

		});
		
		
		for (String s : arr)
			System.out.println(s);
	}
}
