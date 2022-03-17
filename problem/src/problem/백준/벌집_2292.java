package problem.백준;

import java.util.Scanner;

public class 벌집_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean flag = true;
		int room = 1;//벌집의 개수
		int ans = 1;//방의 수
		while(flag) {
			if(N==1) break;
			if(N <= room + 6*ans && N > room) {
			ans++;
			flag = false;
			}else {
				room += 6*ans;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
