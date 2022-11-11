package problem.백준.class4;

import java.util.Scanner;

public class 트리의순회_2263 {
	static int n;
	static int[]in, post, pre;
	static int idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		
		in = new int[n];
		post = new int[n];
		pre = new int[n];
		
		for(int i = 0; i<n; i++) in[i] = sc.nextInt();
		
		for(int i = 0; i<n; i++) post[i] = sc.nextInt();
		
		preOrder(0, n-1, 0, n-1);
		
		for(int num : pre) sb.append(num + " ");
		
		System.out.println(sb);
	}
	//is는 in의 시작 ps는 post의 시작
	private static void preOrder(int is, int ie, int ps, int pe) {
		// TODO Auto-generated method stub
		if(is <= ie && ps <= pe) {
			pre[idx++] = post[pe];
			
			int pos = is;
			for(int i = is; i <= ie; i++) {
				if(in[i] == post[pe]) {
					//루트노드 탐색
					pos = i;
					break;
				}
			}
			preOrder(is, pos-1, ps, ps + pos - is - 1);
			preOrder(pos+1, ie, ps + pos - is, pe - 1);
		}
	}
}
