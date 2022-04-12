import java.util.Arrays;

public class 분할정복08_퀵정렬_로무토파티션 {
	public static void main(String[] args) {
		int[] arr = {7,5,40,11,8,8,56,39};
		
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
		int pivot = arr[right];
		int i = left -1; //i pivot보다 작은값의 경계를 가리킨다.
		
		for(int j = left; j<right; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		//pivot을 자기 위치로 보내기 위해서 정렬을 하겠당.
		swap(arr, i+1, right);
		return i+1;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
}
