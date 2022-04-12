
public class 분할정복03_이진검색_반복 {
	// boolean 반환 : 있는지 없는지 쳌
	// int 반환 : 해당 인덱스를 반환
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			
//			int mid2 = left + (right-left)/2; //오버플로우 막으려고 
			
			if (arr[mid] == key)
				return true;
			//여기 엄청나게 헷갈리니까 잘 정리해서 쓰세용
			else if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}

	public static void main(String[] args) {

		// 정렬이 되어 있다 라고 가정.
		int[] arr = { 1, 7, 9, 13, 19, 28, 31, 39, 41 };
		
		if(binarySearch(arr, 9)) {
			System.out.println("찾았다.");
		}else {
			System.out.println("못찾았다.");
		}
	}
}
