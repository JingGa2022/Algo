package problem.백준.class3;

import java.util.Scanner;

public class 카잉달력_6064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 0; t<tc; t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			boolean check = false;
			
			for(int i = x; i<= m*n; i+=m) {
				if(i % n == y) {
					System.out.println(i+1);
					check = true;
					break;
				}
			}
			if(!check) System.out.println(-1);
		}
	}
}
