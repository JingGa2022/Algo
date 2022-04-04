package problem.수업;

import java.util.Arrays;

public class Permutation_swap {
	
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		N = 3;
		nums = new int[] {0,1,2};
		
		perm(0);
	}
	
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a]=nums[b];
		nums[b] = tmp;
		

		return;
	}
	//idx : 내가 판단흐는 위치
	static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		//자리를 바꾸면서 재ㅇ귀호출을 해본다.
		for(int i = idx; i <N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);//원상복구
		}
	}
}
