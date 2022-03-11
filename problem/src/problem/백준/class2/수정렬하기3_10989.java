package problem.백준.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] num = new int[T];
		int[] idx = new int[10001];
		int[] rst = new int[T];
		for(int tc = 0; tc<T; tc++) {
			num[tc] = Integer.parseInt(br.readLine());
		}
		//인덱스 설정
		for(int i = 0; i<T; i++) {
			idx[num[i]] ++;
		}
		//인덱스 조정
		for(int i =0; i< 10000; i++) {
				idx[i+1] += idx[i];
		}
		//정렬
		for(int i = T-1; i>=0; i--) {
				rst[idx[num[i]]-1] = num[i];
				idx[num[i]] --;
		}
		
		for(int i = 0; i<T; i++) {
			System.out.println(rst[i]);
		}
	}
}
