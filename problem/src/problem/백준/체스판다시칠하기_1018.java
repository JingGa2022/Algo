package problem.백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 체스판다시칠하기_1018 {
	static String[][] box;
	static String[][] check;// 방문체크용
	static int ans = 0;
	static int N; // 행
	static int M; // 열
	static int[] dr = { -1, 0, 1, 0 };// 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		box = new String[N + 2][M + 2];
		check = new String[N + 2][M + 2];
		
		sc.nextLine();
		String[] tmp;
		
		for (int i = 1; i <= N; i++) {
			tmp = sc.nextLine().split("");
			for (int j = 1; j <= M; j++) {
				box[i][j] = tmp[j - 1];// 0열과 M+1열에 null을 냅두기 위해 이렇게 함
				check[i][j] = tmp[j - 1];
			}
		}
		int min = Integer.MAX_VALUE;
		//시작점을 1,1부터 N-8,M-8까지 돌기
		for(int i =1; i<=N-8; i++) {
			for(int j =1; j<=M-8; j++) {
				ans=0;
				change(i, j);//8*8씩 잘라서 확인해 보기
				recovery();//배열원복
//				System.out.println(ans);
				if(ans<min) min = ans;
			}
		}
		System.out.println(min);
	}// main

	public static void change(int I, int J) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				for (int a = 0; a < 4; a++) {
					// 자식들을 큐에 집어넣기
					if (box[I+i + dr[a]][J+j + dc[a]] != null && I+i <= N-1 && J+j<= M-1) {
						// 겹칠때 바꿔주기
//						System.out.println(Arrays.deepToString(box));
						if (box[I+i][J+j].equals("W") && box[I+i + dr[a]][J+j + dc[a]].equals(box[I+i][J+j])) {
							box[I+i + dr[a]][J+j + dc[a]] = "B";
							ans++;
						} else if (box[I+i][J+j].equals("B") && box[I+i + dr[a]][J+j + dc[a]].equals(box[I+i][J+j])) {
							box[I+i + dr[a]][J+j + dc[a]] = "W";
							ans++;
						}
					}
				}//사방탐색
			}
		}
	}// 메써드
	public static void recovery() {
		//원복해주는 메서드
		for(int i =1; i<N; i++) {
			for(int j=1; j<M; j++) {
				box[i][j] = check[i][j];
			}
		}
	}
}
