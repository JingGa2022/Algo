package problem.수업;

import java.util.Arrays;

public class 분할정복07_퀵정렬_호어파티션 {
	public static void main(String[] args) {
		int[] arr = {7, 5, 30, 8, 11, 58, 4, 49, 8};
		
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int L = left+1, R = right;
		int tmp;
		while(L<=R) {
			//L : pivot 보다 큰값을 찾ㅇ르 때까지 이동하겠다.
			//요기 제한범위를 두지 않으면 인덱스 에러가 날수도
			while(L <=R && arr[L]<= pivot) L++;
			//R : pivot 보다 작거나같은 값을 만날때까지 이동하겠다.
			while(arr[R]>pivot) R--;
			//교차가 안됐다면 해볼것이 남았다.
			if(L < R) {
				tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		//pivot이 가리키는 값과 R이 가리키는 값을 바꾸어 pivot의 위치를 결정한다.
		tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
}
