package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//나무의 수
		int M = Integer.parseInt(st.nextToken());//원하는 나무길이
		long[] wood = new long[N]; // 나무가 들어갈 배열
		long high = 0;//가장 높은 나무
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			wood[i] = Integer.parseInt(st.nextToken());
			if(wood[i] > high) high = wood[i];
		}
		long cut = 0;//톱의 높이
		//중간값을 찾아가며 값을 찾기
		while(high > cut) {
			long mid = (high + cut)/2;
			long sum =0;//통나무의 합을 구하기
			for(long woodheight :wood) {
				if(woodheight - mid > 0){
				sum += (woodheight - mid);
				
				}
			}
			//나무 자른 합(SUM)이 구해야 할 값(M)보다 크다면 cut에 올려주고 작다면 high 내려주고
			if(sum < M) {
				high = mid;			
			}else {
				cut = mid +1 ;			
			}
			// 킹수호의 조언 : 중간값 +1 해서 값을 넣어주고  while문의 설정은 high>min일때만 돌도록	long을 쓰자!
		}
		System.out.println(cut-1);
	}//main
}
