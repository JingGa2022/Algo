package problem.백준.class3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 좌표압축_18870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int[] compare = new int[n];
		HashMap<Integer, Integer> ranking = new HashMap<>();
		
		for(int i = 0 ; i<n; i++) {
			arr[i] = compare[i] = sc.nextInt();
		}
		
		Arrays.sort(compare);
		
		int rank = 0;
		
		for(int v: compare) {
			if(!ranking.containsKey(v)) {
				ranking.put(v, rank);
				rank++;
			}
		}
		
		for(int v: arr) {
			sb.append(ranking.get(v)+" ");
		}
		System.out.println(sb);
	}
}
