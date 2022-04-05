package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백설공주와난장이_2912_2 {
	static int[] hat;
	static int[][] photo;
	static int dwarf;// 드워프의 수
	static int[] color;// 모자 색
	static int C;// 모자의 수
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] num = tmp.split(" ");
		
		int N = Integer.parseInt(num[0]) ;// 난장이의 수
		C = Integer.parseInt(num[1]) ;// 모자의 수
		
		
		tmp = br.readLine();
		num = tmp.split(" ");		
		hat = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			hat[i] = Integer.parseInt(num[i-1]);
		}
		tmp = br.readLine();
		int M =  Integer.parseInt(tmp);// 사진의 수
		
		photo = new int[M + 1][2];
		for (int i = 1, j; i <= M; i++) {
			j = 0;
			tmp = br.readLine();
			num = tmp.split(" ");
			photo[i][j] = Integer.parseInt(num[0]);
			photo[i][++j] = Integer.parseInt(num[1]);
		}
		
		//출력
		for (int i = 1; i <= M; i++) {
			isGoodPic(i);
			System.out.println(sb);
		}
	}// main

	static void isGoodPic(int a) {
		sb = new StringBuilder();
		// 드워프의 총 수를 구하기
			dwarf = 0;
			dwarf = photo[a][1] - photo[a][0] + 1;
			
		color = new int[C + 1];
		// 모자색이 겹치는 횟수를 저장
		for (int i = photo[a][0]; i <= photo[a][1]; i++) {
			color[hat[i]]++;
		}
		
		int coolHat = 0; // dwarf/2 초과의의 멋진모자가 뭘까
		for (int i = 1; i <= C; i++) {
			if (color[i] > dwarf / 2)
				coolHat = i;
		}
		
		if (coolHat > 0) {
			sb.append("yes " + Integer.toString(coolHat));
			return;
		}
		sb.append("no");
	}

}// class

