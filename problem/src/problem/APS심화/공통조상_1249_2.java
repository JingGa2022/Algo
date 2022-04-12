package problem.APS심화;

import java.util.Scanner;

public class 공통조상_1249_2 {
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
			tree = new int[V+1][3];//트리 생성 0왼자 1오자 2 자식입장에서 부모
			for(int i = 0; i<E; i++) {
				int P = sc.nextInt();//부모
				int C = sc.nextInt();//자식
				if(tree[P][0] ==0) tree[P][0]=C;
				else tree[P][1] = C;
				tree[C][2] = P;
			}
			
			int tmp;
			int node = tree[sv1][2];
			while(node!=0) {
				tmp = node;
				node = tree[tmp][2];
				tree[tmp][2] = -1;
			}
			ansP = tree[sv2][2];
			
			while(tree[ansP][2]!=-1) {
				ansP = tree[ansP][2];
			}
			
			ansCnt = 0;
			isSize(ansP);
			
			System.out.println("#"+tc+" " +ansP +" "+ ansCnt);
		}//for
		
		}//main
	public static void isSize(int s) {
		if(s!=0) {
		ansCnt++;
		isSize(tree[s][0]);
		isSize(tree[s][1]);
		
		}
	}
}
