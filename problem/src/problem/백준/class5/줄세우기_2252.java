package problem.백준.class5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[] num = new int[n+1];
		
		for(int i = 0; i<= n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			
			num[y] ++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i< n+1; i++) {
				if(num[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int student = q.poll();
			
			sb.append(student + " ");
			
			List<Integer> list = graph.get(student);
			
			for(int i = 0; i<list.size(); i++) {
				int tmp = list.get(i);
				num[tmp]--;
				
				if(num[tmp] == 0) q.add(tmp);
			}
		}
		
		System.out.println(sb);
	}
}
