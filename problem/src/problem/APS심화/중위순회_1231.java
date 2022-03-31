package problem.APS심화;

import java.util.Arrays;
import java.util.Scanner;

public class 중위순회_1231 {
	static String[][] tree;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder();
			N = sc.nextInt();// 정점의 수
			tree = new String[N + 1][3]; // 0문자 1 왼자 2 오자
			for (int i = 1; i <= N; i++) {
				int num = sc.nextInt();
				String alp = sc.next();
				tree[num][0] = alp;
				if (i < N / 2) {
					tree[num][1] = sc.next();
					tree[num][2] = sc.next();
				} else if (i == N / 2) {
					if (N % 2 == 0)
						tree[num][1] = sc.next();
					else if (N % 2 != 0) {
						tree[num][1] = sc.next();
						tree[num][2] = sc.next();
					}
				}
			}
			search(1);
			
			System.out.println("#" + tc +" "+ sb);
		}
	} // main
	
	private static void search(int node) {
		System.out.println(node);
		if(tree[node][0]!=null) {
			if(tree[node][1]!=null)
			search(Integer.parseInt(tree[node][1]));
			sb.append(tree[node][0]);
			if(tree[node][2]!=null)
			search(Integer.parseInt(tree[node][2]));
		}
	}
}
