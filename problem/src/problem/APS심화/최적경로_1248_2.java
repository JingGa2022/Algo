package problem.APS심화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최적경로_1248_2 {
	static class Spot {
		int x;
		int y;

		public Spot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static Spot com;
	static Spot home;
	static Spot[] customer;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			customer = new Spot[N];
			
			com = new Spot(sc.nextInt(), sc.nextInt());// 회사의 좌표 3
			home = new Spot(sc.nextInt(), sc.nextInt());// 집의 좌표 4

			for (int i = 0; i < N; i++)
				customer[i] = new Spot(sc.nextInt(), sc.nextInt());

			perm(0);
			
			System.out.println("#"+ tc +" "+ans);
		}
	}// main

	static void perm(int idx) {
		if(idx == N) {
			shortcut(customer);
			return;
		}
		for(int i = idx; i<N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
	}
	
	private static void shortcut(Spot[] customer) {
		int sum = 0;
		//회사에서 첫 고객까지
		sum += Math.abs(com.x - customer[0].x) + Math.abs(com.y - customer[0].y);
		//각 고객간
		for(int i =1; i < N; i++) 
			sum += Math.abs(customer[i].x - customer[i-1].x) + Math.abs(customer[i].y - customer[i-1].y);
		//마지막 고객에서 집까지
		sum += Math.abs(home.x - customer[N-1].x) + Math.abs(home.y - customer[N-1].y);
		
		if(sum < ans) ans = sum;
	}

	static void swap(int a, int b) {
		Spot tmp = customer[a];
		customer[a] = customer[b];
		customer[b] = tmp;
	}

}// class
