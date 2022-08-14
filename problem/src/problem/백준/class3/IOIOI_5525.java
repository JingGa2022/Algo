package problem.백준.class3;

import java.util.Scanner;

public class IOIOI_5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String OI = sc.next();
		boolean[] OIOI = new boolean[m];
		int[] memo = new int[m];
		int ans = 0;
		
		/*돌면서 n개 어치가 되면 2개씩마다 체크를 초기화시키면서 
			하나씩 카운트를 증가시키는 느낌으로?
		 */
		for(int i=0; i<m; i++) {
			char tmp = OI.charAt(i);
			
			if(tmp == 'O') OIOI[i] = true;
		}
		
		for(int i = 1; i<m-1; i++) {
			if(OIOI[i] && !OIOI[i+1]) {
				memo[i + 1] = memo[i-1] + 1;
				if(memo[i+1] >= n && !OIOI[i- 2*n +1]) ans++;
			}
		}
		
		System.out.println(ans);
		
//		boolean check = false;
//		int pattern = 0; //패턴 카운트
//		int cnt = 0; //한번 패턴 완성시 그 이후 2개 추가마다 1개 더
//		for(int i=0; i<m; i++) {	
//			
//			//시작
//			if(pattern == 0 && !OIOI[i]) pattern++;
//			//
//			if(OIOI[i] == !check && pattern>0) {
//				pattern++;
//				
//				if(pattern == (2*n +1)) {
//					ans++;
//				}
//				else if(pattern > (2*n +1)) {
//					cnt++;
//					if(cnt==2) {
//						cnt = 0;
//						ans++;
//					}
//				}
//			}else {
//				pattern = 0;
//				if(pattern == 0 && !OIOI[i]) pattern++;
//			}
//			check = OIOI[i];
//		}
	}
}
