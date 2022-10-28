package problem.백준.골드;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class 별찍기10_2448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<String> list = new ArrayList<>();
		
		list.add("***");
		list.add("* *");
		list.add("***");
		
		for(int i =1; (int)Math.pow(3, i) < n; i++) {
			makeStar(list);
		}
	}

	private static void makeStar(List<String> list) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		int size = list.size();
		
		for(int i = 0 ;i<size; i++) {
			sb.delete(0, sb.length());
			
			sb.append(list.get(i));
		}
	}
}
