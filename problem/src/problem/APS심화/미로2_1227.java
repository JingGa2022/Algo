package problem.APS심화;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로2_1227 {
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int ans = 0;
	static Queue<Integer> queI;
	static Queue<Integer> queJ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			map = new int[100][100];// 맵
			queI = new LinkedList<>();// bfs를 위한 큐 만들기
			queJ = new LinkedList<>();// bfs를 위한 큐 만들기
			String[] tmp;// 문자 잠시 넣어줄 친구
			// 입력받기
			sc.nextLine();
			for (int i = 0; i < 100; i++) {
				tmp = sc.nextLine().split("");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			ans = 0;
			maize(1, 1);
			System.out.println("#" + tc + " " + ans);

		}
	}// main

	private static void maize(int startI, int startJ) {
		map[startI][startJ] = 1;// 방문기록
		queI.add(startI);
		queJ.add(startJ);

		while (!(queI.size() == 0)) {
			int i = queI.poll();
			int j = queJ.poll();
			map[i][j] = 1;// 방문기록
			for (int a = 0; a < 4; a++) {
				if (map[i + dr[a]][j + dc[a]] != 1) {
					queI.add(i + dr[a]);
					queJ.add(j + dc[a]);
					if (map[i + dr[a]][j + dc[a]] == 3)
						ans = 1;// 도착 가능
				}
			}
		}
	}
}
