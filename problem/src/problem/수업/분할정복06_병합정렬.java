import java.util.Arrays;

public class 분할정복06_병합정렬 {
	static int[] sortedArr;

	public static void merge(int[] arr, int left, int mid, int right) {
		int L = left; // 왼쪽절반 시작위치
		int R = mid + 1; // 오른쪽절반 시작위치
		int idx = left; // 정렬된 원소를 저장할 위치

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for (int j = R; j <= right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}

		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
		System.out.println(left + "부터 " + right + "까지 병합정렬");
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid); // 왼쪽 절반 분할
			mergeSort(arr, mid + 1, right); // 오른쪽 절반 분할
			merge(arr, left, mid, right); // 분할된 집합 정렬 후 병합
		}
	}

	public static void main(String[] args) {
		int[] arr = { 7, 5, 4, 1, 2, 10, 3, 6, 9, 8 };
		sortedArr = new int[arr.length];
		System.out.println("정렬 수행 전: " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("정렬 수행 후: " + Arrays.toString(arr));
	}
}
