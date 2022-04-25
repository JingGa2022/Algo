package problem.백준.class2;

import java.util.Scanner;

public class 소수찾기_1978 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int cnt = 0;
			int tmp = num;
			//소수판별
			for(int j = tmp; j > 0; j--) {
				if(tmp%j == 0)
					cnt++;
			}
			//소수는 자기자신과 1만으로 나눠지기 때문에 2가지의 원소만 갖는다
			if(cnt==2) ans++;
		}
		System.out.println(ans);
	}
}
