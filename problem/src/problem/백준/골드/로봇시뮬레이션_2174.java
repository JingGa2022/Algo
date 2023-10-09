package problem.백준.골드;

import java.util.*;

public class 로봇시뮬레이션_2174 {
	/*
	 * 1. 로봇 객체 만들고 2. 맞춰서 돌리믄 됨
	 */
	static class Robot {
		int x, y;
		int dir;

		Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static class Cmd {
		int num, cycle;
		char command;

		Cmd(int num, char command, int cycle) {
			this.num = num;
			this.command = command;
			this.cycle = cycle;
		}
	}

	static int a, b, n, m;
	static List<Robot> robot = new ArrayList<>();
	static List<Cmd> command = new ArrayList<>();
	static int[][] map;
	static HashMap<Character, Integer> nesw = new HashMap<Character, Integer>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();

		nesw.put('N', 0);
		nesw.put('E', 1);
		nesw.put('S', 2);
		nesw.put('W', 3);

		map = new int[b][a];
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++)
				map[i][j] = -1;
		}
		for (int i = 0; i < n; i++) {
			robot.add(new Robot(sc.nextInt(), sc.nextInt(), nesw.get(sc.next().charAt(0))));
			map[robot.get(i).x][robot.get(i).y] = i;
		}
		for (int i = 0; i < m; i++) {
			command(sc.nextInt() - 1, sc.next().charAt(0), sc.nextInt());
		}

	}

	static void command(int num, char cmd, int cycle) {
		Robot tmp = robot.get(num);
		if(robot.get(num).dir == -1) return;
		
		switch (cmd) {
		case 'L':
			robot.add(num, new Robot(tmp.x, tmp.y, (tmp.dir + 3) % 4));
			break;
		case 'R':
			robot.add(num, new Robot(tmp.x, tmp.y, (tmp.dir + 1) % 4));
			break;
		case 'F':
			int d = tmp.dir;
			for (int i = 0; i < cycle; i++) {
				int nx = tmp.x + dr[d];
				int ny = tmp.y + dr[d];
				if (nx < 0 || ny < 0 || nx >= b || ny >= a) {
					System.out.println("Robot " + num + " crashes into the wall");
					robot.add(num, new Robot(0, 0, -1));
					break;
				}

				if (map[nx][ny] != -1) {
					System.out.println("Robot " + num + " crashes into robot " + map[nx][ny]);
					map[nx][ny] = -1;
				} else {
					map[nx][ny] = num;
					robot.add(num, new Robot(nx, ny, tmp.dir));
				}
				map[tmp.x][tmp.y] = -1;

			}
			break;
		}
	}
}
