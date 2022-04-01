package problem.백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 체스판다시칠하기_1018 {
	static String[][] box;
	static int[][] check;//방문체크용
	static int ans = 0;
	static int N; // 행
	static int M; // 열
	static int[] dr = {-1, 0, 1, 0};//상우하좌
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		box = new String[N+2][M+2];
		check = new int[N+2][M+2];
		sc.nextLine();
		String[] tmp;
		for(int i = 1; i<=N; i++) {
			tmp = sc.nextLine().split("");
				for(int j = 1; j<=M; j++) {
					check[i][j] = 1;
					box[i][j] = tmp[j-1];//0열과 M+1열에 null을 냅두기 위해 이렇게 함
				}
		}
		System.out.println(Arrays.deepToString(box));
		change(1, 1);
		System.out.println(ans);
	}
	public static void change(int nodeI, int nodeJ) {
		Queue<Integer> queI = new LinkedList<>();
		Queue<Integer> queJ = new LinkedList<>();
		
		queI.add(nodeI);
		queJ.add(nodeJ);
		while(!(queI.size() == 0)) {
			int I = queI.poll();
			int J = queJ.poll();
			check[I][J] = 0;//0면 방문한것
			for(int a = 0; a<4; a++) {
				//자식들을 큐에 집어넣기
				if(box[I+dr[a]][J+dc[a]] != null && check[I+dr[a]][J+dc[a]] != 0) {
				queI.add(I + dr[a]);
				queJ.add(J + dc[a]);
				//겹칠때 바꿔주기
				if(box[I+dr[a]][J+dc[a]].equals(box[I][J]) && box[I][J] == "W") {
					box[I+dr[a]][J+dc[a]]="B";
					System.out.println("B로 변경");
					ans++;
				}
				else if(box[I+dr[a]][J+dc[a]].equals(box[I][J]) && box[I][J] == "B") {
					box[I+dr[a]][J+dc[a]]="W";
					ans++;
					System.out.println("W로 변경");
				}
				}
			}
		}
	}//main
}
