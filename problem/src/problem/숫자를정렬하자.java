package problem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 숫자를정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		입력받는값
		int t = sc.nextInt();
		
//		t번의 테스트 케이스
		for(int k = 0; k < t; k++) {
			int n = sc.nextInt();
			int[][] arr = new int[t][n];
		
//		n개 만큼씩 입력받기
		for(int i = 0; i < n; i++) arr[k][i] = sc.nextInt();
		
		//오름차순으로 정렬하기 버블정렬이용
		for(int i = n-1; i > 0 ; i--) {
			for(int j = 1; j < n; j++)
				if(arr[k][j-1] > arr[k][j]) {
					int temp = arr[k][j];
					arr[k][j] = arr[k][j-1];
					arr[k][j-1] = temp;
				}
		}
		System.out.print("#" + (k + 1) + " ");
		for(int i = 0; i < n; i++)
			System.out.print(arr[k][i] + " ");
		System.out.println();
		}
	}
}
