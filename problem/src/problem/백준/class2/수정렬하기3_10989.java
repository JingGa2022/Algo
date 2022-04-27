package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 입력된 수의 배열
		int[] idx = new int[10001]; //N에 가능한 수의 범위
		int[] result = new int[N+1];
		
		for(int tc = 0; tc<N; tc++) {
			num[tc] = Integer.parseInt(br.readLine());
			idx[num[tc]] ++;
		}
		
		//카운트 한것 정리
		for(int i = 1; i<N; i++) {
			idx[i] += idx[i-1];
		}
		
		for(int tc = N-1; tc>=0; tc--) {
			result[idx[num[tc]]] = num[tc];
			idx[num[tc]] --;
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}//main
	
}
