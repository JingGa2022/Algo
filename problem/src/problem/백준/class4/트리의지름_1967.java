package problem.백준.class4;

import java.util.Scanner;

public class 트리의지름_1967 {
	static int n, maxL, maxR, ans;
	static int[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tree = new int[n+1][n+1];
		
		maxL = 0;
		maxR = 0;
		ans = 0;
		
		for(int i =0; i<n ;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int path = sc.nextInt();
			tree[from][to] = path;
		}
		System.out.println("여기까진 왔어요");
		dfs(1, 0, false);
		ans = maxL + maxR;
		
		System.out.println(ans);
	}
	// false면 왼쪽 true면 오른쪽
	private static void dfs(int from, int sum, boolean isRight) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		for(int i = 2; i<=n; i++) {
			if(tree[from][i] != 0) {
				if(from == 1) isRight = !isRight; 
				
				dfs(i, sum + tree[from][i], isRight);
				flag = true;
			}
		}
		if(!flag && isRight) {
			if(sum > maxR) maxR = sum;
		}else if(!flag && !isRight) {
			if(sum > maxL) maxL = sum;
		}
	}
}
