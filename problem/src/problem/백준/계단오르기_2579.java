package problem.백준;

import java.util.Scanner;

public class 계단오르기_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] stair = new int[T+1]; //층을 편하게 쓰기위해
		int sum =0;//합
		int cnt = 1; //연속성
		for(int i = 1; i<=T; i++) {
			stair[i] = sc.nextInt();
		}
		int i =1;
		sum += stair[i];
		//올라가기
		while(true) {
			//마지막 층은 무조건 이니까
			if(i == T -1) { 
				sum += stair[T];
				break;
			}
			if(i == T) {
				break;
			}
			//1칸 2칸 비교
			if(stair[i+1] > stair[i+2]) {
				i++;
				cnt++;
				if(cnt == 3) {
					cnt = 1;
				sum += stair[++i];
				}else
					sum += stair[i];
			}else {
				i += 2;
				//마지막층 가야되니까
				if(i>=T) {
				sum += stair[T];
				break;
			}
				sum += stair[i];
				cnt = 1;
			}

		}
		System.out.println(sum);
	}//main
}
