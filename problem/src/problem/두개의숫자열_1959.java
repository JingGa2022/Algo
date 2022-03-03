package problem;

import java.util.Scanner;

public class 두개의숫자열_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 수
		int t = sc.nextInt();
		//테스트 실행
		for(int tc = 1; tc <= t; tc++) {
			//변수정의
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] A = new int[n];
		int[] B = new int[m];
		for(int i = 0; i < n; i++) A[i] = sc.nextInt();
		for(int i = 0; i < m; i++) B[i] = sc.nextInt();
		int maxV = 0;
		//n>m일때
		if(n > m) {
			for(int i = 0; i<=n-m; i++) {
				int sum = 0;
				for(int j = 0; j<m; j++) {
					sum += A[j + i] * B[j];
				}
				if(sum > maxV) maxV = sum;
			}
		}else {
			for(int i = 0; i<=m-n; i++) {
				int sum = 0;
				for(int j = 0; j<n; j++) {
					sum += A[j] * B[j + i];
				}
				if(sum > maxV) maxV = sum;
			}
		}
		System.out.printf("#%d %d\n", tc, maxV);
		}
	}
}
