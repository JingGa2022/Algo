package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class String_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		//10번의 테스트
		while(tc<=10) {
			tc++;
			int t = sc.nextInt();
			//패턴 입력
			char[] p = sc.next().toCharArray();
			char[] test = sc.next().toCharArray();
			int N = p.length; //패턴의 길이
			int M = test.length; // test의 길이
			int idx = 0; //겹치는 횟수
			//Brute Force이용
			for(int i = 0; i<=M-N; i++) {
				boolean flag = true;
				//움직인패턴과 test의 비교
				for(int j = 0; j<N; j++) {
					if(p[j] != test[i+j]) {
						flag = false;
						break;
					}
				}
				if(flag) ++idx;
			}
			//출력
			System.out.printf("#%d %d\n",t,idx);
		}
	}
}
