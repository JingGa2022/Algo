package problem.수업;

import java.util.Arrays;

public class Permutation_visited {
	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static int N;
	static int ans = 0;
	
	public static void main(String[] args) {
		N = 9;
		nums = new int[] {0,1,2,3,4,5,6,7,8};
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
		System.out.println(ans);
	}
	private static void perm(int idx) {
		if(idx==2) {
//			System.out.println(Arrays.toString(result));
			ans ++;
			return;
		}
		
	
		for(int i =0; i<N; i++) {
		//썼으면 쳐 내던지
		if(visited[i]) continue;
		result[idx]=nums[i];
		visited[i] = true;
		perm(idx+1);
		visited[i]= false;
		}

	}
}
