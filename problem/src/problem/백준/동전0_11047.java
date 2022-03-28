package problem.백준;

import java.util.Scanner;

public class 동전0_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int idx = 0; //가장 가까운 동전의 인덱스 저장
		int ans = 0; //동전의 개수 저장
		for(int i=0; i<N; i++) { //10000원 
			coin[i] = sc.nextInt();
			if(coin[i]<=K) idx = i;
		}
		int quot = 0;
		for(int i=idx; i>=0; i--) {
			quot = K/coin[i];
			K -= quot*coin[i];
			ans += quot;
		}
		System.out.println(ans);
	}
}
