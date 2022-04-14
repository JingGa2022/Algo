package problem.수업;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라1 {
	static class Node {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList; // 인접 리스트
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 0번부터 쓸거에요.
		E = sc.nextInt();

		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Node(ed, w));// 인접리스트 넣기. //유향 그래프이니까.
		}

		dijkstra(0);

		System.out.println(Arrays.toString(dist));

	}

	static void dijkstra(int st) {
		// 박문철2
		boolean[] visited = new boolean[V];

		// 시작 노드까지의 거리는 0
		dist[st] = 0;

		// V까지 도는것, V-1까지 도는것에 대한 차이를 한번 찐하게 생각해보자.
		for (int i = 0; i < V - 1; i++) {
			int minidx = -1;
			int minValue = INF;
			// 선택하지 않은 정점중 dist가 가장 짧은것을 골라.
			for (int j = 0; j < V; j++) {
				if (!visited[j] && minValue > dist[j]) {
					minValue = dist[j];
					minidx = j;
				}
			}
			// 연결되지 않은 경우도 있으므로
			if (minidx == -1)
				break;
			visited[minidx] = true;

			for (int j = 0; j < adjList[minidx].size(); j++) {
				Node cur = adjList[minidx].get(j);
				// 연결되었으면서 방문하지않았고 이미가지고 있는 값과 지금값 + 이동할값을 더한값이 더 작다면 갱신
				if (!visited[cur.v] && dist[cur.v] > dist[minidx] + cur.weight)
					dist[cur.v] = dist[minidx] + cur.weight;
			}
		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
