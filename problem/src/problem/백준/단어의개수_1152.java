package problem.백준;

import java.util.Scanner;

public class 단어의개수_1152 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] text = sc.nextLine().trim().split(" ");
		if(text[0].equals(""))
			System.out.println(text.length-1);		
		else
		System.out.println(text.length);
	}
}
