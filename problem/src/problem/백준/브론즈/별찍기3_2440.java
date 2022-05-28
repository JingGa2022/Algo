package problem.백준.브론즈;

import java.util.Scanner;

public class 별찍기3_2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = N; i>0; i--) {
			String star = "";
			for(int j =0; j<N; j++) star += "*";
			star = star.substring(0, i);
			System.out.println(star);
		}
	}
}
