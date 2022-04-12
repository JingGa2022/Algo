package problem.백준.class1;

import java.util.Scanner;

public class 음계_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int check = 2; // 0이면 as 1이면 des 2면 mixed

		int[] box = new int[8];
		for (int i = 0; i < 8; i++)
			box[i] = sc.nextInt();

		for (int i = 1; i < 8; i++) {
			if (box[i - 1]+1 == box[i])
				check = 0;
			else if (box[i - 1] == box[i]+1)
				check = 1;
			else {
				check = 2;
				break;
			}
		}

		if (check == 0)
			System.out.println("ascending");
		else if (check == 1)
			System.out.println("descending");
		else if (check == 2)
			System.out.println("mixed");
	}
}
