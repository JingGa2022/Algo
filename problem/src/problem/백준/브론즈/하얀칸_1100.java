package problem.백준.브론즈;

import java.util.Scanner;

public class 하얀칸_1100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] chess = new boolean[8][8];
		
		int ans = 0;
		
		for(int i = 0; i<8; i++) {
			String tmp = sc.next();
			for(int j = 0; j<8; j++) {
				if(tmp.charAt(j) == 'F')
					chess[i][j] = true;
			}
		}
		
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				int idx = i*2;
				if(chess[idx][j*2])
					ans++;
				if(chess[idx+1][j*2+1])
					ans++;
			}
		}
		System.out.println(ans);
	}//main
}
