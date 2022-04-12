import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2806_NQueen {
	static int N; // 1<= N <= 10;
	static int[][] map;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			dropTheQueen(0);

			System.out.println("#" + tc + " " + ans);
		} // tc

	}

	static void dropTheQueen(int r) {
		if (r == N) {
			// 끝까지 전부 놓았어~~

//			// 이번에 놓은 퀸들이 잘 놓아졌는지 확인이 필요해
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//
//			System.out.println("------------------");
			ans++;
			return;
		}

		// 해당 행에서 Queen 놓아봐야됨.
		for (int c = 0; c < N; c++) {
			if (check2(r, c)) {
				map[r][c] = 1; // 퀸을 놓았다.
				dropTheQueen(r + 1);
				map[r][c] = 0; // 다음을 위해 퀸을 다시 회수.
			}
		}

	}
	
	static int[] dc = {-1,0,1};
	private static boolean check(int r, int c) {
		//11시 12시 13시
		for(int i = 0 ; i<3; i++) {
			int nr = r;
			int nc = c;
			
			while(true) {
				nr -= 1;
				nc += dc[i];
				
				if(nr < 0 || nc < 0 || nc>=N) break;
				if(map[nr][nc] == 1) return false;
			}
		}
		return true;
	}
	
	private static boolean check2(int r, int c) {
		int left = c;
		int right = c;
		
		for(int i = r-1; i>=0; i--) {
			left--;
			right++;
			
			if(map[i][c] == 1) return false;//위쪽확인 
			if(left >= 0 && map[i][left] == 1) return false; //왼쪽대각확인
			if(right < N && map[i][right] == 1) return false;
		}
		return true;
	}

}
