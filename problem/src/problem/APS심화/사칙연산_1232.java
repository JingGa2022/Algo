package problem.APS심화;

import java.util.Scanner;

public class 사칙연산_1232 {
	static String[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			int N = sc.nextInt();
			tree = new String[N+1][];
			
			//입력받기
			sc.nextLine();
			for(int i = 1; i<= N; i++) {
				tree[i] = sc.nextLine().split(" ");
			}
			//1부터 시작하기 때문에 1부터 돌아볼것
			//int는 정수처리를 하기위함
			System.out.println("#"+tc+" "+(int)cal(1));
		}
	}
	//연산자를 받고 자식의 위치에 있는 값을 그 연산자로 계산함 
	//각각의 경우를 나누어 수행
	//아무것도 없다면 가진 노드의 숫자를 넘겨줌
	public static double cal(int node) {
		if(tree[node][1].equals("+"))
			return cal(Integer.parseInt(tree[node][2]))+cal(Integer.parseInt(tree[node][3]));
		else if(tree[node][1].equals("-"))
			return cal(Integer.parseInt(tree[node][2]))-cal(Integer.parseInt(tree[node][3]));
		else if(tree[node][1].equals("*"))
			return cal(Integer.parseInt(tree[node][2]))*cal(Integer.parseInt(tree[node][3]));
		else if(tree[node][1].equals("/"))
			return cal(Integer.parseInt(tree[node][2]))/cal(Integer.parseInt(tree[node][3]));
		else 
			return Double.parseDouble(tree[node][1]);
	}
}
