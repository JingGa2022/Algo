package problem.수업;

import java.util.Arrays;

public class Combication1 {
	static int[] data;
	static int[] sel;
	static int N, R;//N개중 R개를 뽑자.
	
	public static void main(String[] args) {
		data = new int[] {10, 11, 12, 13, 14};
		N = data.length;
		R = 3;
		sel = new int[R];
		
		nCr(0,0);
	}//main
	//idx:실제 data배열의 인덱스,  sidx : sel배열의 인덱스
	static void nCr(int idx, int sidx) {
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
		}else if(idx == N){
			//다뽑지못했는데 더이상 넣을지 말지 할 원소가 없다.
			return;
		}else {
			sel[sidx] = data[idx];
			nCr(idx+1, sidx+1);//뽑고 가고
			nCr(idx+1, sidx);//안뽑고가고
		}
	}
}
