package problem.백준;

import java.util.Scanner;

public class 개수세기_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr= new int[N];
		int ans = 0;
		
		for(int i = 0; i<N;i ++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		for(int i = 0; i<N; i++) {
			if(arr[i] == v) ans++;
		}
		System.out.println(ans);
	}
}
