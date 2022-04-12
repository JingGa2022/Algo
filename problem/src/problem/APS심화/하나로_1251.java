package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 하나로_1251 {
	static class spot{
		int x;
		int y;
		public spot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int N;
	static double min, ans;
	static int[] arr;
	static double[][] edge;// 섬좌표 및 가장 가까운 거리값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();//섬의수
			edge = new double[N][3];
			ans = 0;
			
			//edge info
			for(int j =0; j<2; j++) {
				for(int i =0; i<N; i++) {
					edge[i][j] = sc.nextInt();
				}
			}
			
			double E = sc.nextDouble();
			
			System.out.println(Arrays.deepToString(edge));
			
			for(int i =0; i<N; i++) {
				min = Double.MAX_VALUE;
				for(int j =i; j<N; j++) {
					double a = Math.pow(edge[i][0] - edge[j][0], 2);
					double b = Math.pow(edge[i][1] - edge[j][1], 2);
					if(min > a+b) {
						min = a+b;
						edge[i][2] = min;
					}
				}
				ans += min;
			}
			
			System.out.println(ans);
			
		}//tc
	}//main
	
	static int find(int x) {
		if(x != arr[x]) return arr[x] = find(arr[x]);
		return x;
	}
	
	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return;
		
		arr[ny] = nx;
		
	}
}//class
