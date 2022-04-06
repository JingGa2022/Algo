package problem.백준.class1;

import java.util.Scanner;

public class 두수비교하기_1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[2];
		
		for(int i = 0; i<2; i++) num[i] = sc.nextInt();
		
		if(num[0] > num[1]) System.out.println(">");
		else if(num[0] < num[1]) System.out.println("<");
		else if(num[0] == num[1]) System.out.println("==");
	}
}
