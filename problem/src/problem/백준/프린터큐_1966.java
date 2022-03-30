package problem.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++) {
			Queue<Integer> que = new LinkedList<>();//큐 생성
			int N = sc.nextInt();//문서의 개수
			int M = sc.nextInt();//궁금한 문서의 위치
			Integer[] list = new Integer[N];//순서 정렬할 것
			for(int i =0; i<N; i++) {
				list[i] = sc.nextInt();
				que.add(list[i]);
			}
			Arrays.sort(list, Collections.reverseOrder());
			int i = 0;//오름차순 순서에서 큰 것의 위치
			int ans;//정답
			while(true) {
				if(list[i]==que.peek()) {
					i++;
					break;
				}else {
					int tmp = que.poll();
					que.add(tmp);
					M--;
				}
			}
			System.out.println(i);
		}//for
	}// main
}
