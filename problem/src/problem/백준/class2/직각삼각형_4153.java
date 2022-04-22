package problem.백준.class2;

import java.util.Scanner;

public class 직각삼각형_4153 {
	static class Tri{
		int x;
		int y;
		int z;
		
		public Tri(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			while(true) {
			Tri tri = new Tri(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			if(tri.x == 0 && tri.y==0 && tri.z==0) break;
			
			if(tri.x*tri.x == (tri.y*tri.y)+(tri.z*tri.z)) 
				System.out.println("right");
			else if((tri.x*tri.x) + (tri.y*tri.y) == (tri.z*tri.z)) 
				System.out.println("right");
			else if((tri.x*tri.x) + (tri.z*tri.z) ==(tri.y*tri.y)) 
				System.out.println("right");
			else
				System.out.println("wrong");
			
			}
		}
	}
}
