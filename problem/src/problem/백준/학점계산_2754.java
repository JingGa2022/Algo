package problem.백준;

import java.util.Scanner;

public class 학점계산_2754 {
	static enum score{
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			String s = sc.next();
			double point = 0;
			
			switch(s) {
			  case "A+":
	                point = 4.3;
	                break;
	            case "A0":
	                point = 4.0;
	                break;
	            case "A-":
	                point = 3.7;
	                break;
	            case "B+":
	                point = 3.3;
	                break;
	            case "B0":
	                point = 3.0;
	                break;
	            case "B-":
	                point = 2.7;
	                break;
	            case "C+":
	                point = 2.3;
	                break;
	            case "C0":
	                point = 2.0;
	                break;
	            case "C-":
	                point = 1.7;
	                break;
	            case "D+":
	                point = 1.3;
	                break;
	            case "D0":
	                point = 1.0;
	                break;
	            case "D-":
	                point = 0.7;
	                break;
	            case "F":
	                point = 0.0;
	                break;
			}
			System.out.println(point);
	}
}
