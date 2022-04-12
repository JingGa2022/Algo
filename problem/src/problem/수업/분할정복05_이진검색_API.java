import java.util.Arrays;

public class 분할정복05_이진검색_API {
	public static void main(String[] args) {

		// 정렬이 되어 있다 라고 가정.
		int[] arr = { 1, 7, 9, 13, 19, 28, 31, 39, 41 };
		
		System.out.println(Arrays.binarySearch(arr, 14));
		
		
//		if (binarySearch(arr, 0, arr.length - 1, 4)) {
//			System.out.println("찾았다.");
//		} else {
//			System.out.println("못찾았다.");
//		}
	}
}
