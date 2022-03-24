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
		int cut = high - M;//톱의 높이
		int cnt = M;//자르는길 저장
		//절반씩 잘라가며 값을 찾기
		while(true) {
			sum = 0;
			for(int i =0; i<N; i++) {
				if(wood[i] - cut > 0){
				sum += wood[i] - cut;
				}
			}
			
			if(sum == M) break;
			//나무 자른 합이 크다면 자른 높이cut에 더해주고 작다면 뺴주고
			else if(sum < M) {
				cnt = cnt/2;
				cut -= cnt;
			}else if(sum > M) {
				cnt = cnt/2;
				cut += cnt;
			}
			
			//중간값 +1 해서 값을 넣어주고  while문의 설정은 high>min일때만 돌도록
			
		}
		System.out.println(cut);
	}//main
}
