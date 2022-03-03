package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 원재의메모리복구_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			String str = sc.next();
			//원래의 메모리
			int[]memory = new int[str.length()];
			//0000으로 채워진 메모리에서 안들어갈 메모리
			int[] tmp = new int[str.length()];
			
			//memory 일단 str로 덮어씌우기
			for(int i =0; i<str.length(); i++) {
				if(str.charAt(i) == '1')
					memory[i] = 1;
			}
			for(int i =0; i<memory.length; i++) {
				if(memory[i] != tmp[i]) {
					for(int j = 1; j<tmp.length; j++)
						tmp[j] = memory[i];
					ans++;
				}
				System.out.println(Arrays.toString(tmp));
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
