package problem.백준;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬하기_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] spot = new int[N][2];//
	
		for(int i =0; i<N; i++) {
			spot[i][0] = sc.nextInt();
			spot[i][1] = sc.nextInt();
		}
		
		Arrays.sort(spot, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			}
			else {
				return e1[0] - e2[0];
			}
		});
		
		//그리고 0번재 것이 같다면 1번쨰를 카운팅 정렬하게 하면 됨
		for(int i = 0; i<N; i++) {
			System.out.println(spot[i][0] + " "+spot[i][1]);
			
		}
	}//main
}
