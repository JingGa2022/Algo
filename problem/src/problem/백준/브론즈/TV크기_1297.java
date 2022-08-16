package problem.백준.브론즈;

import java.util.Scanner;

public class TV크기_1297 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		double common = Math.sqrt(Math.pow(d,2)/(Math.pow(h,2)+Math.pow(w,2)));
		int ansH = (int) Math.floor(common*h);
		int ansW = (int) Math.floor(common*w);
	
		System.out.print(ansH +" " + ansW);
	}
}
