package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 특이한자석_모의SW테스트 {
	static int K;
	static LinkedList<Integer> mag1;
	static LinkedList<Integer> mag2;
	static LinkedList<Integer> mag3;
	static LinkedList<Integer> mag4;
	static int[][] dir;//회전방향을 저장하는
	static boolean[] stick;// n s가 딱 붙었는지
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			K = sc.nextInt();
			
			mag1 = new LinkedList<>();
			mag2 = new LinkedList<>();
			mag3 = new LinkedList<>();
			mag4 = new LinkedList<>();
			
			for(int i = 0; i<8; i++) {
				mag1.add(sc.nextInt());
			}
			for(int i = 0; i<8; i++) {
				mag2.add(sc.nextInt());
			}
			for(int i = 0; i<8; i++) {
				mag3.add(sc.nextInt());
			}
			for(int i = 0; i<8; i++) {
				mag4.add(sc.nextInt());
			}
				
			stick = new boolean[3];
			//
			dir = new int[K][2];// 0번째는 몇번째의 친구인지 1번쨰는 어느방향인지 1은 시계방향 -1은 반시계
			for(int i =0; i< K; i++) {
				for(int j =0; j<2; j++) dir[i][j] = sc.nextInt();
			}
			
			for(int i =0; i<K; i++) {
				isStick();//붙었나 확인
				rotate(dir[i][0], dir[i][1], 0);
			}
			score();
			
			System.out.println("#"+tc+" "+ans);
		}//tc
	}// main
	//th는 몇번째인지 d는 방향 from은 어디서왔는지 여부
	static void rotate(int th, int d , int from) {
		int tmp=0;
		switch (th) {
		case 1:
			//기본 도는 부분
			if(d == 1) { //시계방향으로 움직이는 것은 맨마지막 것을 0번인덱스로 옮김과 같다
			mag1.addFirst(mag1.getLast());
			mag1.removeLast();
			}else {//시계방향으로 움직이는 것은 0번째것을 마지막인덱스로 옮김과 같다
				mag1.addLast(mag1.getFirst());
				mag1.removeFirst();
			}
			//만약 붙었을때 영향을 주는 경우
			if(stick[0] == true && from == 0) rotate(2,-d, 1);
			break;

		case 2:
			//기본 도는 부분
			if(d == 1) { //시계방향으로 움직이는 것은 맨마지막 것을 0번인덱스로 옮김과 같다
				mag2.addFirst(mag2.getLast());
				mag2.removeLast();
			}else {//시계방향으로 움직이는 것은 0번째것을 마지막인덱스로 옮김과 같다
				mag2.addLast(mag2.getFirst());
				mag2.removeFirst();
			}
			
			//만약 붙었을때 영향을 주는 경우
			if(stick[1] == true &&stick[0] == true&& from == 0 ) {
				rotate(1,-d, 2);
				rotate(3,-d, 2);
			} else if(stick[1] == true && from == 0) rotate(3,-d,2);
			else if(stick[0] == true && from == 0) rotate(1,-d,2);
			if(stick[1] == true && from == 1) rotate(3,-d,2);
			if(stick[0] == true && from == 3) rotate(1,-d,2);
			break;
			
		case 3:
			//기본 도는 부분
			if(d == 1) { //시계방향으로 움직이는 것은 맨마지막 것을 0번인덱스로 옮김과 같다
				mag3.addFirst(mag3.getLast());
				mag3.removeLast();
			}else {//시계방향으로 움직이는 것은 0번째것을 마지막인덱스로 옮김과 같다
				mag3.addLast(mag3.getFirst());
				mag3.removeFirst();
			}
			
			//만약 붙었을때 영향을 주는 경우
			if(stick[1] == true &&stick[2] == true&& from == 0 ) {
				rotate(2,-d, 3);
				rotate(4,-d, 3);
			}
			else if(stick[1] == true && from == 0) rotate(2,-d,3);
			else if(stick[2] == true && from == 0) rotate(4,-d,3);
			if(stick[2] == true && from == 2) rotate(4,-d,3);
			if(stick[1] == true && from == 4) rotate(2,-d,3);
			break;
		
		case 4:
			//기본 도는 부분
			if(d == 1) { //시계방향으로 움직이는 것은 맨마지막 것을 0번인덱스로 옮김과 같다
				mag4.addFirst(mag4.getLast());
				mag4.removeLast();
			}else {//시계방향으로 움직이는 것은 0번째것을 마지막인덱스로 옮김과 같다
				mag4.addLast(mag4.getFirst());
				mag4.removeFirst();
			}
			
			//만약 붙었을때 영향을 주는 경우
			if(stick[2] == true && from == 0) rotate(3,-d,4);
			break;
		}
	}
	
	static void isStick() {
		if(mag1.get(2) != mag2.get(6)) {
			stick[0] = true; //붙어있음
		}else 
			stick[0] = false; //떨어져있음
		if(mag2.get(2) != mag3.get(6)) {
			stick[1] = true; //붙어있음
		}else 
			stick[1] = false; //떨어져있음
		if(mag3.get(2) != mag4.get(6)) {
			stick[2] = true; //붙어있음
		}else 
			stick[2] = false; //떨어져있음
			
		return;
	}
	
	static void score() {
		ans = 0;
		ans += mag1.get(0)+mag2.get(0)*2+mag3.get(0)*4+mag4.get(0)*8;
		
	}
}//class
