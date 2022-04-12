package problem.보충반;

import java.util.Scanner;

public class 사칙연산_1232 {
	
	static String[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <=10; tc++) {
			int N = sc.nextInt();
			
			tree = new String[N+1][];
			sc.nextLine();//캐리지리턴버리기  입력을 비워주는 것
			for(int i =1; i<=N; i++) {
				tree[i] = sc.nextLine().split(" ");
			}//입력처리
			
			System.out.println("#" + tc+" "+(int)op(1));
		}
	}
	private static double op(int idx) {

		if (tree[idx][1].equals("+"))//
			return op(Integer.parseInt(tree[idx][2]))+ op(Integer.parseInt(tree[idx][3]));
		else if(tree[idx][1].equals("-"))//
		return op(Integer.parseInt(tree[idx][2]))- op(Integer.parseInt(tree[idx][3]));
		else if(tree[idx][1].equals("*"))//
		return op(Integer.parseInt(tree[idx][2]))* op(Integer.parseInt(tree[idx][3]));
		else if(tree[idx][1].equals("/"))//
		return op(Integer.parseInt(tree[idx][2]))/ op(Integer.parseInt(tree[idx][3]));
		else //숫자일때
			return Double.parseDouble(tree[idx][1]);
	}
}
