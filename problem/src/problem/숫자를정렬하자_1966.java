package problem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 숫자를정렬하자_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		입력받는값
		int t = sc.nextInt();
//		t번의 테스트 케이스
		for (int tc = 0; tc < t; tc++) {
//		n개 만큼씩 입력받기
			int n = sc.nextInt();
			int[] arr = new int[n];
			//배열에 수 넣기
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			// 오름차순으로 정렬하기 버블정렬이용
			for (int i = n - 1; i > 0; i--) {
				for (int j = 1; j < i; j++) {
					if (arr[j - 1] > arr[j]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}
				}
			}
			System.out.print("#" + (tc + 1) + " ");
			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}

	}
}
