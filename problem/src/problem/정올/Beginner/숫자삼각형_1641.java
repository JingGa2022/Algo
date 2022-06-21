package problem.정올.Beginner;

import java.util.Scanner;

public class 숫자삼각형_1641 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int m = sc.nextInt();
		int idx = 0;
		if(n % 2 == 0 || n>100 || n<1) {
			System.out.println("INPUT ERROR!");
		}else {
			
		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				idx += i;
				if (i % 2 != 0) {
					for (int j = i-1; j >= 0; j--) {
						int tmp = idx-j;
						sb.append(tmp).append(" ");
					}
				} else if (i % 2 == 0) {
					for (int j = 0; j < i; j++) {
						int tmp = idx - j;
						sb.append(tmp).append(" ");
					}
				}
				sb.append("\n");
			}
			break;

		case 2:
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<i; j++) {
					sb.append("  ");
				}
				for(int j = i; j<n; j++) {
					sb.append(i).append(" ");
				}
				for(int j = i+1; j<n; j++) {
					sb.append(i).append(" ");
				}
				sb.append("\n");
			}
			break;

		case 3:
			for(int i = 1; i<=n; i++) {
				if(i <= n/2) {
					for(int j = 1; j<=i; j++) sb.append(j).append(" ");
				}else {
					for(int j = 1; j<=n-i+1; j++) sb.append(j).append(" ");
				}
				sb.append("\n");
			}
			break;
			
		default:
			sb.append("INPUT ERROR!");
			break;
		}
		
		System.out.println(sb);}
	}
}
