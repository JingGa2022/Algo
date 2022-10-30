package problem.백준;

import java.util.Scanner;

public class 킹퀸룩비숍나이트폰_3003 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int king = sc.nextInt();
	System.out.print(1 - king + " ");

	int queen = sc.nextInt();
	System.out.print(1 - queen + " ");
	
	int look = sc.nextInt();
	System.out.print(2 - look + " ");
	
	int bishop = sc.nextInt();
	System.out.print(2 - bishop + " ");
	
	int knight = sc.nextInt();
	System.out.print(2 - knight + " ");
	
	int pawn = sc.nextInt();
	System.out.print(8 - pawn);
	}
}	
