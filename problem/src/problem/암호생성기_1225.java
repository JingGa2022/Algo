package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			int T = sc.nextInt();
			Queue<Integer> psw = new LinkedList<>();
			for(int i = 0; i<8; i++) psw.offer(sc.nextInt());
			int stop = -1;
			int cnt = 0;
			while(stop !=0) {
				cnt++;
				stop = psw.poll() - cnt;
				if(stop<0) stop = 0;
				if(cnt == 5) cnt = 0;
				psw.offer(stop);
			}
			System.out.printf("#%d ", T);
			for(int i = 0; i<8; i++) System.out.print(psw.poll() + " ");
			System.out.println();
		}
	}
}
