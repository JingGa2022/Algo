package problem.삼성sw역량테스트;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class 뱀_3190 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N,K,L, ans;
	static boolean[][] body;
	static int[][] arr;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//보드의 크기
		K = sc.nextInt();//사과의 개수
		ans = 0;//시간
		
		arr = new int[N+2][N+2];
		body = new boolean[N+2][N+2];//몸이 있는곳
		
		for(int i = 0; i<=N+1; i++)
			Arrays.fill(arr[i], -1);
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				arr[i][j] = 0;
			}
		}
		
		for(int i =0; i<K; i++) {
			arr[sc.nextInt()][sc.nextInt()] = 5; // 5는 사과
		}
		
		L = sc.nextInt();
		
		time = new int[10001];
		
		for(int i = 0 ; i<L; i++) {
				int tmp = sc.nextInt();
				String s = sc.next();
				if(s.equals("D"))
					time[tmp] = 1;//오른쪽
				else
					time[tmp] = 3;//왼쪽
		}
		
		move();
		
		System.out.println(ans);
	}
	private static void move() {
		// TODO Auto-generated method stub
		int direct = 0;//0 우, 1 하, 2 좌, 3 상
		//대가리
		int hx = 1;
		int hy = 1;
		//몸 길이
		int length = 1;
		body[hx][hy] = true;
		
		Deque<Integer> dx = new ArrayDeque<>();
		Deque<Integer> dy = new ArrayDeque<>();
		
		dx.add(hx); dy.add(hy);
		
		while(true) {
			ans++;
			
			hx += dr[direct];
			hy += dc[direct];
			
			if(arr[hx][hy] == -1 || body[hx][hy])
				break;
			
			dx.add(hx);
			dy.add(hy);
			
			if(arr[hx][hy] == 5) {
				arr[hx][hy] = 0;
				length++;
			}else {
				body[dx.pollFirst()][dy.pollFirst()] = false;
			}
			body[hx][hy] = true;
			
			if(time[ans] != 0) direct = (direct + time[ans]) % 4;
			
//			System.out.println("시간 : " + ans);
//			for(int i = 0; i<=N+1; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			for(int i = 0; i<=N+1; i++) {
//				System.out.println(Arrays.toString(body[i]));
//			}
		}
	}
}
