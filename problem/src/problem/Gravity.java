package problem;

import java.util.Scanner;

public class Gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력받기
		int row = sc.nextInt();
		int[] arr = new int[row];
		int max = 0;
		
		//row개 만큼 입력받기
		for(int i = 0; i < row; i ++) arr[i] = sc.nextInt();
		
		//row개 비교
		for(int i = 0; i < arr.length; i++) {
			//최대 낙차
			int cnt = arr.length - 1 - i;
			for(int j = 1 + i; j < row; j++) {
				if(arr[i] <= arr[j]) cnt--;
			}
			if(max < cnt) max = cnt;
		}
		System.out.println(max);
	}
}
