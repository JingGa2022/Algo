package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 암호문1_1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();//원본 암호문의 길이
			List<Integer> code = new ArrayList<>();//원본 암호문
			for(int i = 0; i<N; i++) code.add(sc.nextInt());
			int M = sc.nextInt(); //명령어의 개수
			for(int i =0; i<M; i++) {
				String start = sc.next(); // 명령문의 시작
				int x = sc.nextInt();//x의 위치
				int y = sc.nextInt();//y개의 숫자
				for(int j = 0; j<y; j++) code.add(x+j, sc.nextInt());
			}
			System.out.printf("#%d ",tc);
			for(int i = 0; i<10; i++) {
				System.out.print(code.get(i)+" ");
			}
			System.out.println();
		}
	}
}
