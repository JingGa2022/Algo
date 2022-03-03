package problem;

import java.util.Scanner;

public class 달팽이숫자_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		//t번 반복
		for(int tc = 1; tc <= t; tc++) {
			//박스 크기
			int N = sc.nextInt();
			//박스만들기
			int[][] box = new int[N][N];
			//행 인덱스 열 인덱스
			int row = 0;
			int col = 0;
			int cnt = 0;
			while(cnt < N*N) {
				while(col < N && box[row][col] == 0) {
					box[row][col] = ++cnt;
					col++;
				}
				col--;
				row++;
				while(row < N && box[row][col] == 0) {
					box[row][col] = ++cnt;
					row++;
				}
				col--;
				row--;
				while(col >=0 && box[row][col] == 0) {
					box[row][col] = ++cnt;
					col--;
				}
				col++;
				row--;
				while(row >= 0 && box[row][col] == 0) {
					box[row][col] = ++cnt;
					row--;
				}
				col++;
				row++;
			}
			
			System.out.printf("#%d\n",tc);
			for(int i =0; i<N; i++) {
				for(int j =0; j<N; j++) {
					System.out.print(box[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
//	if(idr == 4)
//		dir0;
//	dir=(dir+1)%4;
	//델타를 이용한 방식
	
	//2. 규칙을 찾기
	//수직이동과 수평이동에서의 규칙을 찾을 수 있다.
	//행고정 열증    열고  행증    행고   영감   행감 열고    행고 열증
}
