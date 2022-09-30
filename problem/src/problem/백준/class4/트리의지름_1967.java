package problem.백준.class4;

import java.util.ArrayList;
import java.util.Scanner;


public class 트리의지름_1967 {
	static class Node{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	static int n, max, ans;
	static ArrayList<Node>[] tree;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tree = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		ans = 0;
		
		for(int i = 0 ;i <=n ;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i =0; i<n-1 ;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int path = sc.nextInt();
			tree[from].add(new Node(to, path));
			tree[to].add(new Node(from, path));
		}
		visit[1] = true;
		dfs(1, 0);
		
		visit = new boolean[n+1];
		visit[max] = true;
		dfs(max, 0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int from, int sum) {
		// TODO Auto-generated method stub
		if(sum > ans) {
			ans =  sum;
			max = from;
		}
		for(Node node: tree[from]) {
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, sum + node.weight);
			}
		}
	}
}
