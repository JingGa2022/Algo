package problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Flatten_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//덤핑의 수가 입력수는 같지않다
		for(int tc = 1; tc <= 10; tc++) {
			//변수의 수
			int num = sc.nextInt();
			int[] box = new int[100];
			//숫자 입력받기
			for(int i = 0; i < 100; i++) box[i] = sc.nextInt();
			//덤핑하는 반복문
			for(int k = 0; k < num; k++) {
				//오름차순 숫자정렬
				sort(box);
				//덤핑실행
				if(box[99] - box[0] != 0) {
				box[0] += 1; box[99] -= 1;
				}else break;
			}
			//오름차순 숫자정렬
			sort(box);
			System.out.printf("#%d %d\n", tc, (box[99] - box[0]));
			
		}
	}
	
	public static void sort(int[] box) {
		//순서정리하는 반복문 버블정렬방식이용
		for(int i =0; i < 100; i++) {
			for(int j = i + 1; j < 100; j++) {
				if(box[i] > box[j]) {
					int tmp = box[i];
					box[i] = box[j];
					box[j] = tmp;
				}
			}
		}
	}
}
