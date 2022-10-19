package problem.백준;

import java.util.Scanner;

public class 참외밭_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[6];
		
		int Bx = 0;
		int By = 0;
		
		int indexX = 0, indexY = 0;
		
		for(int i = 0; i<6; i++) {
			int edge = sc.nextInt();
			int len = sc.nextInt();
			
			arr[i]=len;
			
			if(edge == 4 || edge == 3) {
				By = Math.max(len, By);
				if(By == len) indexY = i;
			}else if(edge == 1 || edge == 2) {
				Bx = Math.max(len, Bx);
				if(Bx == len) indexX = i;
			}
			
		}
		//북 4 서 2 남 3 동 1
		int nextR1 = arr[5], nextC1 = arr[5];
		int nextR2 = arr[0], nextC2 = arr[0];
		if(indexX - 1 > -1) nextR1 = arr[indexX - 1];
		if(indexX + 1 < 6) nextR2 = arr[indexX + 1];
		if(indexY - 1 > -1) nextC1 = arr[indexY - 1];
		if(indexY + 1 < 6) nextC2 = arr[indexY + 1];
		
		int box = Bx * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2)*(By - (Math.min(nextR1, nextR2)));
		
		System.out.println(box * n);
	}
}
