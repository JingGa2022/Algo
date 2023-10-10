package problem.백준.골드;

import java.util.*;

public class 로봇시뮬레이션2_2175 {
	/*
	 * 1. 로봇 객체 만들고 2. 맞춰서 돌리믄 됨
	 */
	static class Robot {
		int x, y;
		char dir;

		Robot(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static int a, b, n, m;
	static int[][] map;
	static HashMap<Integer, Robot> hash = new HashMap<Integer, Robot>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[b + 1][a + 1];

		for (int i = 1; i <= n; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			char dir = sc.next().charAt(0);

			hash.put(i, new Robot(x, y, dir));

			map[x][y] = i;
		}

		for (int i = 0; i < m; i++) {
			int robotNum = sc.nextInt();
			char order = sc.next().charAt(0);

			int repNum = sc.nextInt();

			Robot rob = hash.get(robotNum);

			if (order == 'F') {
				int nX = rob.x;
				int nY = rob.y;
				for (int r = 0; r < repNum; r++) {
					int[] arr = setNewPosition(rob.dir, nX, nY);
					nX = arr[0];
					nY = arr[1];

					if (nX <= 0 || nY <= 0 || nX > b || nY > a) {
						System.out.println("Robot " + robotNum + " crashes into the wall");
						return;
					}
					
					if (map[nX][nY] != 0) {
						System.out.println("Robot "+ robotNum +" crashes into robot "+ map[nX][nY]);
						return;
					}
				}
				map[rob.x][rob.y] = 0;
				hash.remove(robotNum);
				hash.put(robotNum, new Robot(nX, nY, rob.dir));
				map[nX][nY] = robotNum;
			}
			else if(order == 'L' || order == 'R') {
				char newDir = rob.dir;
				for(int r = 0; r<repNum; r++) {
					newDir = setTurnOrder(robotNum, newDir, order);
				}
				hash.remove(robotNum);
				hash.put(robotNum, new Robot(rob.x, rob.y, newDir));
			}
		}
		
		System.out.println("OK");
	}

	static int[] setNewPosition(char robotHead, int robX, int robY) {
		int newX = robX;
		int newY = robY;
		int[] arr = new int[2];
		switch (robotHead) {
		case 'E':
			newY += 1;
			break;
		case 'N':
			newX += 1;
			break;
		case 'W':
			newY -= 1;
			break;
		case 'S':
			newX -= 1;
			break;
		default:
			break;
		}
		arr[0] = newX;
		arr[1] = newY;

		return arr;
	}

	static char setTurnOrder(int robotNum, char robotHead, char order) {
		char newDir;
		switch (order) {
		case 'L':
			newDir = changeDir(robotHead, 'L');
			return newDir;
		case 'R':
			newDir = changeDir(robotHead, 'L');
			return newDir;
		default:
			break;
		}
		return 'a';
	}

	static char changeDir(char robotHead, char dir) {
		switch (robotHead) {
		case 'E':
			if (dir == 'L') {
				return 'N';
			} else if (dir == 'R') {
				return 'S';
			}
		case 'S':
			if (dir == 'L') {
				return 'E';
			} else if (dir == 'R') {
				return 'W';
			}
		case 'W':
			if (dir == 'L') {
				return 'S';
			} else if (dir == 'R') {
				return 'N';
			}
		case 'N':
			if (dir == 'L') {
				return 'W';
			} else if (dir == 'R') {
				return 'E';
			}
		default:
			break;
		}
		return 'a';
	}
}
