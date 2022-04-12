package problem.APS심화;

import java.util.Scanner;

public class 공통조상_1248 {
	static int[][] tree;
	static int ansCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();//정점의 수
			int E = sc.nextInt();//간선의 수
			int sv1 = sc.nextInt();//정점번호1
			int sv2 = sc.nextInt();//정점번호2
			int ansP;
			tree = new int[V+1][3];//트리 생성
			for(int i =1; i<=V; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				//왼자 확인후 비었다면 넣고 없으면 오자로 넣기
				if(tree[p][0] == 0) tree[p][0]=c;
				else tree[p][1] = c;
				tree[c][2] = p;//부모의 정보 저장			
			}
			int prev;
			int node = tree[sv1][2];
			tree [sv1][2] = 1;
			//sv1 모든 조상 처리
			while(node!=0) {
				prev = node;
				node = tree[prev][2];//이동 갱신
				tree[prev][2]=-1;//방문처리
			}
			//sv2를 시작으로 공통조상 찾기
			ansP = tree[sv2][2];
			
			while(tree[ansP][2]!= -1) {
				ansP = tree[ansP][2];
			}
			
			//사이즈 찾기
			ansCnt = 0;
			traversal(ansP);
			
			System.out.printf("%d %d %d\n",tc, ansP, ansCnt);
		}
	}//main
	//순회 메서드 작성
	public static void traversal(int T) {
		if(T !=0) {
			ansCnt++;
			traversal(tree[T][0]);
			traversal(tree[T][1]);
		}
	}
}
