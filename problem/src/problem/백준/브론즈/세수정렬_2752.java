package problem.백준.브론즈;

import java.util.Arrays;
import java.util.Scanner;

public class 세수정렬_2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
		for(int i =0; i<3; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		for(int i =0; i<3; i++)
		System.out.printf("%d ",arr[i]);
	}
}
