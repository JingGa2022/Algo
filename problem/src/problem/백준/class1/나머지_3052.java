package problem.백준.class1;

import java.util.Scanner;

public class 나머지_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[42];
		int ans = 0;
		
		for(int i = 0; i<10; i++) {
			int tmp = sc.nextInt();
			arr[tmp%42] ++;
		}
		
		for(int a : arr) {
			if(a!=0) ans++;
		}
		
		System.out.println(ans);
	}
}
