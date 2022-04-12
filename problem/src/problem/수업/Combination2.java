import java.util.Arrays;

public class Combination2 {
	static int[] data; // 정수형 자료형의 모임.
	static int[] sel; // 내가 뽑은 것들을 저장할 배열
	static int N, R; // N개중 R개를 뽑자.

	public static void main(String[] args) {
		data = new int[] { 10, 11, 12, 13, 14 };
		N = 5;
		R = 3;
		sel = new int[R]; // R개의 값을 저장할 배열
//		5C3 = ?

		comb(0, 0);
	}// main

	// idx: 실제 data 배열의 인덱스, sidx: sel 배열의 인덱스
	static void comb(int idx, int sidx) {
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for(int i = idx ; i<=N-R+sidx; i++) {
			sel[sidx] = data[idx];
			comb(i+1, sidx + 1); // 뽑고 가고
		}
	}
}
