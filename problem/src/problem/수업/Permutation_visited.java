import java.util.Arrays;

public class Permutation_visited {

	static int[] nums;
	static int[] result;
	static int N;

	public static void main(String[] args) {
		N = 3;
		nums = new int[] { 0, 1, 2 };
		result = new int[N];

		perm(0, 0);

	}

	private static void perm(int idx, int visited) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < N; i++) {
			//내가 현재 i번째 원소를 사용했는지 쳌
			if((visited & (1<<i)) != 0) {
				//해당 원소는 썼다.
				continue;
			}
			
			result[idx] = nums[i];
			// 52 박문철2 이거 가져가~~
			perm(idx+1, visited | 1 << i);
			
		}
	}

}
