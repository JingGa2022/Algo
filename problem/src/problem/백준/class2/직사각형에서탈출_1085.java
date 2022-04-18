package problem.백준.class2;

import java.util.Scanner;

public class 직사각형에서탈출_1085 {
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pos me = new Pos(sc.nextInt(), sc.nextInt());//나의 위치
		
		Pos edge = new Pos(sc.nextInt(),sc.nextInt());//경계의 위치
		
		int ans = 9999;
		if((edge.x - me.x)<ans ) ans = edge.x - me.x;
		if((edge.y - me.y)<ans ) ans = edge.y - me.y;
		if(me.x < ans) ans = me.x;
		if(me.y < ans) ans = me.y;
		System.out.println(ans);
		
	}
}
