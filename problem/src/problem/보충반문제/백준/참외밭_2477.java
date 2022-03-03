package problem.보충반문제.백준;

import java.util.Scanner;

public class 참외밭_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fruits = sc.nextInt();//참외의 수
		int[][] farm = new int[6][2];
		for(int i = 0; i<6; i++) {
			for(int j =0; j<2; j++) farm[i][j] = sc.nextInt();
		}//전체 반복문 종료
		int areaB = farm[0][1] * farm[1][1];// 첫번쨰 두번쨰가 큰 사각형의 넓이
		int areaS = farm[3][1] * farm[4][1];// 네번쨰 다섯번쨰가 작은 사각형의 넓이
		int area = areaB - areaS; //농장의 넓이
		System.out.println(area*fruits);
	}//main
}
