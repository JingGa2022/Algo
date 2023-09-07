package problem.백준.실버;

import java.util.*;

public class 스타트링크_5014 {
	static int f, s, g, u, d, ans;
	static int[] building;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		f = sc.nextInt();
		building = new int[f+1];
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		System.out.print(BFS()? ans : "use the stairs");
	}
	static boolean BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		int visited[] = new int[f+1];
		visited[s] = 1;
		
		while(!q.isEmpty()) {
			int floor = q.poll();
			if(floor == g) {
				ans = visited[g]-1;
				return true;
			}
			
				int tmp = floor + u;
				if(tmp <= f && visited[tmp] == 0) {
					visited[tmp] = visited[floor] + 1;
					q.add(tmp);
				}
				
				tmp = floor - d;
				if(tmp >= 1 && visited[tmp] == 0) {
					visited[tmp] = visited[floor] + 1;
					q.add(tmp);
				}
		}
		
		return false;
	}
}
