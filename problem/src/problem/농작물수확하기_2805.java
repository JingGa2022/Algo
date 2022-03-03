package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 농작물수확하기_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			//숫자 입력
			int[][] num = new int[N][N];
			for(int i = 0; i<N; i++) {
				String tmp = sc.next(); 
				for(int j = 0; j<N; j++) {
					num[i][j] = tmp.charAt(j)-'0'; //-48을 뺼 수도 있다.
				}
			}
			// .split() => 문자열(String)형태 .tocharArray() => char배열
			//문자로받기
			
//			//숫자분할
//			int[][] box = new int[N][N];
//			int cnt = 1;
//			while(cnt != 0) {
//				int tmp = 0;
//				for(int i = 0; i<N; i++) {
//					for(int j = N-1; j>=0; j--) {
//				tmp = num[i]%10;
//				num[i]/=10;
//					box[i][j] = tmp;}
//				if(num[i] == 0) cnt --;		
//			}}
//			System.out.println(Arrays.deepToString(box));
			
			int sum = 0;
			//가운데줄
			for(int i = 0; i < N; i++) sum+=num[N/2][i];
			int k = 0;
			for(int i = N/2 -1; i >= 0; i--) {
				k++;
				for(int j = 1; j<N - k; j++) {
					sum += num[i][j];
				}
			}
			k = 0;
			for(int i = N/2 + 1; i < N; i++) {
				k++;
				for(int j = 1; j<N - k; j++) {
					sum += num[i][j];
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
