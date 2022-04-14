import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로_크루스칼 {
	static int N; //섬의 갯수
//	static int[][] XY; //[0] : X좌표모음, [1] : Y좌표모음
	static int[] X, Y;
	static double E; //세율
	static double ans; 
	
	static int[] p; //내 대표를 저장할 배열
	
	static class Edge implements Comparable<Edge>{
		int st , ed;
		double cost;
		
		public Edge(int st, int ed) {
			this.st = st;
			this.ed = ed;
			this.cost = distance(st, ed);
		}

		//다양한 방식으로 비교해보장
		@Override
		public int compareTo(Edge o) {
			return this.cost > o.cost ? 1:-1;
		}
		
	}
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T  = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			X = new int[N]; //X좌표 모음
 			Y = new int[N]; //Y좌표 모음
			p = new int[N]; //대표
			
			ans = 0;
			pq.clear();
			
			for(int i = 0 ; i<N; i++)
				X[i] = sc.nextInt();
			for(int i = 0 ; i<N; i++)
				Y[i] = sc.nextInt();
			
			E = sc.nextDouble();
			
			//makeset
			for(int i = 1; i<N; i++)
				p[i]=i; 
			
			//간선을 몽땅 만들어서 죄다 pq 에 넣자.
			for(int i = 0 ; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					pq.add(new Edge(i, j));
				}
			}
			
//			크루스칼을 돌릴건데 간선을 몇개 뽑아야 하나요??? N-1개의 간선을 뽑아야해
			for(int i =  0 ; i<N-1; i++) {
				//힙에서 꺼낼거야 
				while(true) {
					Edge edge = pq.poll();
					int px = findSet(edge.st);
					int py = findSet(edge.ed);
					
					if(px!=py) {
						union(px, py);
						ans += edge.cost;
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(ans));
			
			
		}//tc
	}
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x; 
	}
	
	
	
	
	static double distance(int idx1, int idx2) {
		//두개의 좌표를 이용해서 가중치를 구했다.
		return (Math.pow(Math.abs(X[idx1]-X[idx2]), 2)+Math.pow(Math.abs(Y[idx1]-Y[idx2]), 2))*E;
	}
}















