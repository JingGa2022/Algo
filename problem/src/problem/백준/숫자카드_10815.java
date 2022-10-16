package problem.백준;

import java.util.Scanner;

public class 숫자카드_10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int[] arrN = new int[20000001];
		int[] arrM = new int[500000];
		
		for(int i = 0; i<n; i++) {
			int tmp = sc.nextInt();
			if(tmp < 0) arrN[10000000-tmp]++;
			else arrN[tmp]++;
		}
		
		int m = sc.nextInt();
		
		for(int i = 0; i<m; i++) {
			int tmp = sc.nextInt();
			if(tmp < 0 && arrN[10000000-tmp] != 0) sb.append("1 ");
			else if(tmp >= 0 && arrN[tmp] != 0) sb.append("1 ");
			else sb.append("0 ");
		}
		
		System.out.println(sb);
	}
}
