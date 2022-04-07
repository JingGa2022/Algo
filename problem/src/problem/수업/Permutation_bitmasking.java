import java.util.Arrays;

public class Permutation_bitmasking {

	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static int N;

	public static void main(String[] args) {
		N = 3;
		nums = new int[] { 0, 1, 2 };
		result = new int[N];
		visited = new boolean[N];

		perm(0);

	}

	private static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < N; i++) {
			// 썼으면 쳐 내던지
			if (visited[i])
				continue;
			result[idx] = nums[i];
			visited[i] = true; //썼어
			perm(idx + 1);//내려가
			visited[i] = false;//안썼어

//			if(!visited[i]) {
//				//안썼으면 작성하던지
//			}
		}
	}

}
