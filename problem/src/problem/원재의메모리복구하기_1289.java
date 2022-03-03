package problem;

import java.util.Arrays;
import java.util.Scanner;

public class 원재의메모리복구하기_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++) {
			int ans = 0;
			String str = sc.next();
			int[] mem = new int[str.length()];
			int[] tmp = new int[str.length()];
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '1')
					mem[i] = 1;
			}
			for(int i=0; i<mem.length; i++) {
				if(mem[i] != tmp[i]) {
					for(int j = i; j<tmp.length; j++)
						tmp[j] = 1 - tmp[j];
					ans++;
				}
				System.out.println(Arrays.toString(tmp));
			}
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
