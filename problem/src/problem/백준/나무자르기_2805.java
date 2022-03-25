package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] wood = new int[N];
		int high = 0;//가장 높은 나무
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			wood[i] = Integer.parseInt(st.nextToken());
			if(wood[i] > high) high = wood[i];
		}
		int sum =0;//통나무의 합을 구하기
		int cut = 0;//톱의 높이
		//절반씩 잘라가며 값을 찾기
		while(high > cut) {
			sum = 0;
			for(int i =0; i<N; i++) {
				if(wood[i] - cut > 0){
				sum += wood[i] - cut;
				}
			}
			//나무 자른 합이 크다면 자른 높이cut에 더해주고 작다면 뺴주고
			if(sum > M) {
				cut += (high - cut)/2;
			}else if(sum < M) {
				high -= (high - cut)/2;
			}
			if(sum==M) cut += 1;
		}
		System.out.println(cut);
	}//main
}
