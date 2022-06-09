package problem.백준.브론즈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 과제안내신분_5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[31];
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i<29; i++) {
			arr[sc.nextInt()] = 1;
		}
		
		for(int i = 1; i< 31; i++) {
			if(arr[i] == 0) list.add(i);
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}
