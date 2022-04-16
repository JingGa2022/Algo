package problem.APS심화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 하나로_1251 {
	static class Edge implements Comparable<Edge>{
		int from, to;
		double w;
		
		
		public Edge(int from, int to, double w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}


		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
		
		
	}
	static int N;
	static double min, ans;
	static int[] arr;
	static double[][] edge;// 섬좌표 및 가장 가까운 거리값
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();//섬의수
			edge = new double[N][3];
			ans = 0;
			arr = new int[N+1];
			edgeList = new ArrayList<>();
			//make set
			for(int i = 0; i<N; i++) arr[i] = i;
			
			//edge info
			for(int j =0; j<2; j++) {
				for(int i =0; i<N; i++) {
					edge[i][j] = sc.nextInt();
				}
			}
			
			double E = sc.nextDouble();
			
			
			
			for(int i =0; i<N; i++) {
				min = Double.MAX_VALUE;
				for(int j =i; j<N; j++) {
					double a = Math.pow(edge[i][0] - edge[j][0], 2);
					double b = Math.pow(edge[i][1] - edge[j][1], 2);
					edgeList.add(new Edge(i, j, a+b));
				}
			}
			
			edgeList.sort(null);
			
			int cnt = 0;
			for(int i =0; i<edgeList.size(); i++) {
				if(union(edgeList.get(i).from, edgeList.get(i).to)) {
					ans += edgeList.get(i).w;
					if(++cnt == N-1) break;
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(ans*E));
			
		}//tc
	}//main
	
	static int find(int x) {
		if(x != arr[x]) return arr[x] = find(arr[x]);
		return x;
	}
	
	static boolean union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx == ny) return false;
		
		arr[ny] = nx;
		return true;
	}
}//class
