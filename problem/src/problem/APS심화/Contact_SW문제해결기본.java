package problem.APS심화;

import java.util.Scanner;

public class Contact_SW문제해결기본 {
	static int N, start, ans;
	static int[] arr;
	static int[][] phone;
	static int[][] visited;//0번 인덱스에서 0은 미방문 1은 방문, 1번인덱스는 걸린시간
	static int[] save;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			ans = 0;
			phone = new int[N/2][2];
			visited = new int[101][2];
			
			//make set
			arr= new int [101+1];
			for(int i = 1; i<=100; i++) arr[i] = i;
			
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<2; j++) {
					phone[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i<E; i++) {
				int nx = find(phone[i][0]);
				int ny = find(phone[i][1]);
				
				if(nx != ny) {
	
					union(phone[i][0], phone[i][1]);
				
				}

			}
			
			System.out.println();
		}//tc
	}//main
	
	static int find(int x) {
		if(x == arr[x]) return x;
		else return arr[x] = find(arr[x]);
	}
	
	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return;
		
		arr[find(y)] = find(x);
	}
}
