package problem;

import java.util.Scanner;

public class 중앙값구하기_2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정수의 개수 n
		int n = sc.nextInt();
		//정수들의 배열
		int[] nBox = new int[n];
		//숫자 입력받기
		for(int i = 0; i < n; i++) nBox[i] = sc.nextInt();
		//최소값부터 오름차순 정렬
		for(int i = 0; i < n; i++) {
			//최소값의 인덱스
			int minV = i;
			//최소값 순서대로 구하는 반복문
			for(int j = i + 1; j < n; j++) {
				if(nBox[minV] > nBox[j]) minV = j;
			}
			int tmp = nBox[i];
			nBox[i] = nBox[minV];
			nBox[minV] = tmp;
		}
		sc.close();
		//중간값 출력
		System.out.println(nBox[n / 2]);
	}
}
