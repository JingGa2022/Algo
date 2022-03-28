package problem.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.util.StringTokenizer;

public class DFS와BFS_1260 {
	static int[][] space;
	//해당 노드를 방문했는지 여부를 저장할 배열
	static boolean[] isVisited;
	// 출력 문자열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 개수
		int N = Integer.parseInt(st.nextToken());
		//간선의 개수
		int M = Integer.parseInt(st.nextToken());
		//시작번호
		int startNode = Integer.parseInt(st.nextToken());
		//공간 만들기
		space = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				space[x][y] = 1;
				space[y][x] = 1;
			}
		
		dfs(startNode);
		sb.append("\n");
		isVisited = new boolean[N+1];
		bfs(startNode);
		
		System.out.println(sb.toString());
		}
	
	private static void dfs(int startNode) {
		isVisited[startNode] = true;
			
		sb.append(startNode).append(" ");
		
		if(startNode == space.length - 1) {
			return;
		}
		
		for(int node = 0; node < space.length; node++) {
			if(space[startNode][node] == 1 && isVisited[node] == false) {
				dfs(node);
			}
		}
	}//dfs
	private static void bfs(int startNode) {
		isVisited[startNode] = true;
		//큐 생성하기
		Queue<Integer> que = new LinkedList<>();
		//큐에 스타트 노드 넣기
		que.add(startNode);
		sb.append(startNode).append(" ");
		
		while(!(que.size()==0)) {
			int tmp = que.poll();
			for(int node = 0; node < space.length; node++) {
				if(space[tmp][node] == 1 && isVisited[node] == false) {
				que.offer(node);
				isVisited[node] = true;
				sb.append(node).append(" ");
			}
		}}
	}//main
}
